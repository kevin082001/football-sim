package helper;

import GameObjects.Player;
import core.Game;
import enums.Club;
import enums.League;
import enums.Position;

import java.util.*;

public class ClubHelper {
    private static final Random rand = new Random(System.nanoTime());

    public static Map<Club, List<Player>> initClubs() {
        Map<Club, List<Player>> result = new HashMap<>();
        for (Club c : Club.values()) {
            result.put(c, PlayerHelper.getPlayersForClub(c));
        }
        return result;
    }

    /**
     * This method is used to assign an account balance for every club
     *
     * @return A map where key=Club and value=accountBalance
     */
    public static Map<Club, Long> initClubsWithAccountBalance() {
        Map<Club, Long> result = new HashMap<>();
        Club[] allClubs = Club.values();

        //TODO make account balance varying so that smaller clubs get not as much money
        for (Club c : allClubs) {
            if (c.equals(Game.getCurrentClub())) { //Ignore own club since it's already stored separately as well as the account balance
                continue;
            }
            result.put(c, 500_000L);
        }

        return result;
    }

    public static int[] getStatsForClub(Club club) {
        int totalAttack = 0;
        int totalControl = 0;
        int totalDefense = 0;
        List<Player> players = PlayerHelper.getPlayersForClub(club);
        for (Player p : players) {
            totalAttack += p.getAttack();
            totalControl += p.getControl();
            totalDefense += p.getDefense();
        }
        //int avgAttack = totalAttack / players.size();
        int avgAttack = players.isEmpty() ? 0 : totalAttack / players.size(); //TODO only a temporary workaround, should use without inline if
        //int avgControl = totalControl / players.size();
        int avgControl = players.isEmpty() ? 0 : totalControl / players.size();
        //int avgDefense = totalDefense / players.size();
        int avgDefense = players.isEmpty() ? 0 : totalDefense / players.size();

        return new int[]{avgAttack, avgControl, avgDefense};
    }

    public static List<Club> getClubsForLeague(League league) {
        List<Club> result = new ArrayList<>();
        for (Club c : Club.values()) {
            if (c.getLeague().equals(league)) {
                result.add(c);
            }
        }
        return result;
    }

    public static List<Club> getRandomClubsForLeague(League league) {
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

    public static List<Player> sortPlayersByPosition(Club club) {
        List<Player> unsorted = PlayerHelper.getPlayersForClub(club);
        List<Player> sorted = new ArrayList<>();
        for (Position pos : Position.values()) {
            for (Player p : unsorted) {
                if (p.getPosition().equals(pos)) {
                    sorted.add(p);
                }
            }
        }
        return sorted;
    }

    public static List<Club> getAllClubs() {
        List<Club> clubs = new ArrayList<>();

        for (League league : League.values()) {
            if (ClubHelper.getClubsForLeague(league).isEmpty()) {
                continue;
            }
            clubs.addAll(ClubHelper.getClubsForLeague(league));
        }

        return clubs;
    }

    public static long getTotalMarketValue(Club club) {
        if (club == null || PlayerHelper.getPlayersForClub(club).isEmpty()) {
            return 0;
        }

        long totalValue = 0;
        for (Player p : PlayerHelper.getPlayersForClub(club)) {
            totalValue += p.getMarketValue();
        }

        return totalValue;
    }
}
