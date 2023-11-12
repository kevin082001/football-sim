package helper;

import GameObjects.Player;
import GameObjects.StaticPlayerData;
import enums.Club;
import enums.Country;
import enums.Position;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerHelper {
    private static Player[] players = new Player[]{ //Maximum talent = 100 (10% chance to level-up after a match)
            //------------------------------------------------------
            //----------      Bundesliga (Germany 1)      ----------
            //------------------------------------------------------
            new Player(1, "Manuel", "Neuer", Country.DE, 88, LocalDate.of(1986, 3, 27), Position.GK, Club.BAYERN, new Club[]{Club.BAYERN, Club.SCHALKE}, 35, 35, 88, 5),

            //-------------------------------------------------------
            //----------  Betri-deildin (Faroe Islands 1)  ----------
            //-------------------------------------------------------
            new Player(2, "Teitur", "Gestsson", Country.FO, 60, LocalDate.of(1992, 8, 19), Position.GK, Club.HB, new Club[]{Club.HB}, 20, 22, 61, 27),
            new Player(3, "Bjarti", "Mørk", Country.FO, 56, LocalDate.of(2001, 6, 7), Position.GK, Club.HB, new Club[]{Club.HB, Club.ARGIR, Club.HB}, 18, 17, 59, 78),
            new Player(4, "Samuel", "Chukwudi", Country.FO, 61, LocalDate.of(2003, 6, 25), Position.CB, Club.HB, new Club[]{Club.HB}, 35, 34, 63, 92),
            new Player(5, "Bartal", "Wardum", Country.FO, 59, LocalDate.of(1997, 5, 3), Position.CB, Club.HB, new Club[]{Club.HB}, 37, 33, 59, 47),
            new Player(6, "Ejvind", "Mouritsen", Country.FO, 53, LocalDate.of(2004, 2, 14), Position.CB, Club.HB, new Club[]{Club.HB}, 28, 28, 54, 100),
            new Player(7, "Viljormur", "Davidsen", Country.FO, 64, LocalDate.of(1991, 7, 19), Position.LB, Club.HB, new Club[]{Club.HB, Club.HELSINGBORG, Club.VEJLE, Club.FREDERICIA, Club.JERV, Club.ODENSE}, 62, 65, 65, 15),
            new Player(8, "Ári", "Jónsson", Country.FO, 61, LocalDate.of(1994, 7, 22), Position.LB, Club.HB, new Club[]{Club.HB, Club.SANDNES, Club.HB, Club.SILKEBORG}, 60, 62, 61, 45),
            new Player(9, "Hanus", "Sørensen", Country.FO, 58, LocalDate.of(2001, 2, 19), Position.RB, Club.HB, new Club[]{Club.HB, Club.MIDDELFART, Club.HB, Club.MIDDELFART, Club.HB, Club.MIDDELFART}, 59, 58, 58, 93),
            new Player(10, "Heri", "Mohr", Country.FO, 57, LocalDate.of(1997, 5, 13), Position.RB, Club.HB, new Club[]{Club.HB, Club.ARGIR, Club.HB, Club.TVOROYRI}, 55, 56, 58, 53),
            new Player(11, "Heðin", "Hansen", Country.FO, 59, LocalDate.of(1993, 7, 30), Position.CDM, Club.HB, new Club[]{Club.HB, Club.VIKINGUR_GOTA, Club.HB, Club.VIKINGUR_GOTA}, 56, 55, 59, 26),
            new Player(12, "Tróndur", "Jensen", Country.FO, 59, LocalDate.of(1993, 2, 6), Position.CDM, Club.HB, new Club[]{Club.HB, Club.ARGIR, Club.HB}, 57, 57, 58, 25),
            new Player(13, "Djóni", "Samuelsen", Country.FO, 52, LocalDate.of(2006, 11, 28), Position.CM, Club.HB, new Club[]{Club.HB}, 50, 53, 50, 100),
            new Player(14, "Emil", "Berger", Country.SE, 62, LocalDate.of(1991, 5, 23), Position.CM, Club.HB, new Club[]{Club.HB, Club.LEIKNIR, Club.DALKURD, Club.KONGSVINGER, Club.OREBRO, Club.FYLKIR, Club.OREBRO, Club.DEGERFORS, Club.AIK, Club.ESKILSTUNA, Club.AIK, Club.DEGERFORS}, 60, 63, 61, 11),
            new Player(15, "Matthias", "Præst", Country.DK, 61, LocalDate.of(2000, 6, 21), Position.CM, Club.HB, new Club[]{Club.HB, Club.ARGIR, Club.MIDDELFART, Club.HORSENS}, 60, 61, 60, 85),
            new Player(16, "Dánjal", "Reginsson", Country.FO, 54, LocalDate.of(2001, 12, 17), Position.RM, Club.HB, new Club[]{Club.HB, Club.ARGIR}, 54, 54, 26, 90),
            new Player(17, "Ási", "Dam", Country.FO, 52, LocalDate.of(2002, 12, 18), Position.LM, Club.HB, new Club[]{Club.HB, Club.VESTUR, Club.HB}, 51, 50, 33, 90),
            new Player(18, "Dan", "í Soylu", Country.FO, 59, LocalDate.of(1996, 7, 9), Position.CAM, Club.HB, new Club[]{Club.HB, Club.STREYMUR, Club.ARGIR}, 60, 61, 30, 50),
            new Player(19, "Áki", "Samuelsen", Country.FO, 59, LocalDate.of(2004, 4, 17), Position.LW, Club.HB, new Club[]{Club.HB}, 59, 59, 24, 100),
            new Player(20, "Leivur", "Guttesen", Country.FO, 56, LocalDate.of(2002, 1, 17), Position.RW, Club.HB, new Club[]{Club.HB, Club.ARGIR}, 57, 56, 23, 96),
            new Player(21, "Adrian", "Justinussen", Country.FO, 62, LocalDate.of(1998, 7, 21), Position.ST, Club.HB, new Club[]{Club.HB}, 63, 60, 32, 53),
            new Player(22, "Mikkel", "Dahl", Country.DK, 60, LocalDate.of(1993, 6, 22), Position.ST, Club.HB, new Club[]{Club.HB, Club.LEIKNIR, Club.HB, Club.NYKOBING, Club.HVIDOVRE}, 60, 56, 38, 17),
            new Player(23, "Jákup", "Thomsen", Country.FO, 57, LocalDate.of(1997, 11, 23), Position.ST, Club.HB, new Club[]{Club.HB, Club.MIDTJYLLAND, Club.HAFNARFJORDUR, Club.MIDTJYLLAND, Club.HAFNARFJORDUR, Club.MIDTJYLLAND, Club.THISTED, Club.MIDTJYLLAND, Club.SKIVE}, 57, 55, 35, 47),
            new Player(24, "Rani", "Sørensen", Country.FO, 56, LocalDate.of(2004, 4, 22), Position.ST, Club.HB, new Club[]{Club.HB}, 58, 49, 31, 100),

            new Player(25, "Rói", "Zachariasen", Country.FO, 55, LocalDate.of(1998, 10, 12), Position.GK, Club.ARGIR, new Club[]{Club.ARGIR, Club.STREYMUR}, 20, 20, 55, 47),
            new Player(26, "Antonío", "Borelli", Country.US, 55, LocalDate.of(1998, 11, 23), Position.GK, Club.ARGIR, new Club[]{Club.ARGIR}, 21, 22, 56, 53),
            new Player(27, "Ramzi", "Idrissou", Country.TG, 57, LocalDate.of(1996, 7, 31), Position.CB, Club.ARGIR, new Club[]{Club.ARGIR, Club.FUZINAR, Club.HODD, Club.LEVANGER, Club.HODD}, 38, 38, 58, 41),
            new Player(28, "Tróndur", "á Høvdanum", Country.FO, 54, LocalDate.of(1995, 8, 19), Position.CB, Club.ARGIR, new Club[]{Club.ARGIR}, 33, 34, 54, 34),
            new Player(29, "Dánjal", "Danielsen", Country.FO, 54, LocalDate.of(2004, 7, 5), Position.CB, Club.ARGIR, new Club[]{Club.ARGIR}, 35, 33, 55, 100),
            new Player(30, "Sam", "Pollard", Country.ENG, 54, LocalDate.of(1999, 2, 21), Position.LB, Club.ARGIR, new Club[]{Club.ARGIR}, 51, 55, 52, 54),
            new Player(31, "Rógvi", "Skala", Country.FO, 55, LocalDate.of(2000, 9, 5), Position.LB, Club.ARGIR, new Club[]{Club.ARGIR}, 52, 54, 54, 87),
            new Player(32, "Gunnar", "Reynslág", Country.FO, 54, LocalDate.of(2004, 11, 10), Position.LB, Club.ARGIR, new Club[]{Club.ARGIR}, 50, 51, 54, 100),
            new Player(33, "Beinir", "Ellefsen", Country.FO, 52, LocalDate.of(1993, 4, 7), Position.LB, Club.ARGIR, new Club[]{Club.ARGIR}, 51, 51, 51, 31),
            new Player(34, "Jákup", "Breckmann", Country.FO, 56, LocalDate.of(1998, 4, 16), Position.RB, Club.ARGIR, new Club[]{Club.ARGIR, Club.TVOROYRI}, 52, 54, 56, 54),
            new Player(35, "Bjarni", "Skála", Country.FO, 58, LocalDate.of(1997, 11, 14), Position.CDM, Club.ARGIR, new Club[]{Club.ARGIR}, 48, 51, 57, 56),
            new Player(36, "Santiago", "Lebus", Country.AR, 57, LocalDate.of(1996, 7, 18), Position.CM, Club.ARGIR, new Club[]{Club.ARGIR, Club.FUGLAFJORDUR, Club.ARGIR, Club.PETROLERO, Club.ALL_BOYS}, 56, 57, 45, 48),
            new Player(37, "Ragnar", "Skála", Country.FO, 57, LocalDate.of(2000, 9, 5), Position.CM, Club.ARGIR, new Club[]{Club.ARGIR}, 54, 57, 57, 87),
            new Player(38, "Bartal", "Petersen", Country.FO, 56, LocalDate.of(2000, 11, 22), Position.CM, Club.ARGIR, new Club[]{Club.ARGIR}, 50, 57, 51, 86),
            new Player(39, "Viktor", "Benediktsson", Country.IS, 55, LocalDate.of(1998, 9, 15), Position.CM, Club.ARGIR, new Club[]{Club.ARGIR, Club.AKRANES, Club.HAFNARFJORDUR, Club.KOPAVOGUR, Club.HAFNARFJORDUR}, 54, 55, 45, 60),
            new Player(40, "Marius", "Lindh", Country.DK, 55, LocalDate.of(1999, 6, 22), Position.RM, Club.ARGIR, new Club[]{Club.ARGIR}, 55, 53, 30, 75),
            new Player(41, "Filip", "í Lida", Country.FO, 52, LocalDate.of(2000, 11, 6), Position.RM, Club.ARGIR, new Club[]{Club.ARGIR}, 53, 51, 33, 85),
            new Player(42, "Teitur", "Olsen", Country.FO, 56, LocalDate.of(1998, 1, 27), Position.RW, Club.ARGIR, new Club[]{Club.ARGIR, Club.STREYMUR}, 56, 55, 29, 62),
            new Player(43, "Tóki", "á Lofti", Country.FO, 53, LocalDate.of(1993, 12, 6), Position.RW, Club.ARGIR, new Club[]{Club.ARGIR, Club.STREYMUR, Club.VESTUR, Club.ARGIR}, 53, 50, 25, 21),
            new Player(44, "Brian", "Jakobsen", Country.FO, 57, LocalDate.of(1991, 11, 4), Position.ST, Club.ARGIR, new Club[]{Club.ARGIR, Club.B36}, 58, 50, 30, 13),
            new Player(45, "Rói", "Nielsen", Country.FO, 52, LocalDate.of(2005, 6, 10), Position.ST, Club.ARGIR, new Club[]{Club.ARGIR}, 53, 48, 27, 100),

            new Player(46, "Markus", "Pettersen", Country.NO, 59, LocalDate.of(1999, 2, 12), Position.GK, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK, Club.BRANN}, 23, 22, 60, 46),
            new Player(47, "Rói", "Hentze", Country.FO, 59, LocalDate.of(1999, 9, 22), Position.GK, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK, Club.TOFTIR, Club.B36, Club.HB, Club.B36}, 22, 23, 61, 50),

            new Player(48, "Jóannes", "Davidsen", Country.FO, 52, LocalDate.of(2002, 9, 19), Position.GK, Club.STREYMUR, new Club[]{Club.STREYMUR}, 15, 15, 53, 86),
            new Player(49, "Fayo", "Kruse", Country.FO, 51, LocalDate.of(2004, 4, 16), Position.GK, Club.STREYMUR, new Club[]{Club.STREYMUR}, 14, 14, 52, 100),

            new Player(50, "Benjamin", "Schubert", Country.DK, 54, LocalDate.of(1996, 9, 22), Position.GK, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.SONDERJYSKE, Club.KOLDING}, 21, 20, 54, 28),
            new Player(51, "Tórdur", "Thomsen", Country.FO, 54, LocalDate.of(1986, 6, 11), Position.GK, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.B36, Club.FUGLAFJORDUR, Club.TOFTIR, Club.HB, Club.ARGIR, Club.TOFTIR, Club.FUGLAFJORDUR}, 19, 19, 55, 6),
            new Player(52, "Svend", "Danielsen", Country.FO, 49, LocalDate.of(2005, 10, 24), Position.GK, Club.TOFTIR, new Club[]{Club.TOFTIR}, 20, 20, 50, 100),
            new Player(53, "Aleksandur", "Jensen", Country.FO, 62, LocalDate.of(2001, 5, 7), Position.CB, Club.TOFTIR, new Club[]{Club.TOFTIR}, 37, 37, 63, 81),
            new Player(54, "Aron", "Hansen", Country.FO, 51, LocalDate.of(2004, 10, 4), Position.CB, Club.TOFTIR, new Club[]{Club.TOFTIR}, 33, 33, 51, 100),
            new Player(55, "Ari", "Johannesen", Country.FO, 52, LocalDate.of(1996, 6, 7), Position.LB, Club.TOFTIR, new Club[]{Club.TOFTIR}, 47, 47, 52, 35),
            new Player(56, "Hjalti", "Strømsten", Country.FO, 53, LocalDate.of(1997, 1, 21), Position.LB, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.VIKINGUR_GOTA}, 49, 46, 52, 34),
            new Player(57, "Alex", "Mellemgaard", Country.FO, 51, LocalDate.of(1991, 11, 27), Position.LB, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.B36, Club.ARGIR}, 45, 45, 51, 12),
            new Player(58, "Ragnar", "Samuelsen", Country.FO, 54, LocalDate.of(1999, 8, 23), Position.CDM, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.B36, Club.STREYMUR, Club.B36}, 42, 46, 53, 73),
            new Player(59, "Bárdur", "Jensen", Country.FO, 54, LocalDate.of(2001, 5, 7), Position.CM, Club.TOFTIR, new Club[]{Club.TOFTIR}, 48, 55, 48, 88),
            new Player(60, "Áki", "Johannesen", Country.FO, 53, LocalDate.of(2002, 11, 11), Position.CM, Club.TOFTIR, new Club[]{Club.TOFTIR}, 53, 53, 39, 91),
            new Player(61, "Karstin", "Clementsen", Country.FO, 49, LocalDate.of(2001, 9, 12), Position.RM, Club.TOFTIR, new Club[]{Club.TOFTIR}, 49, 50, 26, 90),
            new Player(62, "Esmar", "Clementsen", Country.FO, 50, LocalDate.of(1996, 9, 29), Position.RM, Club.TOFTIR, new Club[]{Club.TOFTIR}, 50, 50, 32, 30),
            new Player(63, "Hilmar", "Højgaard", Country.FO, 48, LocalDate.of(2003, 8, 22), Position.RM, Club.TOFTIR, new Club[]{Club.TOFTIR}, 49, 49, 25, 100),
            new Player(64, "Eli", "Hansen", Country.FO, 48, LocalDate.of(2005, 10, 17), Position.LM, Club.TOFTIR, new Club[]{Club.TOFTIR}, 48, 50, 33, 100),
            new Player(65, "Boubacar Sidik", "Dabo", Country.SEN, 55, LocalDate.of(1997, 10, 10), Position.LW, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.ANTONIANO}, 55, 50, 26, 36),
            new Player(66, "Hanus", "Höjgaard", Country.FO, 55, LocalDate.of(2005, 12, 3), Position.LW, Club.TOFTIR, new Club[]{Club.TOFTIR}, 55, 53, 30, 100),
            new Player(67, "Maha", "Samba", Country.GMB, 56, LocalDate.of(1998, 11, 9), Position.RW, Club.TOFTIR, new Club[]{Club.TOFTIR}, 55, 55, 36, 66),
            new Player(68, "Gilli", "Samuelsen", Country.FO, 52, LocalDate.of(1999, 2, 12), Position.RW, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.VESTUR, Club.B36, Club.VESTUR, Club.B36}, 53, 51, 24, 82),
            new Player(69, "Sebastian", "Lau", Country.DK, 52, LocalDate.of(1996, 7, 2), Position.ST, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.HELLERUP}, 54, 46, 27, 35),
            new Player(70, "Jörgen", "Nielsen", Country.FO, 51, LocalDate.of(2003, 11, 30), Position.ST, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.NSI, Club.OSTERS}, 52, 50, 35, 95),
            new Player(71, "Frídi", "Petersen", Country.FO, 51, LocalDate.of(2003, 10, 18), Position.ST, Club.TOFTIR, new Club[]{Club.TOFTIR}, 52, 51, 32, 95),
            new Player(72, "Hjarnar", "Johansen", Country.FO, 49, LocalDate.of(2004, 4, 13), Position.ST, Club.TOFTIR, new Club[]{Club.TOFTIR}, 52, 40, 22, 100),
            new Player(73, "Bartal Páll", "Klein", Country.FO, 47, LocalDate.of(2006, 12, 15), Position.ST, Club.TOFTIR, new Club[]{Club.TOFTIR}, 49, 49, 30, 100),
            new Player(74, "Villiam Emil", "Klein", Country.FO, 48, LocalDate.of(2000, 11, 21), Position.ST, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.HOYVIK, Club.HB}, 49, 49, 34, 93),

            //-------------------------------------------------------
            //----------      2. Division (Denmark 3)      ----------
            //-------------------------------------------------------
            new Player(75, "Hørður", "Askham", Country.FO, 59, LocalDate.of(1994, 9, 22), Position.CB, Club.AKADEMISK, new Club[]{Club.AKADEMISK, Club.HB, Club.KLAKSVIK, Club.B36, Club.VESTUR, Club.B36}, 32, 34, 59, 36),

            new Player(76, "Daniel", "Johansen", Country.FO, 62, LocalDate.of(1998, 7, 9), Position.LB, Club.THISTED, new Club[]{Club.THISTED, Club.HB, Club.FREDERICIA, Club.HB}, 59, 60, 61, 50),

            //-------------------------------------------------------
            //----------      Allsvenskan (Sweden 1)       ----------
            //-------------------------------------------------------
            new Player(77, "Mads", "Borchers", Country.DK, 62, LocalDate.of(2002, 6, 18), Position.ST, Club.VARBERGS, new Club[]{Club.VARBERGS, Club.HB, Club.ESBJERG, Club.VESTUR, Club.ESBJERG}, 64, 58, 35, 95),

            //-------------------------------------------------------
            //----------       Ykkönen (Finland 2)         ----------
            //-------------------------------------------------------
            new Player(78, "Jakob", "Gottberg", Country.FI, 53, LocalDate.of(2002, 7, 20), Position.LW, Club.EKENAS, new Club[]{Club.EKENAS, Club.ARGIR, Club.EKENAS}, 54, 53, 26, 93),

            //-------------------------------------------------------
            //----------     Regionalliga (Germany 4)      ----------
            //-------------------------------------------------------
            new Player(79, "Aidan", "Liu", Country.US, 61, LocalDate.of(2000, 7, 1), Position.CB, Club.VIKTORIA_BERLIN, new Club[]{Club.VIKTORIA_BERLIN, Club.TOFTIR, Club.VEJLE, Club.TOFTIR, Club.VEJLE, Club.INDY_ELEVEN, Club.VEJLE}, 40, 42, 60, 78),
    };

    public static List<Player> getAllPlayers() {
        return Arrays.asList(players);
    }

    public static List<Player> getPlayersForClub(Club club) {
        List<Player> result = new ArrayList<>();
        for (Player p : players) {
            if (p.getClub().equals(club)) {
                result.add(p);
            }
        }
        return result;
    }

    public static StaticPlayerData getStaticPlayerData(int id) {
        if (id < 0) {
            return null;
        }

        for (Player p : players) {
            if (p.getId() == id) {
                return new StaticPlayerData(p.getFirstName(), p.getLastName(), p.getBirthDate());
            }
        }
        return null;
    }
}
