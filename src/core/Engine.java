package core;

import GameObjects.*;
import enums.*;
import helper.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;


//TODO too much logic is handled by Engine, try to extract some logic to other classes
// also possibly split Engine into smaller engine classes (f.e. MatchEngine, PlayerEngine, NewsEngine, TransferMarketEngine, ...)

/**
 * Handles stuff which none of the other engines are responsible for (Player, Match, TransferMarket, News)
 * <br>See also:<br>
 * <ul>
 *     <li>{@link PlayerEngine}</li>
 *     <li>{@link MatchEngine}</li>
 *     <li>{@link TransferMarketEngine}</li>
 *     <li>{@link NewsEngine}</li>
 * </ul>
 */
public class Engine {
    private final static Random rand = new Random(System.nanoTime());
    private static Club clubToManage;
    private final static Map<Country, List<League>> countriesWithLeagues = LeagueHelper.getCountriesThatHaveLeagues();
    private final static Map<League, List<Club>> playableLeagues = LeagueHelper.getPlayableLeagues();

    private static List<Match> matchesThisSeason;

    private static int currentRound = 0;

    private static List<JobOffer> jobOffers = new ArrayList<>(); //TODO add Job offers

    private static LeagueTable table;

    private static List<Player> currentSquad;

    public static void endCurrentSeason(int season) {
        PlayerEngine.checkForPlayerRetirement(season);

        //TODO implement methods below
        //checkForClubLeagueUpgrade();
        //checkForClubLeagueDowngrade();
        //checkForBallonDOr();
    }

    public static void startNewSeason(int newSeason) {
        resetRound();
        PlayerEngine.checkPlayersJoiningFromAcademy(clubToManage);
        //updateMarketValues(); TODO see issue 'transfer market'
        //updateTransferMarket(); TODO see issue 'transfer market'
        //updatePlayerRatings();
    }

    public static void initSquad(Club club) {
        currentSquad = new ArrayList<>();
        currentSquad.addAll(PlayerHelper.getPlayersForClub(club));
    }

    public static void updateSquad(Player toRemove, Player toAdd, Player toUpdate) {
        if (toAdd != null) {
            currentSquad.add(toAdd);
        }

        for (int i = 0; i < currentSquad.size(); i++) {
            if (currentSquad.get(i).equals(toRemove)) {
                currentSquad.remove(i);
            } else if (currentSquad.get(i).equals(toUpdate)) {
                currentSquad.set(i, toUpdate);
            }
        }
    }

    public static void initMatchesForSeason(Club club) {
        List<Match> result = new ArrayList<>();

        League league = club.getLeague();
        List<Club> clubsInLeague = ClubHelper.getClubsForLeague(league);

        for (int homeIndex = 0; homeIndex < clubsInLeague.size(); homeIndex++) {
            for (int awayIndex = homeIndex; awayIndex < clubsInLeague.size(); awayIndex++) {
                if (clubsInLeague.get(homeIndex).equals(clubsInLeague.get(awayIndex))) {
                    continue;
                }
                result.add(new Match(clubsInLeague.get(homeIndex), clubsInLeague.get(awayIndex), null));
                result.add(new Match(clubsInLeague.get(awayIndex), clubsInLeague.get(homeIndex), null));
            }
        }

        matchesThisSeason = shuffleMatches(result);
        //return shuffleMatches(result);
    }

    public static void simulateMatches(int round) {
        //TODO rework algorithm so that in every round, there is the same amount of matches

        List<Club> clubsInLeague = ClubHelper.getClubsForLeague(clubToManage.getLeague());
        int matchesInRound = (clubsInLeague.size() - round) * 2; //number of matches per round decreases (10 clubs --> 18, 16, 14, 12,...)

        for (int i = 0; i < matchesInRound; i++) {
            simulateMatch(matchesThisSeason.get(i), false);
        }
    }

    public static void simulateMatch(Match match, boolean isOwnClub) {
        Club home = match.getHome();

        double[] goalChances = Engine.calcGoalChances(match);
        double ownChance = (goalChances[0] / 20);
        double opponentChance = ownChance + (goalChances[1] / 20);

        Score score = new Score(0, 0, new HashMap<>());
        Map<Player, List<Integer>> scorers = new HashMap<>();
        Club opponent = Engine.getOpponent(match);

        int ownGoals = 0;
        int opponentGoals = 0;

        for (int minute = 1; minute <= 90; minute++) {
            double randomNumber = rand.nextDouble(100);

            if (randomNumber <= ownChance) {
                Engine.updateMatchScore(home, minute, scorers, score, isOwnClub);
                ownGoals++;
            } else if (randomNumber <= opponentChance) {
                Engine.updateMatchScore(opponent, minute, scorers, score, isOwnClub);
                opponentGoals++;
            }
        }

        PlayerEngine.checkForPlayerLevelUp(match, isOwnClub);

        score.setScoreHome(ownGoals);
        score.setScoreAway(opponentGoals);
        match.setScore(score);
    }

    public static List<Match> getMatchesForRound(int round, Club club, List<Match> matchesThisSeason) {
        List<Match> matchesThisRound = new ArrayList<>();
        List<Club> clubsInLeague = ClubHelper.getClubsForLeague(club.getLeague());
        int amountOfMatches = (clubsInLeague.size() - round) * 2;
        int startIndex = getStartIndex(round, club);

        for (int i = startIndex; i < (startIndex + amountOfMatches); i++) {
            matchesThisRound.add(new Match(matchesThisSeason.get(i).getHome(), matchesThisSeason.get(i).getAway(), null));
        }

        return matchesThisRound;
    }

    private static int getStartIndex(int round, Club club) {
        int leagueSize = ClubHelper.getClubsForLeague(club.getLeague()).size();

        int alreadyPlayed = 0;

        while (round-- >= 0) {
            alreadyPlayed += (leagueSize - round) * 2;
        }

        return alreadyPlayed;
    }

    public static Match getNextMatch() {
        for (Match m : matchesThisSeason) {
            if (m.getScore() != null) {
                continue;
            }
            if (m.getHome().equals(clubToManage) || m.getAway().equals(clubToManage)) {
                return m;
            }
        }
        return null;
    }

    public static void initTable(Club club) {
        League league = club.getLeague();

        table = new LeagueTable(league, new HashMap<>());
        for (Club c : ClubHelper.getClubsForLeague(league)) {
            table.getPoints().put(c, 0);
        }
    }

    public static void updateTable(List<Match> round) {
        //TODO There's a bug in the points calculation (a team can get more than 3 points after a round)
        // (maybe also has to do with how matches for a round get generated)

        League league = round.get(0).getHome().getLeague();
        for (Match m : round) {
            Club home = m.getHome();
            Club away = m.getAway();
            Integer homePoints = table.getPoints().get(home);
            Integer awayPoints = table.getPoints().get(away);
            if (m.getWinner() == null) {
                table.getPoints().put(home, homePoints + 1);
                table.getPoints().put(away, awayPoints + 1);
            } else if (m.getWinner().equals(home)) {
                table.getPoints().put(home, homePoints + 3);
            } else if (m.getWinner().equals(away)) {
                table.getPoints().put(away, awayPoints + 3);
            }
        }
        sortTable(league);
    }

    private static List<Match> shuffleMatches(List<Match> toShuffle) {
        List<Match> shuffled = new ArrayList<>();

        while (!toShuffle.isEmpty()) {
            Match m = toShuffle.get(rand.nextInt(toShuffle.size()));
            shuffled.add(m);
            toShuffle.remove(m);
        }
        return shuffled;
    }

    private static void sortTable(League league) { //TODO not sure if this method works as intended
        LeagueTable sorted = new LeagueTable(league, new HashMap<>());
        LeagueTable tmp = sorted;
        Integer highest = 0;

        while (!tmp.getPoints().isEmpty()) {
            Club best = null;
            for (Club c : table.getPoints().keySet()) {
                if (table.getPoints().get(c) > highest) {
                    highest = table.getPoints().get(c);
                    best = c;
                }
            }
            sorted.getPoints().put(best, highest);
            tmp.getPoints().remove(best);
        }
    }

    public static Player getScorer(List<Player> players) {
        int multiplierAttack = 4;
        int multiplierControl = 3;
        int multiplierDefense = 2;

        Player candidate = null;
        double highestChance = 0;
        for (Player p : players) {
            double chance = 0;
            if (p.getPosition().getType().equals("ATT")) {
                chance = (multiplierAttack * p.getRating() + p.getAttack()) * rand.nextDouble(20);
            } else if (p.getPosition().getType().equals("CON")) {
                chance = (multiplierControl * p.getRating() + p.getAttack()) * rand.nextDouble(20);
            } else if (p.getPosition().getType().equals("DEF")) {
                chance = (multiplierDefense * p.getRating() + p.getAttack()) * rand.nextDouble(20);
            }
            if (chance > highestChance) {
                highestChance = chance;
                candidate = p;
            }
        }

        return candidate;
    }

    public static void startNextMatch() {
        currentRound++;

        Match nextMatch = Engine.getNextMatch();
        PrintHelper.printNewLine(11);
        System.out.println("------ " + nextMatch.getHome().getName() + "  VS.  " + nextMatch.getAway().getName() + " ------");
        try {
            TimeUnit.MILLISECONDS.sleep(4000);

            double[] goalChances = Engine.calcGoalChances(nextMatch);
            double ownChance = (goalChances[0] / 20);
            double opponentChance = ownChance + (goalChances[1] / 20);

            Score score = new Score(0, 0, new HashMap<>());
            Map<Player, List<Integer>> scorers = new HashMap<>();
            Club opponent = Engine.getOpponent(nextMatch);

            int ownGoals = 0;
            int opponentGoals = 0;

            for (int minute = 1; minute <= 90; minute++) {
                double randomNumber = rand.nextDouble(100);
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + minute + "'");

                if (randomNumber <= ownChance) {
                    scorers = Engine.updateMatchScore(Engine.getClubToManage(), minute, scorers, score, true);
                    ownGoals++;
                } else if (randomNumber <= opponentChance) {
                    scorers = Engine.updateMatchScore(Engine.getOpponent(nextMatch), minute, scorers, score, true);
                    opponentGoals++;
                }

                TimeUnit.MILLISECONDS.sleep(200);
            }

            System.out.println("MATCH END!");
            PrintHelper.printGoalsList(scorers, opponent);

            System.out.println("\n");
            System.out.println(Engine.getClubToManage().getName() + " ... " + (nextMatch.getHome().equals(Engine.getClubToManage()) ? ownGoals : opponentGoals) +
                    " : " + (nextMatch.getHome().equals(opponent) ? ownGoals : opponentGoals) + " ... " + opponent.getName());

            PlayerEngine.checkForPlayerLevelUp(nextMatch, true);

            score.setScoreHome(ownGoals);
            score.setScoreAway(opponentGoals);
            nextMatch.setScore(score);

            Engine.simulateMatches(currentRound);
            Engine.updateTable(Engine.getMatchesForRound(currentRound, Engine.getClubToManage(), Engine.getMatchesThisSeason()));
            PrintHelper.printHomeMenu();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static Map<Player, List<Integer>> updateMatchScore(Club club, int minute, Map<Player, List<Integer>> scorers, Score score, boolean isOwnClub) {
        Player scorer = Engine.getScorer(PlayerHelper.getPlayersForClub(club));
        scorer.setGoals(scorer.getGoals() + 1);
        scorers = updateScorers(scorers, scorer, minute);
        score.getScorers().put(scorer, score.getScorers().get(scorer) == null ? 1 : score.getScorers().get(scorer) + 1);
        if (isOwnClub) {
            PrintHelper.printScoredGoal(scorer, minute);
        }
        return scorers;
    }

    public static double[] calcGoalChances(Match match) {
        int[] ownStats = ClubHelper.getStatsForClub(clubToManage);
        int[] opponentStats = ClubHelper.getStatsForClub(getOpponent(match));

        double ownTotal = ownStats[0] + (0.5 * ownStats[2]) + (0.2 * ownStats[1]);
        double opponentTotal = opponentStats[0] + (0.5 * opponentStats[2]) + (0.2 * opponentStats[1]);
        double total = ownTotal + opponentTotal;

        double ownChance = (ownTotal * 100) / total;
        double opponentChance = (opponentTotal * 100) / total;

        return new double[]{ownChance, opponentChance};
    }

    // ------- PRIVATE METHODS -------

    private static Map<Player, List<Integer>> updateScorers(Map<Player, List<Integer>> scorers, Player scorer, Integer minute) {
        if (scorers == null || scorer == null || minute == null) {
            throw new IllegalArgumentException("Cannot update scorers (null value)");
        }

        if (!scorers.containsKey(scorer)) {
            scorers.put(scorer, new ArrayList<>());
        }
        scorers.get(scorer).add(minute);

        return scorers;
    }

    //GETTER METHODS

    public static Map<Country, List<League>> getCountriesWithLeagues() {
        return countriesWithLeagues;
    }

    public static Map<League, List<Club>> getPlayableLeagues() {
        return playableLeagues;
    }

    public static LeagueTable getTable() {
        return table;
    }

    public static List<JobOffer> getJobOffers() {
        return jobOffers;
    }

    //TODO MOVE TO MATCHENGINE
    public static Club getOpponent(Match match) {
        return match.getHome().getName().equals(clubToManage.getName()) ? match.getAway() : match.getHome();
    }

    public static List<Match> getMatchesThisSeason() {
        return matchesThisSeason;
    }

    public static Club getClubToManage() {
        return clubToManage;
    }

    public static void setClubToManage(Club club) {
        if (club == null || club.equals(clubToManage)) {
            return;
        }
        clubToManage = club;
    }

    public static int getCurrentRound() {
        return currentRound;
    }

    private static void resetRound() {
        currentRound = 0;
    }
}