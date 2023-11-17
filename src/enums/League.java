package enums;

import java.util.ArrayList;
import java.util.List;

public enum League { //TODO maybe also save the tier (f.e. Bundesliga -> 1, Dritte Liga -> 3,...)
    VEREINSLOS("Vereinslos", Country.AT, 1, false),

    BUNDESLIGA("Deutsche Bundesliga", Country.DE, 1, true),
    BUNDESLIGA_2("Zweite Bundesliga", Country.DE, 2, true),
    DRITTE_LIGA("3. Liga", Country.DE, 3, true),
    GER_4("Regionalliga", Country.DE, 4, false),

    BUNDESLIGA_AUT("Österreichische Bundesliga", Country.AT, 1, true),
    AUT_LIGA_2("Zweite Liga", Country.AT, 2, true),

    SERIE_A("Serie A", Country.IT, 1, true),
    SERIE_B("Serie B", Country.IT, 2, true),
    SERIE_C("Serie C", Country.IT, 3, true),
    SERIE_D("Serie D", Country.IT, 4, false),

    LALIGA("La Liga Santander", Country.ES, 1, true),
    LALIGA_2("La Liga Smartbank", Country.ES, 2, true),
    //SPANISH 3rd TIER
    SEGUNDA_FEDERACION("Segunda Federación", Country.ES, 4, false),

    LIGUE1("Ligue 1", Country.FR, 1, true),
    LIGUE2("Ligue 2", Country.FR, 2, true),

    EPL("Premier League", Country.GB, 1, true),
    EFL("EFL Championship", Country.GB, 2, true),
    LEAGUE_ONE("League One", Country.GB, 3, true),
    LEAGUE_TWO("League Two", Country.GB, 4, true),

    LEAGUE_TWO_SCOTLAND("Scottish League Two", Country.SCO, 4, false),
    SCO_5("Scottish Highland Football League", Country.SCO, 5, false),

    IRL_1("League Of Ireland Premier Division", Country.IE, 1, true),

    NED_2("Keuken Kampioen Divisie", Country.NL, 2, true),

    NED_4("Derde Divisie", Country.NL, 4, false),

    BESTADEILD("Besta deild", Country.IS, 1, true),

    LENGJUDEILD("Lengjudeild", Country.IS, 2, true),

    BETRIDEILD("Betri deild", Country.FO, 1, true),

    FRO_2("1. deild", Country.FO, 2, true),

    FRO_3("2. deild", Country.FO, 3, false),

    SUPERLIGA("Danish Superliga", Country.DK, 1, true),

    DEN_2("1.Division", Country.DK, 2, false),

    DEN_3("2.Division", Country.DK, 3, false),

    ELITESERIEN("Eliteserien", Country.NO, 1, true),

    OBOS_LIGAEN("OBOS-ligaen", Country.NO, 2, false),

    POSTNORD_LIGAEN("PostNord-ligaen", Country.NO, 3, false),

    ALLSVENSKAN("Allsvenskan", Country.SE, 1, true),

    SUPERETTAN("Superettan", Country.SE, 2, false),

    ETTAN_NORRA("Ettan Norra", Country.SE, 3, false),

    ETTAN_SODRA("Ettan Södra", Country.SE, 3, false),

    DRUGA("Druga Liga", Country.SLO, 2, false),

    B_NACIONAL("Primera B Nacional", Country.AR, 2, false),

    FINNLIIGA("Finnliiga", Country.FI, 1, true),

    YKKONEN("Ykkönen", Country.FI, 2, false),

    SRB_1("Super liga Srbije", Country.SRB, 1, true),

    SRB_2("Prva liga Srbije", Country.SRB, 2, false),

    PROFESIONAL("División Profesional", Country.BO, 1, false),

    RAIFFEISEN("Raiffeisen Super League", Country.CH, 1, true),

    MEISTRILIIGA("Meistriliiga", Country.EE, 1, true),

    MLS("Major League Soccer", Country.US, 1, true),

    USL("USL Championship", Country.US, 2, false);

    private final String name;

    private final Country country;

    private final int tier;

    private final boolean playable;

    League(String name, Country country, int tier, boolean playable) {
        this.name = name;
        this.country = country;
        this.tier = tier;
        this.playable = playable;
    }

    public List<League> getByCountry(Country country) {
        if (country == null) return null;

        List<League> result = new ArrayList<>();
        for (League l : League.values()) {
            if (l.getCountry().equals(country)) {
                result.add(l);
            }
        }
        return result;
    }

    public List<League> getPlayableLeagues() {
        List<League> leagues = new ArrayList<>();
        for (League l : League.values()) {
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
