package helper;

import GameObjects.Club;
import GameObjects.League;
import GameObjects.Player;
import enums.Position;

import java.util.*;

public class ClubHelper {
    private static final Random rand = new Random(System.nanoTime());

    private final static Club[] clubs = new Club[]{
            new Club("Retired", "Retired", "Retired", "RETIRED", LeagueHelper.getByInternalName("RETIRED"), null, 0),
            new Club("Without club", "Without club", "Without club", "WITHOUT_CLUB", LeagueHelper.getByInternalName("WITHOUT_CLUB"), null, 0),

            new Club("Manchester City", "Manchester City", "MCI", "MAN_CITY", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000),
            new Club("FC Arsenal", "FC Arsenal", "ARS", "ARSENAL", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000),
            new Club("FC Chelsea", "FC Chelsea", "CHE", "CHELSEA", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000),
            new Club("FC Liverpool", "FC Liverpool", "LIV", "MAN_CITY", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000),
            new Club("Manchester United", "Manchester United", "MUN", "MAN_UTD", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000),
            new Club("Tottenham Hotspur", "Tottenham Hotspur", "TOT", "SPURS", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000),
            new Club("Newcastle United", "Newcastle United", "NEW", "NEWCASTLE", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000),
            new Club("Aston Villa", "Aston Villa", "AVL", "ASTON_VILLA", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000),
            new Club("Brighton & Hove Albion", "Brighton & Hove Albion", "BRI", "BRIGHTON", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000),
            new Club("West Ham United", "West Ham United", "WHU", "WESTHAM", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000),
            new Club("FC Brentford", "FC Brentford", "BRE", "BRENTFORD", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000),
            new Club("Nottingham Forest", "Nottingham Forest", "NFO", "NHAM_FOREST", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000),
            new Club("Crystal Palace", "Crystal Palace", "CRY", "CRYSTAL_PALACE", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000),
            new Club("FC Everton", "FC Everton", "EVE", "EVERTON", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000),
            new Club("AFC Bournemouth", "AFC Bournemouth", "BOU", "BOURNEMOUTH", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000),
            new Club("Wolverhampton Wanderers", "Wolverhampton Wanderers", "WOL", "WOLVES", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000),
            new Club("FC Fulham", "FC Fulham", "FUL", "FULHAM", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000),
            new Club("FC Burnley", "FC Burnley", "BUR", "BURNLEY", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000),
            new Club("Sheffield United", "Sheffield United", "SHU", "SHEFFIELD_UTD", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000),
            new Club("Luton Town", "Luton Town", "LUT", "LUTON", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000),
    };

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

    /*public static List<Club> getAllClubs() {
        List<Club> clubs = new ArrayList<>();

        for (League league : LeagueHelper.getAllLeagues()) {
            if (ClubHelper.getClubsForLeague(league).isEmpty()) {
                continue;
            }
            clubs.addAll(ClubHelper.getClubsForLeague(league));
        }

        return clubs;
    }*/

    public static List<Club> getAllClubs() {
        return Arrays.asList(clubs);
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
