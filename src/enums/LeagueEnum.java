package enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @deprecated This class will be removed soon and replaced with {@link GameObjects.League}.
 */
public enum LeagueEnum {
    RETIRED("Retired", Country.AQ, 1, false),
    WITHOUT_CLUB("Without club", Country.AQ, 1, false),

    ENG_1("Premier League", Country.GB, 1, true),
    ENG_2("EFL Championship", Country.GB, 2, true),
    ENG_3("League One", Country.GB, 3, true),
    ENG_4("League Two", Country.GB, 4, true),

    DE_1("Deutsche Bundesliga", Country.DE, 1, true),
    DE_2("Zweite Bundesliga", Country.DE, 2, true),
    DE_3("3. Liga", Country.DE, 3, true),
    DE_4("Regionalliga", Country.DE, 4, false),

    AT_1("Österreichische Bundesliga", Country.AT, 1, true),
    AT_2("Zweite Liga", Country.AT, 2, true),

    IT_1("Serie A", Country.IT, 1, true),
    IT_2("Serie B", Country.IT, 2, true),
    IT_3("Serie C", Country.IT, 3, true),
    IT_4("Serie D", Country.IT, 4, false),

    ES_1("LaLiga", Country.ES, 1, true),
    ES_2("LaLiga2", Country.ES, 2, true),
    ES_3("Primera Federación", Country.ES, 3, true),
    ES_4("Segunda Federación", Country.ES, 4, false),

    FR_1("Ligue 1", Country.FR, 1, true),
    FR_2("Ligue 2", Country.FR, 2, true),

    SCO_1("Scottish Premiership", Country.SCO, 1, true),
    SCO_2("Scottish League Two", Country.SCO, 4, false),
    SCO_5("Scottish Highland Football League", Country.SCO, 5, false),

    IE_1("League Of Ireland Premier Division", Country.IE, 1, true),

    PT_3("Liga 3", Country.PT, 3, false),

    NL_1("Eredivisie", Country.NL, 1, true),
    NL_2("Keuken Kampioen Divisie", Country.NL, 2, true),

    NL_4("Derde Divisie", Country.NL, 4, false),

    IS_1("Besta deild", Country.IS, 1, true),

    IS_2("Lengjudeild", Country.IS, 2, true),
    IS_3("2. deild", Country.IS, 3, false),

    FO_1("Betri deild", Country.FO, 1, true),

    FO_2("1. deild", Country.FO, 2, false),

    FO_3("2. deild", Country.FO, 3, false),

    DK_1("Danish Superliga", Country.DK, 1, true),

    DK_2("1.Division", Country.DK, 2, true),

    DK_3("2.Division", Country.DK, 3, false),

    NO_1("Eliteserien", Country.NO, 1, true),

    NO_2("OBOS-ligaen", Country.NO, 2, true),

    NO_3("PostNord-ligaen", Country.NO, 3, false),
    NO_4("Norsk Tipping-Ligaen", Country.NO, 4, false),

    SE_1("Allsvenskan", Country.SE, 1, true),

    SE_2("Superettan", Country.SE, 2, true),

    SE_3_1("Ettan Norra", Country.SE, 3, false),

    SE_3_2("Ettan Södra", Country.SE, 3, false),

    SI_1("Druga Liga", Country.SI, 2, false),

    AR_2("Primera B Nacional", Country.AR, 2, false),

    FI_1("Veikkausliiga", Country.FI, 1, true),

    FI_2("Ykkösliiga", Country.FI, 2, true),
    FI_3("Ykkönen", Country.FI, 3, true),

    RS_1("Super liga Srbije", Country.RS, 1, true),

    RS_2("Prva liga Srbije", Country.RS, 2, false),

    BO_1("División Profesional", Country.BO, 1, true),

    CH_1("Raiffeisen Super League", Country.CH, 1, true),

    EE_1("Premium Liiga", Country.EE, 1, true),

    US_1("Major League Soccer", Country.US, 1, true),

    US_2("USL Championship", Country.US, 2, true);

    private final String name;

    private final Country country;

    private final int tier;

    private final boolean playable;

    LeagueEnum(String name, Country country, int tier, boolean playable) {
        this.name = name;
        this.country = country;
        this.tier = tier;
        this.playable = playable;
    }

    public List<LeagueEnum> getByCountry(Country country) {
        if (country == null) return null;

        List<LeagueEnum> result = new ArrayList<>();
        for (LeagueEnum l : LeagueEnum.values()) {
            if (l.getCountry().equals(country)) {
                result.add(l);
            }
        }
        return result;
    }

    public List<LeagueEnum> getPlayableLeagues() {
        List<LeagueEnum> leagues = new ArrayList<>();
        for (LeagueEnum l : LeagueEnum.values()) {
            if (l.playable) {
                leagues.add(l);
            }
        }
        return leagues;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public int getTier() {
        return tier;
    }

    public boolean isPlayable() {
        return playable;
    }
}
