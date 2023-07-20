package helper;

import enums.Club;
import enums.League;
import player.Player;

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
        int avgAttack = totalAttack / players.size();
        int avgControl = totalControl / players.size();
        int avgDefense = totalDefense / players.size();

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
}
