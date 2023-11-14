import GameObjects.*;
import enums.Club;
import enums.Country;
import enums.League;
import enums.Position;
import helper.*;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main { //TODO implement: transfer market, international cups (UEL, UCL, ...), more countries and leagues, WC and EC
    private Scanner sc = new Scanner(System.in);
    private final Random rand = new Random(System.nanoTime());

    private Map<Country, List<League>> countriesWithLeagues = LeagueHelper.initCountriesThatHaveLeagues();

    //private Map<League, List<Club>> leagues = LeagueHelper.initLeagues();
    private Map<League, List<Club>> playableLeagues = LeagueHelper.initPlayableLeagues();
    private Map<Club, List<Player>> clubs = ClubHelper.initClubs();

    private Club clubToManage;
    private int money = 500000;

    private List<Match> matchesThisSeason = new ArrayList<>();

    private List<JobOffer> jobOffers = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        main.run();
    }

    private void run() throws InterruptedException {
        //TimeUnit.SECONDS.sleep(5);

        //int newOrLoad = askNewGameOrLoad();
        int newOrLoad = PrintHelper.askNewGameOrLoad(sc);
        //if (clubToManage == null) {
        if (newOrLoad == 1) {
            askStartClub();
            GameLogic.initSquad(clubToManage);
        } else {
            SaveState savedGame = GameLogic.loadGame();
            clubToManage = savedGame.getCurrentClub();
        }
        matchesThisSeason = GameLogic.initMatchesForSeason(clubToManage);
        GameLogic.initTable(clubToManage);
        printHomeMenu();
    }

    private void askStartClub() {
        int i = 0;

        League startLeague = askStartLeague();
        List<Club> randomClubs = ClubHelper.getRandomClubsForLeague(startLeague);

        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("----------------------------------------");
        System.out.println("- - - - -   SELECT YOUR CLUB   - - - - -");
        System.out.println("----------------------------------------");
        for (Club c : randomClubs) {
            int[] stats = ClubHelper.getStatsForClub(c);
            System.out.println("(" + i + ") " + c.getName() + " (" + stats[0] + " ATT/" + stats[1] + " CON/" + stats[2] + " DEF)");
            i++;
        }
        System.out.print(">> ");
        int choice = sc.nextInt();
        if (choice < 0 || choice > 1) {
            System.out.println("Invalid input");
            askStartClub();
        }
        //return randomClubs.get(choice);
        clubToManage = randomClubs.get(choice);
    }

    private League askStartLeague() {
        int i = 0;

        Country startCountry = askStartCountry();
        //List<League> leaguesList = League.BUNDESLIGA.getByCountry(startCountry);
        List<League> leaguesList = playableLeagues.keySet()
                .stream()
                .filter(x -> x.getCountry().equals(startCountry))
                .filter(x -> x.isPlayable())
                .toList();

        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("----------------------------------------");
        System.out.println("- - - - -  SELECT YOUR LEAGUE  - - - - -");
        System.out.println("----------------------------------------");
        for (League l : leaguesList) {
            //System.out.println("(" + i + ") " + l.getName() + " (" + l.getCountry() + ")");
            System.out.println("(" + i + ") " + l.getName());
            i++;
        }
        System.out.print(">> ");
        int choice = sc.nextInt();
        if (choice >= leaguesList.size() || choice < 0) {
            System.out.println("Invalid option");
            askStartLeague();
        }
        return leaguesList.get(choice);
    }

    private Country askStartCountry() {
        int i = 0;

        List<Country> countryList = countriesWithLeagues.keySet().stream().toList();

        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("-----------------------------------------");
        System.out.println("- - - - -  SELECT YOUR COUNTRY  - - - - -");
        System.out.println("-----------------------------------------");
        for (Country c : countryList) {
            int amountOfPlayableLeagues = countriesWithLeagues.get(c).stream().filter(x->x.isPlayable()).toList().size();
            System.out.println("(" + (i) + ") " + c.getName() + " (" + amountOfPlayableLeagues + " leagues)");
            i++;
        }
        System.out.print(">> ");
        int choice = sc.nextInt();
        if (choice >= countryList.size() || choice < 0) {
            System.out.println("Invalid option");
            askStartCountry();
        }
        return countryList.get(choice);
    }

    private void printHomeMenu() {
        //clearScanner();
        sc = new Scanner(System.in);
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("----------------------------------------");
        System.out.println(clubToManage.getName());
        System.out.println("Money: " + money);
        System.out.println("----------------------------------------");
        System.out.println();
        System.out.println("0) Quit without save");
        System.out.println("1) Next Match details");
        System.out.println("2) Go to next Match");
        System.out.println("3) Table");
        System.out.println("4) My Squad");
        System.out.println("5) My Club");
        System.out.println("6) Buy/sell players");
        System.out.println("7) Job offers (" + jobOffers.size() + ")");
        System.out.println("8) Save game");
        System.out.println();
        System.out.print(">> ");
        int choice = sc.nextInt();
        switch (choice) {
            case 0:
                System.exit(0);
            case 1:
                printNextMatchDetails();
                break;
            case 2:
                startNextMatch();
                break;
            case 3:
                printTable();
                break;
            case 4:
                printMySquad();
                break;
            case 5:
                printMyClub();
                break;
            case 6:
                printTransferMarket();
                break;
            case 7:
                printJobOffers();
                break;
            case 8:
                saveGame();
                break;
            default:
                System.out.println("Invalid option");
                printHomeMenu();
        }
    }

    private void printNextMatchDetails() {
        Match nextMatch = GameLogic.getNextMatch(clubToManage, matchesThisSeason);
        if (nextMatch == null) {
            //That should actually NEVER be printed
            System.out.println("All matches played");
            return;
        }

        System.out.println("Next match:");
        System.out.println(nextMatch.getHome().getName() + "   VS.   " + nextMatch.getAway().getName());
        System.out.println();
        System.out.println("Press ENTER to return to home menu");
        try {
            System.in.read();
            printHomeMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startNextMatch() {
        Match nextMatch = GameLogic.getNextMatch(clubToManage, matchesThisSeason);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("------ " + nextMatch.getHome().getName() + "  VS.  " + nextMatch.getAway().getName() + " ------");
        try {
            TimeUnit.MILLISECONDS.sleep(4000);

            double[] goalChances = GameLogic.calcGoalChances(clubToManage, getOpponent(nextMatch));
            double ownChance = (goalChances[0] / 20);
            double opponentChance = ownChance + (goalChances[1] / 20);

            Score score = new Score(0, 0, new HashMap<>());
            Map<Player, List<Integer>> scorers = new HashMap<>();
            Club opponent = getOpponent(nextMatch);

            int ownGoals = 0;
            int opponentGoals = 0;

            for (int minute = 1; minute <= 90; minute++) {
                double randomNumber = rand.nextDouble(100);
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + minute + "'");

                if (randomNumber <= ownChance) { //DONT FORGET: logic has to be the same for OWN and OPPONENT
                    Player scorer = GameLogic.getScorer(PlayerHelper.getPlayersForClub(clubToManage));
                    System.out.println("Goal for " + clubToManage.getName() + " by " + scorer.getFirstName() + " " + scorer.getLastName() + " (" + minute + "')");
                    scorer.setGoals(scorer.getGoals() + 1);
                    scorers = updateScorers(scorers, scorer, minute);
                    score.getScorers().put(scorer, score.getScorers().get(scorer) == null ? 1 : score.getScorers().get(scorer) + 1);
                    ownGoals++;
                } else if (randomNumber <= opponentChance) {
                    Player scorer = GameLogic.getScorer(PlayerHelper.getPlayersForClub(opponent));
                    System.out.println("Goal for " + opponent.getName() + " by " + scorer.getFirstName() + " " + scorer.getLastName() + " (" + minute + "')");
                    scorer.setGoals(scorer.getGoals() + 1);
                    scorers = updateScorers(scorers, scorer, minute);
                    score.getScorers().put(scorer, score.getScorers().get(scorer) == null ? 1 : score.getScorers().get(scorer) + 1);
                    opponentGoals++;
                }

                TimeUnit.MILLISECONDS.sleep(200);
            }

            //score = updateScore(score, clubToManage, nextMatch, ownGoals);
            //score = updateScore(score, opponent, nextMatch, opponentGoals);


            //TODO print end menu (score, best scorers,...), save result, check for player level-up
            System.out.println("MATCH END!");
            PrintHelper.printGoalsList(scorers, opponent);

            System.out.println("\n");
            System.out.println(clubToManage.getName() + " ... " + (nextMatch.getHome().equals(clubToManage) ? ownGoals : opponentGoals) +
                    " : " + (nextMatch.getHome().equals(opponent) ? ownGoals : opponentGoals) + " ... " + opponent.getName());

            GameLogic.checkForPlayerLevelUp(nextMatch);

            score.setScoreHome(ownGoals);
            score.setScoreAway(opponentGoals);
            nextMatch.setScore(score);
            //score.setScorers(scorers);

            //GameLogic.updateTable(matchesThisSeason); Comment-in when match logic is implemented so that all matches in a round get simulated
            GameLogic.updateTable(nextMatch); //TODO fix nullpointer (Cannot invoke "GameObjects.Score.getScoreHome()" because "this.score" is null) in Match.java
            printHomeMenu();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void printTable() {
        LeagueTable table = GameLogic.getTable();
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println(table.getLeague().getName());
        System.out.println("----------------------------------------");
        System.out.println();
        int i = 0;
        for (Club c : table.getPoints().keySet()) {
            System.out.println((i + 1) + ".: " + c.getName() + PrintHelper.getSpacesForTable((i + 1), c.getName()) + "(" + table.getPoints().get(c) + " pts)");
            i++;
        }
        System.out.println();
        System.out.println("Press ENTER to return to home menu");
        try {
            System.in.read();
            printHomeMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printMySquad() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("---------------------------------------");
        System.out.println("- - - - -     YOUR  SQUAD     - - - - -");
        System.out.println("---------------------------------------");
        System.out.println();
        List<Player> players = ClubHelper.sortPlayersByPosition(clubToManage);
        Position pos = null;
        for (Player p : players) {
            if (pos == null || !p.getPosition().getType().equals(pos.getType())) {
                pos = p.getPosition();
                System.out.println("\n\n" + pos.getType() + "\n---------------");
            }
            System.out.println(p.getLastName() + " (" + p.getRating() + "/" + p.getPosition() + ")    ");
        }
        System.out.println("\n---------------");
        System.out.println();
        System.out.println("0) Go back");
        System.out.println("1) Edit squad");
        int choice = sc.nextInt();
        switch (choice) {
            case 0:
                printHomeMenu();
                break;
            case 1:
                printEditSquad();
                break;
            default:
                System.out.println("Invalid option");
                printMySquad();
        }
    }

    private void printEditSquad() {
        //TODO implement
    }

    private void printMyClub() {
        //TODO implement
    }

    private void printTransferMarket() {
        //TODO implement (when all players have a market value)
    }

    private void printJobOffers() {
        //TODO implement (also logic for receiving offers)
    }

    private void saveGame() {
        GameLogic.saveGame(clubToManage, money);

        System.out.println("Game saved successfully... Press ENTER");
        try {
            System.in.read();
            printHomeMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Club getOpponent(Match match) {
        return match.getHome().getName().equals(clubToManage.getName()) ? match.getAway() : match.getHome();
    }

    private Score updateScore(Score score, Club club, Match match, int goals) {
        if (match.getHome().equals(club)) {
            score.setScoreHome(goals);
        } else {
            score.setScoreAway(goals);
        }
        return score;
    }

    private Map<Player, List<Integer>> updateScorers(Map<Player, List<Integer>> scorers, Player scorer, Integer minute) {
        if (scorers == null || scorer == null || minute == null) {
            throw new IllegalArgumentException("Cannot update scorers (null value)");
        }

        if (!scorers.containsKey(scorer)) {
            scorers.put(scorer, new ArrayList<>());
        }
        scorers.get(scorer).add(minute);

        return scorers;
    }
}