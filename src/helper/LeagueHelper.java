package helper;

import GameObjects.Club;
import GameObjects.League;
import enums.Country;

import java.util.*;

public class LeagueHelper {
    private final static League[] leagues = new League[]{
            new League("Retired", "Retired", "RETIRED", Country.AQ, 1, false),
            new League("Without club", "Without club", "WITHOUT_CLUB", Country.AQ, 1, false),

            new League("Premier League", "Premier League", "ENG_1", Country.GB, 1, true),
            new League("EFL Championship", "EFL Championship", "ENG_2", Country.GB, 2, true),
            new League("League One", "League One", "ENG_3", Country.GB, 3, true),
            new League("League Two", "League Two", "ENG_4", Country.GB, 4, true),

            new League("Deutsche Bundesliga", "Bundesliga", "DE_1", Country.DE, 1, true),
            new League("Zweite Bundesliga", "Bundesliga 2", "DE_2", Country.DE, 2, true),
            new League("Dritte Liga", "3. Liga", "DE_3", Country.DE, 3, true),
            new League("Regionalliga", "Regionalliga", "DE_4", Country.DE, 4, false),

            new League("Österreichische Bundesliga", "Ö Bundesliga", "AT_1", Country.AT, 1, true),
            new League("Zweite Liga", "Zweite Liga Ö", "AT_2", Country.AT, 2, true),

            new League("Serie A", "Serie A", "IT_1", Country.IT, 1, true),
            new League("Serie B", "Serie B", "IT_2", Country.IT, 2, true),
            new League("Serie C", "Serie C", "IT_3", Country.IT, 3, true),
            new League("Serie D", "Serie D", "IT_4", Country.IT, 4, false),

            new League("LaLiga", "LaLiga", "ES_1", Country.ES, 1, true),
            new League("LaLiga2", "LaLiga2", "ES_2", Country.ES, 2, true),
            new League("Primera Federación", "Primera Federación", "ES_3", Country.ES, 3, true),
            new League("Segunda Federación", "Segunda Federación", "ES_4", Country.ES, 4, false),

            new League("Ligue 1", "Ligue 1", "FR_1", Country.FR, 1, true),
            new League("Ligue 2", "Ligue 2", "FR_2", Country.FR, 2, true),

            new League("Scottish Premiership", "Scottish Premiership", "SCO_1", Country.SCO, 1, true),
            new League("Scottish League Two", "Scottish League Two", "SCO_4", Country.SCO, 4, false),
            new League("Scottish Highland Football League", "Scottish Highland Football League", "SCO_5", Country.SCO, 5, false),

            new League("League Of Ireland Premier Division", "Irish Premier League", "IE_1", Country.IE, 1, true),

            new League("Liga 3", "Liga 3", "PT_3", Country.PT, 3, false),

            new League("Eredivisie", "Eredivisie", "NL_1", Country.NL, 1, true),
            new League("Keuken Kampioen Divisie", "Keuken Kampioen Divisie", "NL_2", Country.NL, 2, true),
            new League("Derde Divisie", "Derde Divisie", "NL_4", Country.NL, 4, false),

            new League("Besta deild", "Besta deild", "IS_1", Country.IS, 1, true),
            new League("Lengjudeild", "Lengjudeild", "IS_2", Country.IS, 2, true),
            new League("2. deild", "2. deild", "IS_3", Country.IS, 3, false),

            new League("Betri deild", "Betri deild", "FO_1", Country.FO, 1, true),
            new League("1. deild", "1. deild", "FO_2", Country.FO, 2, false),
            new League("2. deild", "2. deild", "FO_3", Country.FO, 3, false),

            new League("Danish Superliga", "Danish Superliga", "DK_1", Country.DK, 1, true),
            new League("1. Division", "1. Division", "DK_2", Country.DK, 2, true),
            new League("2. Division", "2. Division", "DK_3", Country.DK, 3, false),

            new League("Eliteserien", "Eliteserien", "NO_1", Country.NO, 1, true),
            new League("OBOS-ligaen", "OBOS-ligaen", "NO_2", Country.NO, 2, true),
            new League("PostNord-ligaen", "PostNord-ligaen", "NO_3", Country.NO, 3, false),
            new League("Norsk Tipping-Ligaen", "Norsk Tipping-ligaen", "NO_4", Country.NO, 4, false),

            new League("Allsvenskan", "Allsvenskan", "SE_1", Country.SE, 1, true),
            new League("Superettan", "Superettan", "SE_2", Country.SE, 2, true),
            new League("Ettan Norra", "Ettan Norra", "SE_3_1", Country.SE, 3, false),
            new League("Ettan Södra", "Ettan Södra", "SE_3_2", Country.SE, 3, false),

            new League("Druga Liga", "Druga Liga", "SI_2", Country.SI, 2, false),

            new League("Primera B Nacional", "Primera B Nacional", "AR_2", Country.AR, 2, false),

            new League("Veikkausliiga", "Veikkausliiga", "FI_1", Country.FI, 1, true),
            new League("Ykkösliiga", "Ykkösliiga", "FI_2", Country.FI, 2, true),
            new League("Ykkönen", "Ykkönen", "FI_3", Country.FI, 3, false),

            new League("Super liga Srbije", "Super liga Srbije", "RS_1", Country.RS, 1, true),
            new League("Prva liga Srbije", "Prva liga Srbije", "RS_2", Country.RS, 2, false),

            new League("División Profesional", "División Profesional", "BO_1", Country.BO, 1, false),

            new League("Raiffeisen Super League", "Raiffeisen Super League", "CH_1", Country.CH, 1, true),

            new League("Premium Liiga", "Premium Liiga", "EE_1", Country.EE, 1, true),

            new League("Major League Soccer", "MLS", "US_1", Country.US, 1, true),
            new League("USL Championship", "USL Championship", "US_2", Country.US, 2, false),
    };

    public static Map<League, List<Club>> initLeagues() {
        Map<League, List<Club>> result = new HashMap<>();
        for (League l : leagues) {
            result.put(l, ClubHelper.getClubsForLeague(l));
        }
        return result;
    }

    public static Map<League, List<Club>> getPlayableLeagues() {
        Map<League, List<Club>> result = new HashMap<>();
        for (League l : leagues) {
            result.put(l, ClubHelper.getClubsForLeague(l));
        }
        return result;
    }

    public static Map<Country, List<League>> getCountriesThatHaveLeagues() {
        Map<Country, List<League>> result = new HashMap<>();
        for (Country c : Country.values()) {
            List<League> leaguesByCountry = getByCountry(c);
            if (!leaguesByCountry.isEmpty()) {
                result.put(c, leaguesByCountry);
            }
        }
        return result;
    }

    public static List<League> getAllLeagues() {
        return Arrays.asList(leagues);
    }

    public static List<League> getByCountry(Country country) {
        if (country == null) {
            return new ArrayList<>();
        }

        List<League> result = new ArrayList<>();

        for (League l : leagues) {
            if (l.getCountry().equals(country)) {
                result.add(l);
            }
        }

        return result;
    }

    public static League getByInternalName(String internalName) {
        if (internalName == null || internalName.trim().isEmpty()) {
            return null;
        }

        for (League l : leagues) {
            if (l.getInternalName().equals(internalName)) {
                return l;
            }
        }

        return null;
    }
}
