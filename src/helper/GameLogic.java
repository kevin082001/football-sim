package helper;

import GameObjects.LeagueTable;
import GameObjects.Match;
import enums.Club;
import enums.League;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GameLogic {
    //private static Club currentClub;
    //private static List<Match> matches = new ArrayList<>();
    private final static Random rand = new Random(System.nanoTime());

    private static LeagueTable table;

    public static List<Match> initMatchesForSeason(Club club) {
        List<Match> result = new ArrayList<>();

        League league = club.getLeague();
        List<Club> clubsInLeague = ClubHelper.getClubsForLeague(league);

        for (int homeIndex = 0; homeIndex < clubsInLeague.size(); homeIndex++) {
            for (int awayIndex = homeIndex; awayIndex < clubsInLeague.size(); awayIndex++) {
                if (clubsInLeague.get(homeIndex).equals(clubsInLeague.get(awayIndex))) {
                    continue;
                }
                result.add(new Match(clubsInLeague.get(homeIndex), clubsInLeague.get(awayIndex), null));
                result.add(new Match(clubsInLeague.get(awayIndex), clubsInLeague.get(homeIndex), null));
            }
        }

        return shuffleMatches(result);
    }

    public static Match getNextMatch(Club club, List<Match> matchesThisSeason) {
        for (Match m : matchesThisSeason) {
            if (m.getScore() != null) {
                continue;
            }
            if (m.getHome().equals(club) || m.getAway().equals(club)) {
                return m;
            }
        }
        return null;
    }

    public static void initTable(Club club) {
        League league = club.getLeague();

        table = new LeagueTable(league, null);
        for (Club c : ClubHelper.getClubsForLeague(league)) {
            table.getPoints().put(c, 0);
        }
    }

    public static void updateTable(List<Match> round) {
        for (Match m : round) {
            Club home = m.getHome();
            Club away = m.getAway();
            Integer homePoints = table.getPoints().get(home);
            Integer awayPoints = table.getPoints().get(away);
            if (m.getWinner() == null) {
                table.getPoints().put(home, homePoints + 1);
                table.getPoints().put(away, awayPoints + 1);
            }
        }
        //TODO update ranking after properly setting points
    }

    public static LeagueTable getTable() {
        return table;
    }

    private static List<Match> shuffleMatches(List<Match> toShuffle) {
        List<Match> shuffled = new ArrayList<>();

        while (!toShuffle.isEmpty()) {
            Match m = toShuffle.get(rand.nextInt(toShuffle.size()));
            shuffled.add(m);
            toShuffle.remove(m);
        }
        return shuffled;
    }

    /*public static void setCurrentClub(Club club){
        currentClub=club;
    }*/
}
