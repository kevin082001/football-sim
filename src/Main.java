import GameObjects.JobOffer;
import GameObjects.Match;
import enums.Club;
import enums.Country;
import enums.League;
import helper.ClubHelper;
import helper.GameLogic;
import helper.LeagueHelper;
import GameObjects.Player;

import java.io.IOException;
import java.util.*;

public class Main { //TODO implement: transfer market, international cups (EL,CL,...), more countries and leagues, World Cup
    private Scanner sc = new Scanner(System.in);
    private final Random rand = new Random(System.nanoTime());

    private Map<Country, List<League>> countriesWithLeagues = LeagueHelper.initCountriesThatHaveLeagues();

    //private Map<League, List<Club>> leagues = LeagueHelper.initLeagues();
    private Map<League, List<Club>> playableLeagues = LeagueHelper.initPlayableLeagues();
    private Map<Club, List<Player>> clubs = ClubHelper.initClubs();

    private Club clubToManage;
    private int money;

    private List<Match> matchesThisSeason = new ArrayList<>();

    private List<JobOffer> jobOffers = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        main.run();
    }

    private void run() throws InterruptedException {
        //TimeUnit.SECONDS.sleep(5);
        askStartClub();
        matchesThisSeason = GameLogic.initMatchesForSeason(clubToManage);
        printHomeMenu();

        //TODO implement logic

    }

    //private Club askStartClub() {
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
        System.out.println("----------------------------------------");
        System.out.println("- - - - -  SELECT YOUR COUNTRY  - - - - -");
        System.out.println("----------------------------------------");
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
    }

    private void printTable() {
        //TODO implement
    }

    private void printMySquad() {
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
        //TODO implement
    }

    private void clearScanner() {
        while (sc.hasNext()) {
            sc.next();
        }
    }
}