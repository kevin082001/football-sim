package helper;

import GameObjects.Club;
import GameObjects.Player;
import enums.League;
import enums.Position;

import java.util.*;

public class ClubHelper {
    private static final Random rand = new Random(System.nanoTime());

    public static Map<Club, List<Player>> initClubs() {
        Map<Club, List<Player>> result = new HashMap<>();
        for (Club c : getAllClubs()) {
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
        for (Club c : ClubHelper.getAllClubs()) {
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

    public static Club getClubByDisplayName(String displayName) {
        if (displayName == null || displayName.trim().isEmpty()) {
            return null;
        }

        for (Club c : getAllClubs()) {
            if (c.getDisplayName().equals(displayName)) {
                return c;
            }
        }

        return null;
    }

    public static Club getClubByInternalName(String internalName) {
        if (internalName == null || internalName.trim().isEmpty()) {
            return null;
        }

        for (Club c : getAllClubs()) {
            if (c.getInternalName().equals(internalName)) {
                return c;
            }
        }

        return null;
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
