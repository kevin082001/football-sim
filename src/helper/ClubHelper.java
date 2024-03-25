package helper;

import GameObjects.Player;
import enums.ClubEnum;
import enums.League;
import enums.Position;

import java.util.*;

public class ClubHelper {
    private static final Random rand = new Random(System.nanoTime());

    public static Map<ClubEnum, List<Player>> initClubs() {
        Map<ClubEnum, List<Player>> result = new HashMap<>();
        for (ClubEnum c : ClubEnum.values()) {
            result.put(c, PlayerHelper.getPlayersForClub(c));
        }
        return result;
    }

    public static int[] getStatsForClub(ClubEnum club) {
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

    public static List<ClubEnum> getClubsForLeague(League league) {
        List<ClubEnum> result = new ArrayList<>();
        for (ClubEnum c : ClubEnum.values()) {
            if (c.getLeague().equals(league)) {
                result.add(c);
            }
        }
        return result;
    }

    public static List<ClubEnum> getRandomClubsForLeague(League league) {
        List<ClubEnum> clubsInLeague = getClubsForLeague(league);
        List<ClubEnum> result = new ArrayList<>();
        ClubEnum club1 = clubsInLeague.get(rand.nextInt(clubsInLeague.size()));
        ClubEnum club2;
        do {
            club2 = clubsInLeague.get(rand.nextInt(clubsInLeague.size()));
        } while (club2.equals(club1));
        result.add(club1);
        result.add(club2);
        return result;
    }

    public static List<Player> sortPlayersByPosition(ClubEnum club) {
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

    public static List<ClubEnum> getAllClubs() {
        List<ClubEnum> clubs = new ArrayList<>();

        for (League league : League.values()) {
            if (ClubHelper.getClubsForLeague(league).isEmpty()) {
                continue;
            }
            clubs.addAll(ClubHelper.getClubsForLeague(league));
        }

        return clubs;
    }

    public static long getTotalMarketValue(ClubEnum club) {
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
