package core;

import GameObjects.LeagueTable;
import GameObjects.Match;
import enums.Club;
import enums.League;
import helper.ClubHelper;

import java.util.HashMap;
import java.util.List;

public class SeasonEngine {
    private static int currentRound;
    private static List<Match> matchesThisSeason;
    private static LeagueTable table;

    public static void endCurrentSeason(int season) {
        PlayerEngine.checkForPlayerRetirement(season);

        //TODO implement methods below
        //checkForClubLeagueUpgrade();
        //checkForClubLeagueDowngrade();
        //checkForBallonDOr();
    }

    public static void startNewSeason(int newSeason) {
        resetRound();
        PlayerEngine.checkPlayersJoiningFromAcademy();
        //updateMarketValues(); TODO see issue 'transfer market'
        //updateTransferMarket(); TODO see issue 'transfer market'
        //updatePlayerRatings();
    }

    public static void initTable(Club club) {
        League league = club.getLeague();

        table = new LeagueTable(league, new HashMap<>());
        for (Club c : ClubHelper.getClubsForLeague(league)) {
            table.getPoints().put(c, 0);
        }
    }

    public static void updateTable(List<Match> round) {
        //TODO There's a bug in the points calculation (a team can get more than 3 points after a round)
        // (maybe also has to do with how matches for a round get generated)

        League league = round.get(0).getHome().getLeague();
        for (Match m : round) {
            Club home = m.getHome();
            Club away = m.getAway();
            Integer homePoints = table.getPoints().get(home);
            Integer awayPoints = table.getPoints().get(away);
            if (m.getWinner() == null) {
                table.getPoints().put(home, homePoints + 1);
                table.getPoints().put(away, awayPoints + 1);
            } else if (m.getWinner().equals(home)) {
                table.getPoints().put(home, homePoints + 3);
            } else if (m.getWinner().equals(away)) {
                table.getPoints().put(away, awayPoints + 3);
            }
        }
        sortTable(league);
    }

    private static void sortTable(League league) {
        //TODO table is not sorted correctly
        LeagueTable sorted = new LeagueTable(league, new HashMap<>());
        LeagueTable tmp = sorted;
        Integer highest = 0;

        while (!tmp.getPoints().isEmpty()) {
            Club best = null;
            for (Club c : table.getPoints().keySet()) {
                if (table.getPoints().get(c) > highest) {
                    highest = table.getPoints().get(c);
                    best = c;
                }
            }
            sorted.getPoints().put(best, highest);
            tmp.getPoints().remove(best);
        }
    }

    public static LeagueTable getTable() {
        return table;
    }

    private static void resetRound() {
        currentRound = 0;
    }
}
