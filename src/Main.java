import GameObjects.*;
import enums.Club;
import enums.Country;
import enums.League;
import enums.Position;
import helper.ClubHelper;
import helper.GameLogic;
import helper.LeagueHelper;
import helper.PrintHelper;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main { //TODO implement: transfer market, international cups (EL,CL,...), more countries and leagues, World Cup
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
        List<League> leaguesList = League.BUNDESLIGA.getByCountry(startCountry);
        //List<League> leaguesList = playableLeagues.keySet().stream().toList();

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
            System.out.println("(" + i + ") " + c.getName() + " (" + countriesWithLeagues.get(c).size() + " leagues)");
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
        //TODO implement

        Match nextMatch = GameLogic.getNextMatch(clubToManage, matchesThisSeason);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("------ " + nextMatch.getHome().getName() + "  VS.  " + nextMatch.getAway().getName() + " ------");
        try {
            TimeUnit.MILLISECONDS.sleep(4000);

            double[] goalChances = calcGoalChances(getOpponent(nextMatch));
            double ownChance = (goalChances[0] / 20);
            double opponentChance = ownChance + (goalChances[1] / 20);

            Score score = new Score(0, 0, new HashMap<>());
            Club opponent = getOpponent(nextMatch);

            int ownGoals = 0;
            int opponentGoals = 0;

            for (int minute = 1; minute <= 90; minute++) {
                double randomNumber = rand.nextDouble(100);

                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + minute);
                System.out.println("Chance own " + ownChance);
                System.out.println("Chance opponent " + opponentChance);
                System.out.println("rand: " + randomNumber);

                if (randomNumber <= ownChance) {
                    //TODO own club scores (find a way to choose who scored the goal (maybe give each player a probability based on rating and position))
                    System.out.println("Goal for " + clubToManage.getName() + " (" + minute + "')");
                    ownGoals++;
                } else if (randomNumber <= opponentChance) {
                    //TODO opponent scores (same as above)
                    System.out.println("Goal for " + opponent.getName() + " (" + minute + "')");
                    opponentGoals++;
                }

                TimeUnit.MILLISECONDS.sleep(300);
            }

            score = updateScore(score, clubToManage, nextMatch, ownGoals);
            score = updateScore(score, opponent, nextMatch, opponentGoals);


            System.out.println("MATCH END!");
            System.out.println(clubToManage.getName() + " ... " + (nextMatch.getHome().equals(clubToManage) ? score.getScoreHome() : score.getScoreAway())
                            + " : " + (nextMatch.getHome().equals(opponent) ? score.getScoreHome() : score.getScoreAway()) + " ... " + opponent.getName());
            //TODO print end menu (score, best scorers,...), save result, check for player level-up
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
        //TODO implement
    }

    private void printJobOffers() {
        //TODO implement
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

    /*private double[] calcGoalChances(Club opponent) {
        int[] ownStats = ClubHelper.getStatsForClub(clubToManage);
        int[] opponentStats = ClubHelper.getStatsForClub(opponent);

        double ownChance = ownStats[0] - (0.6 * opponentStats[2]) - (0.4 * opponentStats[1]);
        double opponentChance = opponentStats[0] - (0.6 * ownStats[2]) - (0.4 * ownStats[1]);

        int tmp1 = (int) (ownChance * 100);
        int tmp2 = (int) (opponentChance * 100);

        ownChance = (double) tmp1 / 100;
        opponentChance = (double) tmp2 / 100;

        return new double[]{ownChance, opponentChance};
    }*/

    private double[] calcGoalChances(Club opponent) {
        int[] ownStats = ClubHelper.getStatsForClub(clubToManage);
        int[] opponentStats = ClubHelper.getStatsForClub(opponent);

        double ownTotal = ownStats[0] + (0.5 * ownStats[2]) + (0.2 * ownStats[1]);
        double opponentTotal = opponentStats[0] + (0.5 * opponentStats[2]) + (0.2 * opponentStats[1]);
        double total = ownTotal + opponentTotal;

        double ownChance = (ownTotal * 100) / total;
        double opponentChance = (opponentTotal * 100) / total;

        return new double[]{ownChance, opponentChance};
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

    /*private void clearScanner() {
        while (sc.hasNext()) {
            sc.next();
        }
    }*/
}