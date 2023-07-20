package enums;

import java.util.ArrayList;
import java.util.List;

public enum Club {
    BAYERN("Bayern München", League.BUNDESLIGA),
    BVB("Borussia Dortmund", League.BUNDESLIGA),
    LEIPZIG("RB Leipzig", League.BUNDESLIGA),
    SCHALKE("Schalke 04", League.BUNDESLIGA),

    ARGIR("AB Argir", League.BETRIDEILD),
    TOFTIR("B68 Toftir", League.BETRIDEILD),
    STREYMUR("EB/Streymur", League.BETRIDEILD),
    B36("B36 Tórshavn", League.BETRIDEILD),
    KLAKSVIK("KI Klaksvík", League.BETRIDEILD),
    HB("HB Tórshavn", League.BETRIDEILD),
    FUGLAFJORDUR("ÍF Fuglafjørður", League.BETRIDEILD),
    VIKINGUR_GOTA("Víkingur Gøta", League.BETRIDEILD),
    VESTUR("07 Vestur", League.BETRIDEILD),
    TVOROYRI("TB Tvøroyri", League.BETRIDEILD),

    LEIKNIR("Leiknir Reykjavík", League.BESTADEILD),
    FYLKIR("Fylkir Reykjavík", League.BESTADEILD),
    HAFNARFJORDUR("FH Hafnarfjörður", League.BESTADEILD),

    BRANN("SK Brann", League.ELITESERIEN),

    VEJLE("Vejle Boldklub", League.SUPERLIGA),
    ODENSE("Odense BK", League.SUPERLIGA),
    SILKEBORG("Silkeborg IF", League.SUPERLIGA),
    HVIDOVRE("Hvidovre IF", League.SUPERLIGA),
    MIDTJYLLAND("FC Midtjylland", League.SUPERLIGA),

    SONDERJYSKE("Sønderjyske", League.DEN_2),
    KOLDING("Kolding IF", League.DEN_2),
    FREDERICIA("FC Fredericia", League.DEN_2),
    HORSENS("AC Horsens", League.DEN_2),

    MIDDELFART("Middelfart Boldklub", League.DEN_3),
    ESBJERG("Esbjerg fB", League.DEN_3),
    NYKOBING("Nykøbing FC", League.DEN_3),
    THISTED("Thisted FC", League.DEN_3),
    SKIVE("Skive IK", League.DEN_3),

    JERV("FK Jerv", League.OBOS_LIGAEN),
    SANDNES("Sandnes Ulf", League.OBOS_LIGAEN),
    KONGSVINGER("Kongsvinger IL", League.OBOS_LIGAEN),

    DEGERFORS("Degerfors IF", League.ALLSVENSKAN),
    AIK("AIK Solna", League.ALLSVENSKAN),

    HELSINGBORG("Helsingborgs IF", League.SUPERETTAN),
    OREBRO("Örebro SK", League.SUPERETTAN),
    ESKILSTUNA("AFC Eskilstuna", League.SUPERETTAN),

    DALKURD("Dalkurd FF", League.ETTAN_NORRA),

    INDY_ELEVEN("Indy Eleven", League.USL);


    private final String name;
    private League league;

    Club(String name, League league) {
        this.name = name;
        this.league = league;
    }

    public List<Club> getByLeague(League league) {
        if (league == null) return null;

        List<Club> result = new ArrayList<>();
        for (Club c : Club.values()) {
            if (c.getLeague().equals(league)) {
                result.add(c);
            }
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
}
