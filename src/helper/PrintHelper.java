package helper;

import GameObjects.*;
import core.*;
import enums.Club;
import enums.Country;
import enums.League;
import enums.Position;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PrintHelper {
    private static Scanner sc = new Scanner(System.in);


    public static void printHomeMenu() {
        sc = new Scanner(System.in);
        printNewLine(11);
        System.out.println("----------------------------------------");
        System.out.println(Game.getCurrentClub().getName());
        System.out.println("Money: " + Game.getMoney());
        System.out.println("----------------------------------------");
        System.out.println();
        System.out.println("0) Quit without save");
        System.out.println("1) Next Match details");
        System.out.println("2) Go to next Match");
        System.out.println("3) Table");
        System.out.println("4) My Squad");
        System.out.println("5) My Club");
        System.out.println("6) Buy/sell players");
        System.out.println("7) Job offers (" + Engine.getJobOffers().size() + ")");
        System.out.println("8) News");
        System.out.println("9) Save game");
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
                MatchEngine.startNextMatch();
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
                printNewsPage();
                break;
            case 9:
                SaveLoadGame slg = new SaveLoadGame(Game.getSavePath());
                slg.saveGame();
                printSaveGame();
                break;
            default:
                System.out.println("Invalid option");
                printNewLine(11);
        }
        printHomeMenu();
    }

    public static Country printSelectStartCountry() {
        int i = 0;

        List<Country> countryList = Engine.getCountriesWithLeagues().keySet().stream().toList();

        printNewLine(11);
        System.out.println("-----------------------------------------");
        System.out.println("- - - - -  SELECT YOUR COUNTRY  - - - - -");
        System.out.println("-----------------------------------------");
        for (Country c : countryList) {
            int amountOfPlayableLeagues = Engine.getCountriesWithLeagues().get(c).stream().filter(League::isPlayable).toList().size();
            //TODO Only countries with playable leagues should be selectable
            /*if (amountOfPlayableLeagues == 0) {
                continue;
            }*/
            System.out.println("(" + (i) + ") " + c.getName() + " (" + amountOfPlayableLeagues + " leagues)");
            i++;
        }
        System.out.print(">> ");
        int choice = sc.nextInt();
        if (choice >= countryList.size() || choice < 0) {
            System.out.println("Invalid option");
            printSelectStartCountry();
        }
        return countryList.get(choice);
    }

    public static League printSelectStartLeague(Country startCountry) {
        int i = 0;

        List<League> leaguesList = Engine.getPlayableLeagues().keySet()
                .stream()
                .filter(x -> x.getCountry().equals(startCountry))
                .filter(x -> x.isPlayable())
                .toList();

        printNewLine(11);
        System.out.println("----------------------------------------");
        System.out.println("- - - - -  SELECT YOUR LEAGUE  - - - - -");
        System.out.println("----------------------------------------");
        for (League l : leaguesList) {
            System.out.println("(" + i + ") " + l.getName());
            i++;
        }
        System.out.print(">> ");
        int choice = sc.nextInt();
        if (choice >= leaguesList.size() || choice < 0) {
            System.out.println("Invalid option");
            printSelectStartLeague(startCountry);
        }
        return leaguesList.get(choice);
    }

    public static Club printSelectStartClub() {
        int i = 0;

        Country startCountry = printSelectStartCountry();
        League startLeague = printSelectStartLeague(startCountry);
        List<Club> randomClubs = ClubHelper.getRandomClubsForLeague(startLeague);

        printNewLine(11);
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
            printSelectStartClub();
        }
        Game.setCurrentClub(randomClubs.get(choice));
        return randomClubs.get(choice);
    }

    public static int askNewGameOrLoad() {
        System.out.println("1) New Game");
        System.out.println("2) Load Game");
        System.out.println();
        System.out.print(">>");
        int choice = sc.nextInt();
        if (choice < 1 || choice > 2) {
            System.out.println("Invalid input.");
            printNewLine(11);
            askNewGameOrLoad();
        }
        return choice;
    }

    public static void printGoalsList(Map<Player, List<Integer>> scorers, Club opponent) {
        System.out.println("\n\nGOALS:");
        for (int minute = 0; minute <= 120; minute++) {
            for (Player p : scorers.keySet()) {
                for (Integer min : scorers.get(p)) {
                    if (min.equals(minute)) {
                        if (p.getClub().equals(opponent)) {
                            System.out.print("               ");
                        }
                        System.out.println(p.getLastName() + " (" + min + "')");
                    }
                }
            }
        }
    }

    public static void printScoredGoal(Player scorer, int minute) {
        Club club = scorer.getClub();
        System.out.println("Goal for " + club.getName() + " by " + scorer.getFirstName() + " " + scorer.getLastName() + " (" + minute + "')");
    }

    private static void printNextMatchDetails() {
        Match nextMatch = MatchEngine.getNextMatch();
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

    private static void printMySquad() {
        printNewLine(11);
        System.out.println("---------------------------------------");
        System.out.println("- - - - -     YOUR  SQUAD     - - - - -");
        System.out.println("---------------------------------------");
        System.out.println();
        List<Player> players = ClubHelper.sortPlayersByPosition(Game.getCurrentClub());
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
        System.out.println("1) Go back");
        System.out.println("2) Edit squad");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                printHomeMenu();
                break;
            case 2:
                printEditSquad();
                break;
            default:
                System.out.println("Invalid input");
                printNewLine(11);
                printMySquad();
        }
    }

    private static void printTable() {
        LeagueTable table = SeasonEngine.getTable();
        printNewLine(11);
        System.out.println(table.getLeague().getName());
        System.out.println("----------------------------------------");
        System.out.println();
        int i = 0;
        for (Club c : table.getPoints().keySet()) {
            System.out.println((i + 1) + ".: " + c.getName() + getSpacesForTable((i + 1), c.getName()) + "(" + table.getPoints().get(c) + " pts)");
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

    private static void printSaveGame() {
        System.out.println("Game saved successfully... Press ENTER");
        try {
            System.in.read();
            printHomeMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printEditSquad() {
        //TODO implement
    }

    public static void printMyClub() {
        //TODO implement
    }

    public static void printTransferMarket() {
        System.out.println("-------------------------------");
        System.out.println("------  TRANSFER MARKET  ------");
        System.out.println("-------------------------------");
        System.out.println();
        System.out.println("1) Buy players");
        System.out.println("2) Sell players");
        System.out.println();
        System.out.print(">>");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                printMarketBuyPlayers();
                break;
            case 2:
                printMarketSellPlayers();
                break;
            default:
                System.out.println("Invalid input.");
                printTransferMarket();
        }
    }

    public static void printJobOffers() {
        List<JobOffer> jobOffers = Engine.getJobOffers();
        if (jobOffers == null || jobOffers.isEmpty()) {
            return;
        }

        printNewLine(11);
        for (int i = 0; i < jobOffers.size(); i++) {
            System.out.println(i + ": " + jobOffers.get(i).getClub().getName() + " (League: " + jobOffers.get(i).getClub().getLeague() + ")");
        }

        System.out.print(">> ");
        int choice = sc.nextInt();
        if (choice >= jobOffers.size() || choice < 0) {
            System.out.println("Invalid option");
            printHomeMenu();
        }
        printSingleJobOffer(jobOffers.get(choice));
    }

    private static void printSingleJobOffer(JobOffer offer) {
        if (offer == null) {
            return;
        }

        int[] totalStats = ClubHelper.getStatsForClub(offer.getClub());

        printNewLine(11);
        System.out.println("Club:               " + offer.getClub().getName());
        System.out.println("League:             " + offer.getClub().getLeague().getName() + " (" + offer.getClub().getLeague() + ")");
        System.out.println("Rating:             " + totalStats[0] + " ATT / " + totalStats[1] + " CON / " + totalStats[2] + " DEF");
        System.out.println("Total market value: " + ClubHelper.getTotalMarketValue(offer.getClub()));
        System.out.println();
        System.out.println("1) Accept offer");
        System.out.println("2) Decline offer (delete from list)");
        System.out.println("3) Go back to offers");
        System.out.print(">> ");
        int choice = sc.nextInt();
        if (choice > 3 || choice < 1) {
            System.out.println("Invalid option");
            printSingleJobOffer(offer);
        }
        switch (choice) {
            case 1 -> Engine.acceptOffer(offer);
            case 2 -> Engine.declineOffer(offer);
            case 3 -> printJobOffers();
        }
    }

    private static void printMarketBuyPlayers() {
        Map<Player, Long> playersOnMarket = TransferMarketEngine.getPlayersOnMarket();

        if (playersOnMarket.isEmpty()) {
            printNewLine(11);
            System.out.println("There are currently no players on the transfer market. Come back later.");
            try {
                Thread.sleep(2000);
                return;
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }

        //TODO On the market list, list the own players on top in their own section

        List<Player> ownPlayers = playersOnMarket.keySet().stream().filter(x -> x.getClub().equals(Game.getCurrentClub())).toList();
        List<Player> otherPlayers = playersOnMarket.keySet().stream().filter(x -> !x.getClub().equals(Game.getCurrentClub())).toList();

        printNewLine(11);
        System.out.println("-------------------------------");
        System.out.println("------  TRANSFER MARKET  ------");
        System.out.println("-------------------------------");
        System.out.println();
        System.out.println(playersOnMarket.size() + " players found");
        System.out.println();
        int i = 0;

        System.out.println();
        System.out.println("----- PLAYERS YOU ARE SELLING -----");
        System.out.println();
        for (Player p : ownPlayers) {
            System.out.println(p.getFirstName() + " " + p.getLastName() + ", " + PlayerEngine.getPlayerAge(p) + " y/o (" + p.getClub().getName() + ") ..... " + p.getRating() + "/" + p.getPosition());
        }

        System.out.println();
        System.out.println("----- PLAYERS FROM OTHER CLUBS -----");
        System.out.println();
        for (Player p : otherPlayers) {
            System.out.println(i + ": " + p.getFirstName() + " " + p.getLastName() + ", " + PlayerEngine.getPlayerAge(p) + " y/o (" + p.getClub().getName() + ") ..... " + p.getRating() + "/" + p.getPosition());
            i++;
        }

        /*for (Player p : playersOnMarket.keySet()) {
            System.out.println(i + ": " + p.getFirstName() + " " + p.getLastName() + ", " + PlayerEngine.getPlayerAge(p) + " y/o (" + p.getClub().getName() + ") ..... " + p.getRating() + "/" + p.getPosition());
            i++;
        }*/

        System.out.println();
        System.out.print(">>");
        int choice = sc.nextInt();
        if (choice < 0 || choice >= playersOnMarket.size()) {
            System.out.println("Invalid input");
            try {
                System.in.read();
            } catch (IOException io) {
                io.printStackTrace();
            }
            printTransferMarket();
        }
        if (!TransferMarketEngine.canBuyPlayer(otherPlayers.get(choice), Game.getMoney())) {
            System.out.println("Not enough money to buy the player");
            printTransferMarket();
        }
        printMenuBuyPlayer(otherPlayers.get(choice));
    }

    private static void printMarketSellPlayers() {
        //TODO other clubs should more likely buy a player when it's a better offer (based on age, rating and price)
        System.out.println("Choose a player you want to put on the transfer market.");

        List<Player> squad = PlayerHelper.getPlayersForClub(Game.getCurrentClub());
        for (int i = 0; i < squad.size(); i++) {
            System.out.println(i + ") " + squad.get(i).getFirstName() + " " + squad.get(i).getLastName());
        }
        System.out.println();
        System.out.print(">>");
        int choice = sc.nextInt();
        if (choice < 0 || choice >= squad.size()) {
            System.out.println("Invalid input.");
            printMarketSellPlayers();
        }

        int confirmationChoice = printSellConfirmation(squad.get(choice));

        switch (confirmationChoice) {
            case 1:
                //TODO Create a News entry when another club buys your player
                long transferCost = printChooseTransferCost(squad.get(choice));

                TransferMarketEngine.sellPlayer(squad.get(choice), transferCost);
                System.out.println("Player successfully put on the market.");
                printHomeMenu();
                break;
            case 2:
                printTransferMarket();
                break;
            default:
                break;
        }
    }

    private static long printChooseTransferCost(Player player) {
        if (player == null) {
            return -1;
        }

        long minRecommended = (long) (player.getMarketValue() * 0.6);
        long maxRecommended = (long) (player.getMarketValue() * 2.5);

        System.out.println("What price do you want the player to sell for?");
        System.out.println("Recommended: " + minRecommended + "€ - " + maxRecommended + "€");
        System.out.print(">>");
        long choice = sc.nextLong();

        if (choice <= 0) {
            System.out.println("Transfer cost must be at least 1€.");
            return -1;
        }

        return choice;
    }

    private static int printSellConfirmation(Player playerToSell) {
        if (playerToSell == null) {
            throw new NullPointerException("playerToSell was null");
        }

        System.out.println("Are you sure to sell this player?");
        System.out.println("Name: " + playerToSell.getFirstName() + " " + playerToSell.getLastName());
        System.out.println();
        System.out.println("1) Yes");
        System.out.println("2) No");
        System.out.print(">>");
        int choice = sc.nextInt();
        if (choice < 1 || choice > 2) {
            System.out.println("Invalid input");
            printSellConfirmation(playerToSell);
        }
        return choice;
    }

    private static void printMenuBuyPlayer(Player player) {
        if (player == null) {
            return;
        }

        printNewLine(11);
        int[] potential = PlayerEngine.getPotential(player);
        System.out.println("Name: " + player.getFirstName() + " " + player.getLastName());
        System.out.println("Age: " + PlayerEngine.getPlayerAge(player));
        System.out.println("Position: " + player.getPosition());
        System.out.println("Rating (Potential): " + player.getRating() + " (" + potential[0] + "-" + potential[1] + ")");
        System.out.println("--------------------");
        System.out.println("Cost: " + TransferMarketEngine.getPlayersOnMarket().get(player) + "€");
        System.out.println();
        System.out.println("1) Buy player");
        System.out.println("2) Go back to transfer market");
        System.out.print(">>");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                if (TransferMarketEngine.buyPlayer(player, Game.getCurrentClub())) {
                    System.out.println("Player purchased successfully!");
                }
                printHomeMenu();
            case 2:
                printTransferMarket();
            default:
                System.out.println("Invalid input.");
                printMenuBuyPlayer(player);
                break;
        }
    }

    public static void printNewsPage() {
        List<News> news = Game.getNews();
        if (news == null || news.isEmpty()) {
            return;
        }

        for (News entry : news) {
            System.out.println(entry.getMessage());
        }

        printHomeMenu();
    }

    public static void printMessagePlayerRetirement(Player player) {
        printNewLine(11);
        printCharacter('#', 30);
        System.out.println(player.getFirstName() + " " + player.getLastName() + " ends his career at the age of " + PlayerEngine.getPlayerAge(player) + ".");
        System.out.println("As a " + player.getPosition().getFullName() + ", he played " + player.getMatches() + " matches and scored " + player.getGoals() + " goals.");
        System.out.println();
        System.out.println("You can go back (OK) or view details about " + player.getFirstName() + " " + player.getLastName() + "'s career.");
        printNewLine(2);
        System.out.println("1) OK");
        System.out.println("2) Career details");
        System.out.println();
        System.out.print(">>");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                printHomeMenu();
                break;
            case 2:
                printCareerDetails(player);
                break;
            default:
                System.out.println("Invalid input");
                printNewLine(11);
                printMessagePlayerRetirement(player);
        }
    }

    public static void printCareerDetails(Player player) {
        //TODO Breakdown of all clubs the player played for and how many games and goals he made. Also show evolution of rating and marketValue
        if (player == null || player.getCareer() == null) {
            throw new NullPointerException("Player or player's career was null.");
        }

        if (player.getCareer().length == 0) {
            return;
        }
        printNewLine(11);
        System.out.println("CAREER DETAILS");
        printCharacter('-', 30);
        printNewLine(2);

        for (PlayerCareer career : player.getCareer()) {
            System.out.println(career.getFrom() + " to " + career.getUntil() + ": " + career.getClub().getName() + " (" + career.getGoals() + " in " + career.getGames() + " games)");
        }

        printHomeMenu();
    }

    public static void printNewLine(int numberOfNewLines) {
        if (numberOfNewLines <= 0) {
            return;
        }
        while (numberOfNewLines-- > 0) {
            System.out.print("\n");
        }
    }

    public static void printCharacter(char c, int times) {
        if (times <= 0) {
            return;
        }
        while (times-- > 0) {
            System.out.print(c);
        }
    }


    //Private methods

    private static String getSpacesForTable(int ranking, String clubName) {
        int spacesRemaining = 22;
        spacesRemaining -= String.valueOf(ranking).length();
        spacesRemaining -= clubName.length();

        String spaces = "";
        while (spacesRemaining-- > 0) {
            spaces += " ";
        }
        return spaces;
    }
}
