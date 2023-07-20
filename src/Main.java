import enums.Club;
import enums.League;
import helper.ClubHelper;
import helper.LeagueHelper;
import helper.PlayerHelper;
import player.Player;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main { //TODO implement: transfer market, international cups (EL,CL,...), more countries and leagues, World Cup
    private final Scanner sc = new Scanner(System.in);
    private final Random rand = new Random(System.nanoTime());

    private Map<League, List<Club>> leagues = LeagueHelper.initLeagues();
    private Map<Club, List<Player>> clubs = ClubHelper.initClubs();
    private Club clubToManage;

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        main.run();
    }

    private void run() throws InterruptedException {
        //TimeUnit.SECONDS.sleep(5);
        clubToManage = askStartClub();

        //TODO implement logic
    }

    private Club askStartClub() {
        int i = 0;

        League startLeague = askStartLeague();
        List<Club> randomClubs = ClubHelper.getRandomClubsForLeague(startLeague);

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
        return randomClubs.get(choice);
    }

    private League askStartLeague() {
        int i = 0;
        List<League> leaguesList = leagues.keySet().stream().toList();

        System.out.println("----------------------------------------");
        System.out.println("- - - - -  SELECT YOUR LEAGUE  - - - - -");
        System.out.println("----------------------------------------");
        for (League l : leaguesList) {
            System.out.println("(" + i + ") " + l.getName() + " (" + l.getCountry() + ")");
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
}