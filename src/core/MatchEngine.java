package core;

import GameObjects.Match;
import GameObjects.Player;
import GameObjects.Score;
import enums.ClubEnum;
import enums.League;
import helper.ClubHelper;
import helper.PlayerHelper;
import helper.PrintHelper;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class MatchEngine {
    private static List<Match> matchesThisSeason;
    private static int currentRound;
    private static final Random rand = new Random(System.nanoTime());


    //TODO probably move to SeasonEngine
    public static void initMatchesForSeason(ClubEnum club) {
        List<Match> result = new ArrayList<>();

        League league = club.getLeague();
        List<ClubEnum> clubsInLeague = ClubHelper.getClubsForLeague(league);

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

        List<ClubEnum> clubsInLeague = ClubHelper.getClubsForLeague(Game.getCurrentClub().getLeague());
        int matchesInRound = (clubsInLeague.size() - round) * 2; //number of matches per round decreases (10 clubs --> 18, 16, 14, 12,...)

        for (int i = 0; i < matchesInRound; i++) {
            simulateMatch(matchesThisSeason.get(i), false);
        }
    }

    public static void simulateMatch(Match match, boolean isOwnClub) {
        ClubEnum home = match.getHome();

        double[] goalChances = calcGoalChances(match);
        double ownChance = (goalChances[0] / 20);
        double opponentChance = ownChance + (goalChances[1] / 20);

        Score score = new Score(0, 0, new HashMap<>());
        Map<Player, List<Integer>> scorers = new HashMap<>();
        ClubEnum opponent = getOpponent(match);

        int ownGoals = 0;
        int opponentGoals = 0;

        for (int minute = 1; minute <= 90; minute++) {
            double randomNumber = rand.nextDouble(100);

            if (randomNumber <= ownChance) {
                updateMatchScore(home, minute, scorers, score, isOwnClub);
                ownGoals++;
            } else if (randomNumber <= opponentChance) {
                updateMatchScore(opponent, minute, scorers, score, isOwnClub);
                opponentGoals++;
            }
        }

        PlayerEngine.checkForPlayerLevelUp(match, isOwnClub);

        score.setScoreHome(ownGoals);
        score.setScoreAway(opponentGoals);
        match.setScore(score);
    }

    public static List<Match> getMatchesForRound(int round, ClubEnum club, List<Match> matchesThisSeason) {
        List<Match> matchesThisRound = new ArrayList<>();
        List<ClubEnum> clubsInLeague = ClubHelper.getClubsForLeague(club.getLeague());
        int amountOfMatches = (clubsInLeague.size() - round) * 2;
        int startIndex = getStartIndex(round, club);

        for (int i = startIndex; i < (startIndex + amountOfMatches); i++) {
            //TODO IndexOutOfBoundsException: Index 90 out of bounds for length 90 (played 4 matches)
            matchesThisRound.add(new Match(matchesThisSeason.get(i).getHome(), matchesThisSeason.get(i).getAway(), null));
        }

        return matchesThisRound;
    }

    public static Match getNextMatch() {
        for (Match m : matchesThisSeason) {
            if (m.getScore() != null) {
                continue;
            }
            if (m.getHome().equals(Game.getCurrentClub()) || m.getAway().equals(Game.getCurrentClub())) {
                return m;
            }
        }
        return null;
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

        Match nextMatch = getNextMatch();
        PrintHelper.printNewLine(11);
        System.out.println("------ " + nextMatch.getHome().getName() + "  VS.  " + nextMatch.getAway().getName() + " ------");
        try {
            TimeUnit.MILLISECONDS.sleep(2500);

            double[] goalChances = calcGoalChances(nextMatch);
            double ownChance = (goalChances[0] / 20);
            double opponentChance = ownChance + (goalChances[1] / 20);

            Score score = new Score(0, 0, new HashMap<>());
            Map<Player, List<Integer>> scorers = new HashMap<>();
            ClubEnum opponent = getOpponent(nextMatch);

            int ownGoals = 0;
            int opponentGoals = 0;

            for (int minute = 1; minute <= 90; minute++) {
                double randomNumber = rand.nextDouble(100);

                PrintHelper.printNewLine(11);
                System.out.println(minute + "'");

                if (randomNumber <= ownChance) {
                    scorers = updateMatchScore(Game.getCurrentClub(), minute, scorers, score, true);
                    ownGoals++;
                } else if (randomNumber <= opponentChance) {
                    scorers = updateMatchScore(getOpponent(nextMatch), minute, scorers, score, true);
                    opponentGoals++;
                }

                TimeUnit.MILLISECONDS.sleep(200);
            }

            System.out.println("MATCH END!");
            PrintHelper.printGoalsList(scorers, opponent);

            System.out.println("\n");
            System.out.println(Game.getCurrentClub().getName() + " ... " + (nextMatch.getHome().equals(Game.getCurrentClub()) ? ownGoals : opponentGoals) +
                    " : " + (nextMatch.getHome().equals(opponent) ? ownGoals : opponentGoals) + " ... " + opponent.getName());

            PlayerEngine.checkForPlayerLevelUp(nextMatch, true);

            score.setScoreHome(ownGoals);
            score.setScoreAway(opponentGoals);
            nextMatch.setScore(score);

            simulateMatches(currentRound);
            SeasonEngine.updateTable(getMatchesForRound(currentRound, Game.getCurrentClub(), getMatchesThisSeason()));
            Engine.checkForJobOffers(Game.getCurrentClub()); //TODO should not be called here (separation of concerns)
            TransferMarketEngine.checkForMarketUpdate(); //TODO should not be called here (separation of concerns)
            PrintHelper.printHomeMenu();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static Map<Player, List<Integer>> updateMatchScore(ClubEnum club, int minute, Map<Player, List<Integer>> scorers, Score score, boolean isOwnClub) {
        Player scorer = getScorer(PlayerHelper.getPlayersForClub(club));
        scorer.setGoals(scorer.getGoals() + 1);
        scorers = updateScorers(scorers, scorer, minute);
        score.getScorers().put(scorer, score.getScorers().get(scorer) == null ? 1 : score.getScorers().get(scorer) + 1);
        if (isOwnClub) {
            PrintHelper.printScoredGoal(scorer, minute);
        }
        return scorers;
    }

    public static double[] calcGoalChances(Match match) {
        int[] ownStats = ClubHelper.getStatsForClub(Game.getCurrentClub());
        int[] opponentStats = ClubHelper.getStatsForClub(getOpponent(match));

        double ownTotal = ownStats[0] + (0.5 * ownStats[2]) + (0.2 * ownStats[1]);
        double opponentTotal = opponentStats[0] + (0.5 * opponentStats[2]) + (0.2 * opponentStats[1]);
        double total = ownTotal + opponentTotal;

        double ownChance = (ownTotal * 100) / total;
        double opponentChance = (opponentTotal * 100) / total;

        return new double[]{ownChance, opponentChance};
    }

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

    private static int getStartIndex(int round, ClubEnum club) {
        int leagueSize = ClubHelper.getClubsForLeague(club.getLeague()).size();

        int alreadyPlayed = 0;

        while (round-- >= 0) {
            alreadyPlayed += (leagueSize - round) * 2;
        }

        return alreadyPlayed;
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

    private static ClubEnum getOpponent(Match match) {
        return match.getHome().getName().equals(Game.getCurrentClub().getName()) ? match.getAway() : match.getHome();
    }

    public static int getCurrentRound() {
        return currentRound;
    }

    public static List<Match> getMatchesThisSeason() {
        return matchesThisSeason;
    }
}
