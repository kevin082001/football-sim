package enums;

import java.util.ArrayList;
import java.util.List;

public enum Club {
    WITHOUT_CLUB("Without club", League.WITHOUT_CLUB),

    MAN_CITY("Manchester City", League.ENG_1),
    ARSENAL("FC Arsenal", League.ENG_1),
    CHELSEA("FC Chelsea", League.ENG_1),
    LIVERPOOL("FC Liverpool", League.ENG_1),
    MAN_UTD("Manchester United", League.ENG_1),
    SPURS("Tottenham Hotspur", League.ENG_1),
    NEWCASTLE("Newcastle United", League.ENG_1),
    ASTON_VILLA("Aston Villa", League.ENG_1),
    BRIGHTON("Brighton & Hove Albion", League.ENG_1),
    WESTHAM("West Ham United", League.ENG_1),
    BRENTFORD("FC Brentford", League.ENG_1),
    NHAM_FOREST("Nottingham Forest", League.ENG_1),
    CRYSTAL_PALACE("Crystal Palace", League.ENG_1),
    EVERTON("FC Everton", League.ENG_1),
    BOURNEMOUTH("AFC Bournemouth", League.ENG_1),
    WOLVES("Wolverhampton Wanderers", League.ENG_1),
    FULHAM("FC Fulham", League.ENG_1),
    BURNLEY("FC Burnley", League.ENG_1),
    SHEFFIELD_UTD("Sheffield United", League.ENG_1),
    LUTON("Luton Town", League.ENG_1),

    LEICESTER("Leicester City", League.ENG_2),
    SOUTHAMPTON("FC Southampton", League.ENG_2),
    LEEDS("Leeds United", League.ENG_2),
    SUNDERLAND("AFC Sunderland", League.ENG_2),
    HULL_CITY("Hull City", League.ENG_2),
    MIDDLESBROUGH("FC Middlesbrough", League.ENG_2),
    NORWICH("Norwich City", League.ENG_2),
    BLACKBURN("Blackburn Rovers", League.ENG_2),
    SWANSEA("Swansea City", League.ENG_2),
    WATFORD("FC Watford", League.ENG_2),
    STOKE("Stoke City", League.ENG_2),
    WEST_BROM("West Bromwich Albion", League.ENG_2),
    COVENTRY("Coventry City", League.ENG_2),
    BIRMINGHAM("Birmingham City", League.ENG_2),
    IPSWICH("Ipswich Town", League.ENG_2),
    CARDIFF("Cardiff City", League.ENG_2),
    PRESTON_NE("Preston North End", League.ENG_2),
    MILLWALL("FC Millwall", League.ENG_2),
    BRISTOL("Bristol City", League.ENG_2),
    HUDDERSFIELD("Huddersfield Town", League.ENG_2),
    QUEENS_PR("Queens Park Rangers", League.ENG_2),
    PLYMOUTH("Plymouth Argyle", League.ENG_2),
    ROTHERHAM("Rotherham United", League.ENG_2),
    SHEFFIELD_W("Sheffield Wednesday", League.ENG_2),

    PBOROUGH("Peterborough United", League.ENG_3),
    DERBY_COUNTY("Derby County", League.ENG_3),
    BARNSLEY("FC Barnsley", League.ENG_3),
    READING("FC Reading", League.ENG_3),
    BLACKPOOL("FC Blackpool", League.ENG_3),
    CHARLTON("Charlton Athletic", League.ENG_3),
    PORTSMOUTH("FC Portsmouth", League.ENG_3),
    BOLTON("Bolton Wanderers", League.ENG_3),
    WIGAN("Wigan Athletic", League.ENG_3),
    BRISTOL_ROVERS("Bristol Rovers", League.ENG_3),
    OXFORD("Oxford United", League.ENG_3),
    EXETER("Exeter City", League.ENG_3),
    LINCOLN("Lincoln City", League.ENG_3),
    FLEETWOOD("Fleetwood Town", League.ENG_3),
    WYCOMBE("Wycombe Wanderers", League.ENG_3),
    PORT_VALE("FC Port Vale", League.ENG_3),
    STEVENAGE("FC Stevenage", League.ENG_3),
    CARLISLE("Carlisle United", League.ENG_3),
    SHREWSBURY("Shrewsbury Town", League.ENG_3),
    NORTHAMPTON("Northampton Town", League.ENG_3),
    LEYTON("Leyton Orient", League.ENG_3),
    CAMBRIDGE("Cambrige United", League.ENG_3),
    BURTON("Burton Albion", League.ENG_3),
    CHELTENHAM("Cheltenham Town", League.ENG_3),

    WREXHAM("AFC Wrexham", League.ENG_4),
    STOCKPORT("Stockport County", League.ENG_4),
    FOREST_GREEN("Forest Green Rovers", League.ENG_4),
    COLCHESTER("Colchester United", League.ENG_4),
    MK_DONS("Milton Keynes Dons", League.ENG_4),
    CREWE("Crewe Alexandra", League.ENG_4),
    BRADFORD("Bradford City", League.ENG_4),
    GRIMSBY("Grimsby Town", League.ENG_4),
    DONCASTER("Doncaster Rovers", League.ENG_4),
    MANSFIELD("Mansfield", League.ENG_4),
    SALFORD("Salford City", League.ENG_4),
    GILLINGHAM("FC Gillingham", League.ENG_4),
    WALSALL("FC Walsall", League.ENG_4),
    BARROW("AFC Barrow", League.ENG_4),
    WIMBLEDON("AFC Wimbledon", League.ENG_4),
    MORECAMBE("FC Morecambe", League.ENG_4),
    NOTTS_COUNTY("Notts County", League.ENG_4),
    STANLEY("Accrington Stanley", League.ENG_4),
    TRANMERE("Tranmere Rovers", League.ENG_4),
    NEWPORT("Newport County", League.ENG_4),
    SWINDON("Swindon Town", League.ENG_4),
    HARROGATE("Harrogate Town", League.ENG_4),
    SUTTON("Sutton United", League.ENG_4),
    CRAWLEY("Crawley Town", League.ENG_4),

    BAYERN("Bayern München", League.DE_1),
    LEVERKUSEN("Bayer 04 Leverkusen", League.DE_1),
    LEIPZIG("RB Leipzig", League.DE_1),
    BVB("Borussia Dortmund", League.DE_1),
    WOLFSBURG("VfL Wolfsburg", League.DE_1),
    FRANKFURT("Eintracht Frankfurt", League.DE_1),
    STUTTGART("VfB Stuttgart", League.DE_1),
    BORUSSIA_M("Borussia Mönchengladbach", League.DE_1),
    FREIBURG("SC Freiburg", League.DE_1),
    UNION("1.FC Union Berlin", League.DE_1),
    TSG("TSG 1899 Hoffenheim", League.DE_1),
    AUGSBURG("FC Augsburg", League.DE_1),
    MAINZ("FSV Mainz 05", League.DE_1),
    KOLN("1.FC Köln", League.DE_1),
    BREMEN("SV Werder Bremen", League.DE_1),
    BOCHUM("VfL Bochum", League.DE_1),
    HEIDENHEIM("1.FC Heidenheim 1846", League.DE_1),
    DARMSTADT("SV Darmstadt 98", League.DE_1),

    HSV("Hamburger SV", League.DE_2),
    HERTHA("Hertha BSC", League.DE_2),
    DUSSELDORF("Fortuna Düsseldorf", League.DE_2),
    SCHALKE("Schalke 04", League.DE_2),
    NURNBERG("1.FC Nürnberg", League.DE_2),
    HANNOVER("Hannover 96", League.DE_2),
    STPAULI("FC St. Pauli", League.DE_2),
    KIEL("Holstein Kiel", League.DE_2),
    FURTH("SpVgg Greuther Fürth", League.DE_2),
    KAISERSLAUTERN("1.FC Kaiserslautern", League.DE_2),
    PADERBORN("SC Paderborn 07", League.DE_2),
    ELVERSBERG("SV 07 Elversberg", League.DE_2),
    MAGDEBURG("1.FC Magdeburg", League.DE_2),
    KSC("Karlsruher SC", League.DE_2),
    WIESBADEN("SV Wehen Wiesbaden", League.DE_2),
    ROSTOCK("FC Hansa Rostock", League.DE_2),
    OSNABRUCK("VfL Osnabrück", League.DE_2),
    BRAUNSCHWEIG("Eintracht Braunschweig", League.DE_2),

    BVB_II("Borussia Dortmund II", League.DE_3),
    DYNAMO_DRESDEN("SG Dynamo Dresden", League.DE_3),
    FREIBURG_II("SC Freiburg II", League.DE_3),
    SANDHAUSEN("SV Sandhausen", League.DE_3),
    INGOLSTADT("FC Ingolstadt 04", League.DE_3),
    DUISBURG("MSV Duisburg", League.DE_3),
    REGENSBURG("SSV Jahn Regensburg", League.DE_3),
    BIELEFELD("Arminia Bielefeld", League.DE_3),
    SAARBRUCKEN("1.FC Saarbrücken", League.DE_3),
    HALLESCHER("Hallescher FC", League.DE_3),
    MUNICH_1860("TSV 1860 München", League.DE_3),
    MANNHEIM("SV Waldhof Mannheim", League.DE_3),
    VIKTORIA_KOLN("FC Viktoria Köln", League.DE_3),
    RW_ESSEN("Rot-Weiss Essen", League.DE_3),
    PREUSSEN("Preußen Münster", League.DE_3),
    VERL("SC Verl", League.DE_3),
    ERZGEBIRGE("FC Erzgebirge Aue", League.DE_3),
    ULM("SSV Ulm 1846", League.DE_3),
    UNTERHACHING("SpVgg Unterhaching", League.DE_3),
    LUBECK("VfB Lübeck", League.DE_3),

    VIKTORIA_BERLIN("FC Viktoria 1889 Berlin", League.DE_4),

    ANTONIANO("Club Atlético Antoniano", League.ES_4),

    BRENO("USD Breno", League.IT_4),

    FORFAR("Forfar Athletic FC", League.SCO_2),

    KEITH("Keith FC", League.SCO_5),

    DUNDALK("Dundalk FC", League.IE_1),

    VIANENSE("SC Vianense", League.PT_3),

    DEN_BOSCH("FC Den Bosch", League.NL_2),

    HAAKSBERGEN("HSC '21 Haaksbergen", League.NL_4),

    KLAKSVIK("KÍ Klaksvík", League.FO_1),
    HB("HB Tórshavn", League.FO_1),
    VIKINGUR_GOTA("Víkingur Gøta", League.FO_1),
    B36("B36 Tórshavn", League.FO_1),
    VESTUR("07 Vestur", League.FO_1),
    STREYMUR("EB/Streymur", League.FO_1),
    TOFTIR("B68 Toftir", League.FO_1),
    FUGLAFJORDUR("ÍF Fuglafjørður", League.FO_1),
    NSI("NSÍ Runavík", League.FO_1),
    SKALA("Skála IF", League.FO_1),

    ARGIR("AB Argir", League.FO_2),
    TVOROYRI("TB Tvøroyri", League.FO_2),
    VIKINGUR_GOTA_II("Víkingur Gøta II", League.FO_2),
    HB_II("HB Tórshavn II", League.FO_2),
    B36_II("B36 Tórshavn II", League.FO_2),
    KLAKSVIK_II("KÍ Klaksvík II", League.FO_2),
    NSI_II("NSÍ Runavík II", League.FO_2),
    B71("B71 Sandoy", League.FO_2),
    HOYVIK("FC Hoyvík", League.FO_2),
    SUDUROY("FC Suðuroy", League.FO_2),

    MIDVAGUR("MB Midvágur", League.FO_3),

    VIKINGUR_RVK("Víkingur Reykjavík", League.IS_1),
    VALUR("Valur Reykjavík", League.IS_1),
    BREIDABLIK("Breiðablik Kópavogur", League.IS_1),
    KR_RVK("KR Reykjavík", League.IS_1),
    STJARNAN("Stjarnan Garðabær", League.IS_1),
    AKUREYRI("KA Akureyri", League.IS_1),
    VESTRI("Vestri Ísafjörður", League.IS_1),
    HAFNARFJORDUR("FH Hafnarfjörður", League.IS_1),
    FRAM("Fram Reykjavík", League.IS_1),
    FYLKIR("Fylkir Reykjavík", League.IS_1),
    AKRANES("ÍA Akranes", League.IS_1),
    KOPAVOGUR("HK Kópavogs", League.IS_1),

    AFTURELDING("UMF Afturelding", League.IS_2),
    KEFLAVIK("Keflavík ÍF", League.IS_2),
    GRINDAVIK("UMF Grindavík", League.IS_2),
    IBV("ÍBV Vestmannaeyjar", League.IS_2),
    FJOLNIR("Fjölnir Reykjavík", League.IS_2),
    THOR("Þór Akureyri", League.IS_2),
    THROTTUR_RVK("Þróttur Reykjavík", League.IS_2),
    LEIKNIR("Leiknir Reykjavík", League.IS_2),
    GROTTA("ÍF Grótta", League.IS_2),
    NJARDVIK("UMF Njarðvík", League.IS_2),
    IR_RVK("ÍR Reykjavík", League.IS_2),
    DALVIK("Dalvík/Reynir", League.IS_2),

    SELFOSS("UMF Selfoss", League.IS_3),
    VIKINGUR_O("UMF Víkingur Ólafsvík", League.IS_3),
    THROTTUR_V("Þróttur Vogum", League.IS_3),
    AEGIR("KF Ægir", League.IS_3),
    KFG("KFG Garðabær", League.IS_3),
    KFA("KFA Austfjarða", League.IS_3),
    HOTTUR("Höttur/Huginn", League.IS_3),
    VOLSUNGUR("Völsungur ÍF", League.IS_3),
    HAUKAR("Haukar Hafnarfjörður", League.IS_3),
    FJALLABYGGD("KF Fjallabyggd", League.IS_3),
    SANDGERDI("Reynir Sandgerði", League.IS_3),
    KORMAKUR("Kormákur/Hvöt", League.IS_3),

    EKENAS("Ekenäs IF", League.FI_1),

    VEJLE("Vejle Boldklub", League.DK_1),
    ODENSE("Odense BK", League.DK_1),
    SILKEBORG("Silkeborg IF", League.DK_1),
    HVIDOVRE("Hvidovre IF", League.DK_1),
    MIDTJYLLAND("FC Midtjylland", League.DK_1),
    NORDSJAELLAND("FC Nordsjaelland", League.DK_1),
    LYNGBY("Lyngby BK", League.DK_1),
    BRONDBY("Brøndby IF", League.DK_1),
    RANDERS("Randers FC", League.DK_1),

    SONDERJYSKE("Sønderjyske", League.DK_2),
    KOLDING("Kolding IF", League.DK_2),
    FREDERICIA("FC Fredericia", League.DK_2),
    HORSENS("AC Horsens", League.DK_2),
    NAESTVED("Naestved Boldklub", League.DK_2),
    VENDSYSSEL("Vendsyssel FF", League.DK_2),
    AALBORG("Aalborg BK", League.DK_2),

    MIDDELFART("Middelfart Boldklub", League.DK_3),
    ESBJERG("Esbjerg fB", League.DK_3),
    NYKOBING("Nykøbing FC", League.DK_3),
    THISTED("Thisted FC", League.DK_3),
    SKIVE("Skive IK", League.DK_3),
    HELLERUP("Hellerup IK", League.DK_3),
    AKADEMISK("Akademisk BK", League.DK_3),
    AMAGER("BK Fremad Amager", League.DK_3),

    ROSKILDE("FC Roskilde", League.DK_3),

    BRANN("SK Brann", League.NO_1),
    MOLDE("Molde FK", League.NO_1),
    HAMKAM("Hamarkameratene", League.NO_1),
    VIKING("Viking FK", League.NO_1),
    SARPSBORG("Sarpsborg 08 FF", League.NO_1),
    STABAEK("Stabæk Fotball", League.NO_1),
    SANDEFJORD("Sandefjord Fotball", League.NO_1),
    AALESUND("Aalesunds FK", League.NO_1),

    JERV("FK Jerv", League.NO_2),
    SANDNES("Sandnes Ulf", League.NO_2),
    KONGSVINGER("Kongsvinger IL", League.NO_2),
    HODD("IL Hødd", League.NO_2),
    RANHEIM("Ranheim IL", League.NO_2),

    LEVANGER("Levanger FK", League.NO_3),
    NOTODDEN("Notodden FK", League.NO_3),
    TRAEFF("SK Træff", League.NO_3),
    STROMMEN("Strømmen IF", League.NO_3),

    SK_TRAEFF("SK Træff", League.NO_4),

    DEGERFORS("Degerfors IF", League.SE_1),
    AIK("AIK Solna", League.SE_1),
    VARBERGS("Varbergs BoIS", League.SE_1),

    HELSINGBORG("Helsingborgs IF", League.SE_2),
    OREBRO("Örebro SK", League.SE_2),
    ESKILSTUNA("AFC Eskilstuna", League.SE_2),
    OSTERS("Östers IF", League.SE_2),
    TRELLEBORGS("Trelleborgs FF", League.SE_2),

    DALKURD("Dalkurd FF", League.SE_3_1),
    KARLSTAD("IF Karlstad", League.SE_3_1),
    LJUNGSKILE("Ljungskile SK", League.SE_3_2),
    BK_OLYMPIC("BK Olympic", League.SE_3_2),

    FUZINAR("NK Fuzinar", League.SI_1),

    NOVI_PAZAR("FK Novi Pazar", League.RS_1),
    VOZDOVAC("FK Vozdovac", League.RS_1),
    CUKARICKI("FK Cukaricki", League.RS_1),

    MACVA("FK Macva Sabac", League.RS_2),

    ALL_BOYS("CA All Boys", League.AR_2),

    PETROLERO("Club Independiente Petrolero", League.BO_1),

    INDY_ELEVEN("Indy Eleven", League.US_2);


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
