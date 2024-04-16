package helper;

import GameObjects.Club;
import GameObjects.League;
import GameObjects.Player;
import enums.Position;

import java.util.*;

public class ClubHelper {
    private static final Random rand = new Random(System.nanoTime());

    /*private final static Club[] clubs = new Club[]{
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

            //TODO add other clubs from ClubEnum

            new Club("KÍ Klaksvík", "KÍ Klaksvík", "KIK", "KLAKSVIK", LeagueHelper.getByInternalName("FO_1"), null, 500_000),
            new Club("HB Tórshavn", "HB Tórshavn", "HBT", "HB", LeagueHelper.getByInternalName("FO_1"), null, 500_000),
            new Club("Víkingur Gøta", "Víkingur Gøta", "VIK", "VIKINGUR_GOTA", LeagueHelper.getByInternalName("FO_1"), null, 500_000),
            new Club("B36 Tórshavn", "B36 Tórshavn", "B36", "B36", LeagueHelper.getByInternalName("FO_1"), null, 500_000),
            new Club("07 Vestur", "07 Vestur", "VES", "VESTUR", LeagueHelper.getByInternalName("FO_1"), null, 500_000),
            new Club("EB/Streymur", "EB/Streymur", "EBS", "STREYMUR", LeagueHelper.getByInternalName("FO_1"), null, 500_000),
            new Club("B68 Toftir", "B68 Toftir", "B68", "TOFTIR", LeagueHelper.getByInternalName("FO_1"), null, 500_000),
            new Club("ÍF Fuglafjørður", "ÍF Fuglafjørður", "FGL", "FUGLAFJORDUR", LeagueHelper.getByInternalName("FO_1"), null, 500_000),
            new Club("NSÍ Runavík", "NSÍ Runavík", "NSI", "NSI", LeagueHelper.getByInternalName("FO_1"), null, 500_000),
            new Club("Skála IF", "Skála IF", "SKA", "SKALA", LeagueHelper.getByInternalName("FO_1"), null, 500_000)
    };*/

    private final static Map<String, Club> clubs = new HashMap<>();

    /**
     * Populates the internal-held 'clubs' HashMap.<br> Populates another HashMap with the players for each club
     *
     * @return The clubs with their players
     */
    public static Map<Club, List<Player>> initClubs() {
        clubs.put("RETIRED", new Club("Retired", "Retired", "Retired", LeagueHelper.getByInternalName("RETIRED"), null, 0));
        clubs.put("WITHOUT_CLUB", new Club("Without club", "Without club", "Without club", LeagueHelper.getByInternalName("WITHOUT_CLUB"), null, 0));
        clubs.put("MAN_CITY", new Club("Manchester City", "Manchester City", "MCI", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000));
        clubs.put("ARSENAL", new Club("FC Arsenal", "FC Arsenal", "ARS", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000));
        clubs.put("CHELSEA", new Club("FC Chelsea", "FC Chelsea", "CHE", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000));
        clubs.put("LIVERPOOL", new Club("FC Liverpool", "FC Liverpool", "LIV", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000));
        clubs.put("MAN_UTD", new Club("Manchester United", "Manchester United", "MUN", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000));
        clubs.put("SPURS", new Club("Tottenham Hotspur", "Tottenham Hotspur", "TOT", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000));
        clubs.put("NEWCASTLE", new Club("Newcastle United", "Newcastle United", "NEW", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000));
        clubs.put("ASTON_VILLA", new Club("Aston Villa", "Aston Villa", "AVL", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000));
        clubs.put("BRIGHTON", new Club("Brighton & Hove Albion", "Brighton & Hove Albion", "BRI", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000));
        clubs.put("WESTHAM", new Club("West Ham United", "West Ham United", "WHU", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000));
        clubs.put("BRENTFORD", new Club("FC Brentford", "FC Brentford", "BRE", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000));
        clubs.put("NHAM_FOREST", new Club("Nottingham Forest", "Nottingham Forest", "NFO", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000));
        clubs.put("CRYSTAL_PALACE", new Club("Crystal Palace", "Crystal Palace", "CRY", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000));
        clubs.put("EVERTON", new Club("FC Everton", "FC Everton", "EVE", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000));
        clubs.put("BOURNEMOUTH", new Club("AFC Bournemouth", "AFC Bournemouth", "BOU", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000));
        clubs.put("WOLVES", new Club("Wolverhampton Wanderers", "Wolverhampton Wanderers", "WOL", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000));
        clubs.put("FULHAM", new Club("FC Fulham", "FC Fulham", "FUL", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000));
        clubs.put("BURNLEY", new Club("FC Burnley", "FC Burnley", "BUR", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000));
        clubs.put("SHEFFIELD_UTD", new Club("Sheffield United", "Sheffield United", "SHU", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000));
        clubs.put("LUTON", new Club("Luton Town", "Luton Town", "LUT", LeagueHelper.getByInternalName("ENG_1"), null, 5_000_000));

        //TODO add missing clubs from ClubEnum

        clubs.put("KLAKSVIK", new Club("KÍ Klaksvík", "KÍ Klaksvík", "KIK", LeagueHelper.getByInternalName("FO_1"), null, 500_000));
        clubs.put("HB", new Club("HB Tórshavn", "HB Tórshavn", "HBT", LeagueHelper.getByInternalName("FO_1"), null, 500_000));
        clubs.put("VIKINGUR_GOTA", new Club("Víkingur Gøta", "Víkingur Gøta", "VIK", LeagueHelper.getByInternalName("FO_1"), null, 500_000));
        clubs.put("B36", new Club("B36 Tórshavn", "B36 Tórshavn", "B36", LeagueHelper.getByInternalName("FO_1"), null, 500_000));
        clubs.put("VESTUR", new Club("07 Vestur", "07 Vestur", "VES", LeagueHelper.getByInternalName("FO_1"), null, 500_000));
        clubs.put("STREYMUR", new Club("EB/Streymur", "EB/Streymur", "EBS", LeagueHelper.getByInternalName("FO_1"), null, 500_000));
        clubs.put("TOFTIR", new Club("B68 Toftir", "B68 Toftir", "B68", LeagueHelper.getByInternalName("FO_1"), null, 500_000));
        clubs.put("FUGLAFJORDUR", new Club("ÍF Fuglafjørður", "ÍF Fuglafjørður", "FGL", LeagueHelper.getByInternalName("FO_1"), null, 500_000));
        clubs.put("NSI", new Club("NSÍ Runavík", "NSÍ Runavík", "NSI", LeagueHelper.getByInternalName("FO_1"), null, 500_000));
        clubs.put("SKALA", new Club("Skála IF", "Skála IF", "SKA", LeagueHelper.getByInternalName("FO_1"), null, 500_000));

        Map<Club, List<Player>> result = new HashMap<>();
        for (Club c : clubs.values()) {
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
        for (Club c : clubs.values()) {
            if (c.getLeague().getInternalName().equals(league.getInternalName())) {
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

    public static Map<String, Club> getAllClubs() {
        return clubs;
    }

    public static Club getClubByDisplayName(String displayName) {
        if (displayName == null || displayName.trim().isEmpty()) {
            return null;
        }

        for (Club c : clubs.values()) {
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

        /*for (Club c : clubs) {
            if (c.getInternalName().equals(internalName)) {
                return c;
            }
        }*/

        for (String s : clubs.keySet()) {
            if (s.equals(internalName)) {
                return clubs.get(s);
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
