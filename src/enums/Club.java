package enums;

import java.util.ArrayList;
import java.util.List;

public enum Club {
    VEREINSLOS("Vereinslos", League.VEREINSLOS),

    BRIGHTON("Brighton & Hove Albion", League.EPL),

    SOUTHAMPTON("FC Southampton", League.EFL),

    BAYERN("Bayern München", League.BUNDESLIGA),
    BVB("Borussia Dortmund", League.BUNDESLIGA),
    LEIPZIG("RB Leipzig", League.BUNDESLIGA),
    SCHALKE("Schalke 04", League.BUNDESLIGA),

    VIKTORIA_BERLIN("Viktoria Berlin", League.GER_4),

    ANTONIANO("Club Atlético Antoniano", League.SEGUNDA_FEDERACION),

    BRENO("USD Breno",League.SERIE_D),

    FORFAR("Forfar Athletic FC", League.LEAGUE_TWO_SCOTLAND),

    KEITH("Keith FC", League.SCO_5),

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

    NSI("NSÍ Runavík", League.FAROE_2),
    HOYVIK("FC Hoyvík", League.FAROE_2),

    SUDUROY("FC Suðuroy", League.FAROE_3),

    KR_REYKJAVIK("KR Reykjavík", League.BESTADEILD),
    FYLKIR("Fylkir Reykjavík", League.BESTADEILD),
    HAFNARFJORDUR("FH Hafnarfjörður", League.BESTADEILD),
    KOPAVOGUR("HK Kópavogs", League.BESTADEILD),

    GRINDAVIK("UMF Grindavík", League.LENGJUDEILD),
    LEIKNIR("Leiknir Reykjavík", League.LENGJUDEILD),
    AKRANES("ÍA Akranes", League.LENGJUDEILD),

    EKENAS("Ekenäs IF", League.YKKONEN),

    VEJLE("Vejle Boldklub", League.SUPERLIGA),
    ODENSE("Odense BK", League.SUPERLIGA),
    SILKEBORG("Silkeborg IF", League.SUPERLIGA),
    HVIDOVRE("Hvidovre IF", League.SUPERLIGA),
    MIDTJYLLAND("FC Midtjylland", League.SUPERLIGA),
    NORDSJAELLAND("FC Nordsjaelland", League.SUPERLIGA),
    LYNGBY("Lyngby BK", League.SUPERLIGA),
    BRONDBY("Brøndby IF", League.SUPERLIGA),
    RANDERS("Randers FC", League.SUPERLIGA),

    SONDERJYSKE("Sønderjyske", League.DEN_2),
    KOLDING("Kolding IF", League.DEN_2),
    FREDERICIA("FC Fredericia", League.DEN_2),
    HORSENS("AC Horsens", League.DEN_2),
    NAESTVED("Naestved Boldklub", League.DEN_2),
    VENDSYSSEL("Vendsyssel FF", League.DEN_2),
    AALBORG("Aalborg BK", League.DEN_2),

    MIDDELFART("Middelfart Boldklub", League.DEN_3),
    ESBJERG("Esbjerg fB", League.DEN_3),
    NYKOBING("Nykøbing FC", League.DEN_3),
    THISTED("Thisted FC", League.DEN_3),
    SKIVE("Skive IK", League.DEN_3),
    HELLERUP("Hellerup IK", League.DEN_3),
    AKADEMISK("Akademisk BK", League.DEN_3),
    AMAGER("BK Fremad Amager", League.DEN_3),

    ROSKILDE("FC Roskilde", League.DEN_3),

    BRANN("SK Brann", League.ELITESERIEN),
    MOLDE("Molde FK", League.ELITESERIEN),
    HAMKAM("Hamarkameratene", League.ELITESERIEN),
    VIKING("Viking FK", League.ELITESERIEN),
    SARPSBORG("Sarpsborg 08 FF", League.ELITESERIEN),
    STABAEK("Stabæk Fotball", League.ELITESERIEN),
    SANDEFJORD("Sandefjord Fotball",League.ELITESERIEN),

    JERV("FK Jerv", League.OBOS_LIGAEN),
    SANDNES("Sandnes Ulf", League.OBOS_LIGAEN),
    KONGSVINGER("Kongsvinger IL", League.OBOS_LIGAEN),
    HODD("IL Hødd", League.OBOS_LIGAEN),
    RANHEIM("Ranheim IL", League.OBOS_LIGAEN),

    LEVANGER("Levanger FK", League.POSTNORD_LIGAEN),
    NOTODDEN("Notodden FK", League.POSTNORD_LIGAEN),
    TRAEFF("SK Træff", League.POSTNORD_LIGAEN),
    STROMMEN("Strømmen IF",League.POSTNORD_LIGAEN),

    DEGERFORS("Degerfors IF", League.ALLSVENSKAN),
    AIK("AIK Solna", League.ALLSVENSKAN),
    VARBERGS("Varbergs BoIS", League.ALLSVENSKAN),

    HELSINGBORG("Helsingborgs IF", League.SUPERETTAN),
    OREBRO("Örebro SK", League.SUPERETTAN),
    ESKILSTUNA("AFC Eskilstuna", League.SUPERETTAN),
    OSTERS("Östers IF", League.SUPERETTAN),

    DALKURD("Dalkurd FF", League.ETTAN_NORRA),
    LJUNGSKILE("Ljungskile SK", League.ETTAN_SODRA),

    FUZINAR("NK Fuzinar", League.DRUGA),

    NOVI_PAZAR("FK Novi Pazar", League.SRB_1),
    VOZDOVAC("FK Vozdovac", League.SRB_1),
    CUKARICKI("FK Cukaricki", League.SRB_1),

    MACVA("FK Macva Sabac", League.SRB_2),

    ALL_BOYS("CA All Boys", League.B_NACIONAL),

    PETROLERO("Club Independiente Petrolero", League.PROFESIONAL),

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

    public Club getByEnumName(String enumName) {
        if (enumName == null || enumName.trim().isEmpty()) {
            return null;
        }

        for (Club c : Club.values()) {
            if (c.toString().equals(enumName)) {
                return c;
            }
        }

        return null;
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
