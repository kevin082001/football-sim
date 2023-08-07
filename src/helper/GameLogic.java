package helper;

import GameObjects.LeagueTable;
import GameObjects.Match;
import GameObjects.Player;
import GameObjects.SaveState;
import enums.Club;
import enums.League;

import java.util.*;

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

        table = new LeagueTable(league, new HashMap<>());
        for (Club c : ClubHelper.getClubsForLeague(league)) {
            table.getPoints().put(c, 0);
        }
    }

    public static void updateTable(List<Match> round) {
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

    private static void sortTable(League league) { //TODO not sure if this method works as intended
        LeagueTable sorted = new LeagueTable(league, null);
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

    public static void saveGame(int money, Club currentClub, List<Player> squad){ //TODO think about what else is needed when saving
        //TODO implement (research how to write/read to/from files)
    }

    public static SaveState loadGame(){
        //TODO implement
        return null;
    }

    /*public static void setCurrentClub(Club club){
        currentClub=club;
    }*/
}
