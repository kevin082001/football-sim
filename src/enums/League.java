package enums;

import java.util.ArrayList;
import java.util.List;

public enum League {
    BUNDESLIGA("Deutsche Bundesliga", Country.DE, true),
    BUNDESLIGA_2("Zweite Bundesliga", Country.DE, true),
    DRITTE_LIGA("3. Liga", Country.DE, true),

    BUNDESLIGA_AUT("Österreichische Bundesliga", Country.AT, true),
    AUT_LIGA_2("Zweite Liga", Country.AT, true),

    SERIE_A("Serie A", Country.IT, true),
    SERIE_B("Serie B", Country.IT, true),

    LALIGA("La Liga Santander", Country.ES, true),
    LALIGA_2("La Liga Smartbank", Country.ES, true),

    LIGUE1("Ligue 1", Country.FR, true),
    LIGUE2("Ligue 2", Country.FR, true),

    EPL("Premier League", Country.GB, true),
    EFL("EFL Championship", Country.GB, true),
    LEAGUE_ONE("League One", Country.GB, true),
    LEAGUE_TWO("League Two", Country.GB, true),

    BESTADEILD("Besta deild", Country.IS, true),

    BETRIDEILD("Betri deild", Country.FO, true),

    SUPERLIGA("Danish Superliga", Country.DK, true),
    DEN_2("1.Division", Country.DK, true),
    DEN_3("2.Division", Country.DK, false),

    ELITESERIEN("Eliteserien", Country.NO, true),
    OBOS_LIGAEN("OBOS-ligaen", Country.NO, true),
    POSTNORD_LIGAEN("PostNord-ligaen", Country.NO, false),

    ALLSVENSKAN("Allsvenskan", Country.SE, true),
    SUPERETTAN("Superettan", Country.SE, true),
    ETTAN_NORRA("Ettan Norra", Country.SE, false),

    DRUGA("Druga Liga", Country.SLO, false), //2nd tier

    B_NACIONAL("Primera B Nacional", Country.AR, false), //2nd tier

    FINNLIIGA("Finnliiga", Country.FI, true),

    YKKONEN("Ykkönen", Country.FI, false),

    PROFESIONAL("División Profesional", Country.BO, false),

    RAIFFEISEN("Raiffeisen Super League", Country.CH, true),

    MEISTRILIIGA("Meistriliiga", Country.EE, true),

    MLS("Major League Soccer", Country.US, true),
    USL("USL Championship", Country.US, false);

    private final String name;

    private final Country country;

    private final boolean playable;

    League(String name, Country country, boolean playable) {
        this.name = name;
        this.country = country;
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
}
