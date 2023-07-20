import enums.Club;
import enums.League;
import helper.PlayerHelper;
import player.Player;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main { //TODO implement: transfer market, international cups (EL,CL,...), more countries and leagues, World Cup
    private final Scanner sc = new Scanner(System.in);
    private final Random rand = new Random(System.nanoTime());

    private Map<League, List<Club>> leagues = initLeagues();
    private Map<Club, List<Player>> clubs = initClubs();
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

    private Map<League, List<Club>> initLeagues() {
        //TODO Optimize by removing league/club every time a league is done (currently, leagues/clubs get iterated multiple times)
        Map<League, List<Club>> result = new HashMap<>();
        for (League l : League.values()) {
            result.put(l, getClubsForLeague(l));
        }
        return result;
    }

    private List<Club> getClubsForLeague(League league) {
        List<Club> result = new ArrayList<>();
        for (Club c : Club.values()) {
            if (c.getLeague().equals(league)) {
                result.add(c);
            }
        }
        return result;
    }

    private Map<Club, List<Player>> initClubs() {
        //TODO optimize (see TODO in initLeagues())
        Map<Club, List<Player>> result = new HashMap<>();
        for (Club c : Club.values()) {
            result.put(c, getPlayersForClub(c));
        }
        return result;
    }

    private List<Player> getPlayersForClub(Club club) {
        List<Player> result = new ArrayList<>();
        for (Player p : PlayerHelper.getAllPlayers()) {
            if (p.getClub().equals(club)) {
                result.add(p);
            }
        }
        return result;
    }

    private Club askStartClub() {
        int i = 0;

        League startLeague = askStartLeague();
        List<Club> randomClubs = getRandomClubs(startLeague);

        System.out.println("----------------------------------------");
        System.out.println("- - - - -   SELECT YOUR CLUB   - - - - -");
        System.out.println("----------------------------------------");
        for (Club c : randomClubs) {
            int[] stats = getStatsForClub(c);
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

    private List<Club> getRandomClubs(League league) {
        List<Club> clubsInLeague = getClubsForLeague(league);
        List<Club> result = new ArrayList<>();
        Club club1 = clubsInLeague.get(rand.nextInt(clubsInLeague.size()));
        Club club2;
        do {
            club2 = clubsInLeague.get(rand.nextInt(clubsInLeague.size()));
        } while (club2.equals(club1));
        result.add(club1);
        result.add(club2);
        return result;
    }

    private int[] getStatsForClub(Club club) {
        int totalAttack = 0;
        int totalControl = 0;
        int totalDefense = 0;
        List<Player> players = getPlayersForClub(club);
        for (Player p : players) {
            totalAttack += p.getAttack();
            totalControl += p.getControl();
            totalDefense += p.getDefense();
        }
        int avgAttack = totalAttack / players.size();
        int avgControl = totalControl / players.size();
        int avgDefense = totalDefense / players.size();

        return new int[]{avgAttack, avgControl, avgDefense};
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