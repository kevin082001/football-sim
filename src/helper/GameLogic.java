package helper;

import GameObjects.Match;
import enums.Club;
import enums.League;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameLogic {
    //private static Club currentClub;
    private static List<Match> matches = new ArrayList<>();
    private final static Random rand = new Random(System.nanoTime());

    public static List<Match> initMatchesForSeason(Club club) {
        List<Match> result = new ArrayList<>();

        League league = club.getLeague();
        List<Club> clubsInLeague = ClubHelper.getClubsForLeague(league);

        for (int homeIndex = 0; homeIndex < clubsInLeague.size(); homeIndex++) {
            for (int awayIndex = homeIndex; awayIndex < clubsInLeague.size(); awayIndex++) {
                if (clubsInLeague.get(homeIndex).equals(clubsInLeague.get(awayIndex))) {
                    continue;
                }
                matches.add(new Match(clubsInLeague.get(homeIndex), clubsInLeague.get(awayIndex), null));
                matches.add(new Match(clubsInLeague.get(awayIndex), clubsInLeague.get(homeIndex), null));
            }
        }

        return shuffleMatches();
    }

    public static Match getNextMatch(Club club) {
        for (Match m : matches) {
            if (m.getScore() != null) {
                continue;
            }
            if (m.getHome().equals(club) || m.getAway().equals(club)) {
                return m;
            }
        }
        return null;
    }

    private static List<Match> shuffleMatches() {
        List<Match> tmp = matches;
        List<Match> shuffled = new ArrayList<>();
        while (!tmp.isEmpty()) {
            Match m = tmp.get(rand.nextInt(tmp.size()));
            shuffled.add(m);
            tmp.remove(m);
        }
        return shuffled;
    }
}
