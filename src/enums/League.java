package enums;

import java.util.ArrayList;
import java.util.List;

public enum League {
    BUNDESLIGA("Deutsche Bundesliga", Country.DE),
    BUNDESLIGA_2("Zweite Bundesliga", Country.DE),
    DRITTE_LIGA("3. Liga", Country.DE),
    BUNDESLIGA_AUT("Österreichische Bundesliga", Country.AT),
    AUT_LIGA_2("Zweite Liga", Country.AT),
    SERIE_A("Serie A", Country.IT),
    SERIE_B("Serie B", Country.IT),
    LALIGA("La Liga Santander", Country.ES),
    LALIGA_2("La Liga Smartbank", Country.ES),
    LIGUE1("Ligue 1", Country.FR),
    LIGUE2("Ligue 2", Country.FR),
    EPL("Premier League", Country.GB),
    EFL("EFL Championship", Country.GB),
    LEAGUE_ONE("League One", Country.GB),
    LEAGUE_TWO("League Two", Country.GB),
    BESTADEILD("Besta deild", Country.IS),
    BETRIDEILD("Betri deild", Country.FO),
    SUPERLIGA("Danish Superliga", Country.DK),
    DEN_2("1.Division Denmark", Country.DK),
    ELITESERIEN("Eliteserien", Country.NO),
    ALLSVENSKAN("Allsvenskan", Country.SE),
    FINNLIIGA("Finnliiga", Country.FI),
    RAIFFEISEN("Raiffeisen Super League", Country.CH),
    MEISTRILIIGA("Meistriliiga", Country.EE),
    MLS("Major League Soccer", Country.US),
    USL("USL Championship", Country.US);

    private final String name;
    private final Country country;

    League(String name, Country country) {
        this.name = name;
        this.country = country;
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

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }
}
