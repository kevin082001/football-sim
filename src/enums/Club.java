package enums;

import java.util.ArrayList;
import java.util.List;

public enum Club {
    WITHOUT_CLUB("Without club", League.WITHOUT_CLUB),

    MAN_CITY("Manchester City", League.EPL),
    ARSENAL("FC Arsenal", League.EPL),
    CHELSEA("FC Chelsea", League.EPL),
    LIVERPOOL("FC Liverpool", League.EPL),
    MAN_UTD("Manchester United", League.EPL),
    SPURS("Tottenham Hotspur", League.EPL),
    NEWCASTLE("Newcastle United", League.EPL),
    ASTON_VILLA("Aston Villa", League.EPL),
    BRIGHTON("Brighton & Hove Albion", League.EPL),
    WESTHAM("West Ham United", League.EPL),
    BRENTFORD("FC Brentford", League.EPL),
    NHAM_FOREST("Nottingham Forest", League.EPL),
    CRYSTAL_PALACE("Crystal Palace", League.EPL),
    EVERTON("FC Everton", League.EPL),
    BOURNEMOUTH("AFC Bournemouth", League.EPL),
    WOLVES("Wolverhampton Wanderers", League.EPL),
    FULHAM("FC Fulham", League.EPL),
    BURNLEY("FC Burnley", League.EPL),
    SHEFFIELD_UTD("Sheffield United", League.EPL),
    LUTON("Luton Town", League.EPL),

    LEICESTER("Leicester City", League.EFL),
    SOUTHAMPTON("FC Southampton", League.EFL),
    LEEDS("Leeds United", League.EFL),
    SUNDERLAND("AFC Sunderland", League.EFL),
    HULL_CITY("Hull City", League.EFL),
    MIDDLESBROUGH("FC Middlesbrough", League.EFL),
    NORWICH("Norwich City", League.EFL),
    BLACKBURN("Blackburn Rovers", League.EFL),
    SWANSEA("Swansea City", League.EFL),
    WATFORD("FC Watford", League.EFL),
    STOKE("Stoke City", League.EFL),
    WEST_BROM("West Bromwich Albion", League.EFL),
    COVENTRY("Coventry City", League.EFL),
    BIRMINGHAM("Birmingham City", League.EFL),
    IPSWICH("Ipswich Town", League.EFL),
    CARDIFF("Cardiff City", League.EFL),
    PRESTON_NE("Preston North End", League.EFL),
    MILLWALL("FC Millwall", League.EFL),
    BRISTOL("Bristol City", League.EFL),
    HUDDERSFIELD("Huddersfield Town", League.EFL),
    QUEENS_PR("Queens Park Rangers", League.EFL),
    PLYMOUTH("Plymouth Argyle", League.EFL),
    ROTHERHAM("Rotherham United", League.EFL),
    SHEFFIELD_W("Sheffield Wednesday", League.EFL),

    BAYERN("Bayern München", League.BUNDESLIGA),
    BVB("Borussia Dortmund", League.BUNDESLIGA),
    LEIPZIG("RB Leipzig", League.BUNDESLIGA),
    SCHALKE("Schalke 04", League.BUNDESLIGA),

    VIKTORIA_BERLIN("Viktoria Berlin", League.GER_4),

    ANTONIANO("Club Atlético Antoniano", League.SEGUNDA_FEDERACION),

    BRENO("USD Breno", League.SERIE_D),

    FORFAR("Forfar Athletic FC", League.LEAGUE_TWO_SCOTLAND),

    KEITH("Keith FC", League.SCO_5),

    DUNDALK("Dundalk FC", League.IRL_1),

    VIANENSE("SC Vianense", League.PT_3),

    DEN_BOSCH("FC Den Bosch", League.NED_2),

    HAAKSBERGEN("HSC '21 Haaksbergen", League.NED_4),

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

    NSI("NSÍ Runavík", League.FRO_2),
    HOYVIK("FC Hoyvík", League.FRO_2),
    SKALA("Skála IF", League.FRO_2),

    SUDUROY("FC Suðuroy", League.FRO_3),
    MIDVAGUR("MB Midvágur", League.FRO_3),

    KR_REYKJAVIK("KR Reykjavík", League.BESTADEILD),
    FYLKIR("Fylkir Reykjavík", League.BESTADEILD),
    HAFNARFJORDUR("FH Hafnarfjörður", League.BESTADEILD),
    KOPAVOGUR("HK Kópavogs", League.BESTADEILD),

    GRINDAVIK("UMF Grindavík", League.LENGJUDEILD),
    LEIKNIR("Leiknir Reykjavík", League.LENGJUDEILD),
    AKRANES("ÍA Akranes", League.LENGJUDEILD),
    VESTRI("Vestri Ísafjörður", League.LENGJUDEILD),

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
    SANDEFJORD("Sandefjord Fotball", League.ELITESERIEN),
    AALESUND("Aalesunds FK", League.ELITESERIEN),

    JERV("FK Jerv", League.OBOS_LIGAEN),
    SANDNES("Sandnes Ulf", League.OBOS_LIGAEN),
    KONGSVINGER("Kongsvinger IL", League.OBOS_LIGAEN),
    HODD("IL Hødd", League.OBOS_LIGAEN),
    RANHEIM("Ranheim IL", League.OBOS_LIGAEN),

    LEVANGER("Levanger FK", League.POSTNORD_LIGAEN),
    NOTODDEN("Notodden FK", League.POSTNORD_LIGAEN),
    TRAEFF("SK Træff", League.POSTNORD_LIGAEN),
    STROMMEN("Strømmen IF", League.POSTNORD_LIGAEN),

    DEGERFORS("Degerfors IF", League.ALLSVENSKAN),
    AIK("AIK Solna", League.ALLSVENSKAN),
    VARBERGS("Varbergs BoIS", League.ALLSVENSKAN),

    HELSINGBORG("Helsingborgs IF", League.SUPERETTAN),
    OREBRO("Örebro SK", League.SUPERETTAN),
    ESKILSTUNA("AFC Eskilstuna", League.SUPERETTAN),
    OSTERS("Östers IF", League.SUPERETTAN),
    TRELLEBORGS("Trelleborgs FF", League.SUPERETTAN),

    DALKURD("Dalkurd FF", League.ETTAN_NORRA),
    KARLSTAD("IF Karlstad", League.ETTAN_NORRA),
    LJUNGSKILE("Ljungskile SK", League.ETTAN_SODRA),
    BK_OLYMPIC("BK Olympic", League.ETTAN_SODRA),

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
