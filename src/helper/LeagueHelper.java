package helper;

import enums.Club;
import enums.League;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeagueHelper {
    public static Map<League, List<Club>> initLeagues() {
        Map<League, List<Club>> result = new HashMap<>();
        for (League l : League.values()) {
            result.put(l, ClubHelper.getClubsForLeague(l));
        }
        return result;
    }

}
