package helper;

import enums.Club;
import enums.Country;
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

    public static Map<League, List<Club>> getPlayableLeagues() {
        Map<League, List<Club>> result = new HashMap<>();
        for (League l : League.DE_1.getPlayableLeagues()) {
            result.put(l, ClubHelper.getClubsForLeague(l));
        }
        return result;
    }

    public static Map<Country, List<League>> getCountriesThatHaveLeagues() {
        Map<Country, List<League>> result = new HashMap<>();
        for (Country c : Country.values()) {
            if (!League.DE_1.getByCountry(c).isEmpty()) {
                result.put(c, League.DE_1.getByCountry(c));
            }
        }
        return result;
    }
}
