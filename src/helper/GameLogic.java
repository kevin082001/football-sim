package helper;

import GameObjects.Match;
import enums.Club;
import enums.League;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    //private static Club currentClub;
    private static List<Match> matches;

    public static List<Match> initMatchesForSeason(Club club) {
        List<Match> result = new ArrayList<>();

        League league = club.getLeague();
        List<Club> clubsInLeague = ClubHelper.getClubsForLeague(league);

        //TODO shuffle matches a bit
        for (Club home : clubsInLeague) {
            for (Club away : clubsInLeague) {
                if (home.equals(away)) {
                    continue;
                }
                matches.add(new Match(home, away, null));
                matches.add(new Match(away,home,null));
            }
        }

        return matches;
    }
}
