package helper;

import enums.Club;
import enums.Country;
import enums.Position;
import player.Player;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerHelper {
    private static Player[] players = new Player[]{ //Maximum talent = 100 (10% chance to level-up after a match)
            //Bundesliga (Germany 1)
            new Player("Manuel", "Neuer", Country.DE, 88, LocalDate.of(1986, 3, 27), Position.GK, Club.BAYERN, new Club[]{Club.BAYERN, Club.SCHALKE}, 35, 35, 88, 5),

            //-------------------------------------------------------
            //----------  Betri-deildin (Faroe Islands 1)  ----------
            //-------------------------------------------------------
            new Player("Teitur", "Gestsson", Country.FO, 60, LocalDate.of(1992, 8, 19), Position.GK, Club.HB, new Club[]{Club.HB}, 20, 22, 61, 27),
            new Player("Bjarti", "Mørk", Country.FO, 56, LocalDate.of(2001, 6, 7), Position.GK, Club.HB, new Club[]{Club.HB, Club.ARGIR, Club.HB}, 18, 17, 59, 78),
            new Player("Samuel", "Chukwudi", Country.FO, 61, LocalDate.of(2003, 6, 25), Position.CB, Club.HB, new Club[]{Club.HB}, 35, 34, 63, 92),
            new Player("Hørður", "Askham", Country.FO, 59, LocalDate.of(1994, 9, 22), Position.CB, Club.HB, new Club[]{Club.HB, Club.KLAKSVIK, Club.B36, Club.VESTUR, Club.B36}, 32, 34, 59, 46),
            new Player("Bartal", "Wardum", Country.FO, 59, LocalDate.of(1997, 5, 3), Position.CB, Club.HB, new Club[]{Club.HB}, 37, 33, 59, 47),
            new Player("Ejvind", "Mouritsen", Country.FO, 53, LocalDate.of(2004, 2, 14), Position.CB, Club.HB, new Club[]{Club.HB}, 28, 28, 54, 100),
            new Player("Viljormur", "Davidsen", Country.FO, 64, LocalDate.of(1991, 7, 19), Position.LB, Club.HB, new Club[]{Club.HB, Club.HELSINGBORG, Club.VEJLE, Club.FREDERICIA, Club.JERV, Club.ODENSE}, 62, 65, 65, 15),
            new Player("Daniel", "Johansen", Country.FO, 62, LocalDate.of(1998, 7, 9), Position.LB, Club.HB, new Club[]{Club.HB, Club.FREDERICIA, Club.HB}, 59, 60, 61, 50),
            new Player("Ári", "Jónsson", Country.FO, 61, LocalDate.of(1994, 7, 22), Position.LB, Club.HB, new Club[]{Club.HB, Club.SANDNES, Club.HB, Club.SILKEBORG}, 60, 62, 61, 45),
            new Player("Hanus", "Sørensen", Country.FO, 58, LocalDate.of(2001, 2, 19), Position.RB, Club.HB, new Club[]{Club.HB, Club.MIDDELFART, Club.HB, Club.MIDDELFART, Club.HB, Club.MIDDELFART}, 59, 58, 58, 93),
            new Player("Heri", "Mohr", Country.FO, 57, LocalDate.of(1997, 5, 13), Position.RB, Club.HB, new Club[]{Club.HB, Club.ARGIR, Club.HB, Club.TVOROYRI}, 55, 56, 58, 53),
            new Player("Heðin", "Hansen", Country.FO, 59, LocalDate.of(1993, 7, 30), Position.CDM, Club.HB, new Club[]{Club.HB, Club.VIKINGUR_GOTA, Club.HB, Club.VIKINGUR_GOTA}, 56, 55, 59, 26),
            new Player("Tróndur", "Jensen", Country.FO, 59, LocalDate.of(1993, 2, 6), Position.CDM, Club.HB, new Club[]{Club.HB, Club.ARGIR, Club.HB}, 57, 57, 58, 25),
            new Player("Emil", "Berger", Country.SE, 62, LocalDate.of(1991, 5, 23), Position.CM, Club.HB, new Club[]{Club.HB, Club.LEIKNIR, Club.DALKURD, Club.KONGSVINGER, Club.OREBRO, Club.FYLKIR, Club.OREBRO, Club.DEGERFORS, Club.AIK, Club.ESKILSTUNA, Club.AIK, Club.DEGERFORS}, 60, 63, 61, 11),
            new Player("Matthias", "Præst", Country.DK, 61, LocalDate.of(2000, 6, 21), Position.CM, Club.HB, new Club[]{Club.HB, Club.ARGIR, Club.MIDDELFART, Club.HORSENS}, 60, 61, 60, 85),
            new Player("Dánjal", "Reginsson", Country.FO, 54, LocalDate.of(2001, 12, 17), Position.RM, Club.HB, new Club[]{Club.HB, Club.ARGIR}, 54, 54, 26, 90),
            new Player("Dan", "í Soylu", Country.FO, 59, LocalDate.of(1996, 7, 9), Position.CAM, Club.HB, new Club[]{Club.HB, Club.STREYMUR, Club.ARGIR}, 60, 61, 30, 50),
            new Player("Áki", "Samuelsen", Country.FO, 59, LocalDate.of(2004, 4, 17), Position.LW, Club.HB, new Club[]{Club.HB}, 59, 59, 24, 100),
            new Player("Leivur", "Guttesen", Country.FO, 56, LocalDate.of(2002, 1, 17), Position.RW, Club.HB, new Club[]{Club.HB, Club.ARGIR}, 57, 56, 23, 96),
            new Player("Adrian", "Justinussen", Country.FO, 62, LocalDate.of(1998, 7, 21), Position.ST, Club.HB, new Club[]{Club.HB}, 63, 60, 32, 53),
            new Player("Mads", "Borchers", Country.DK, 62, LocalDate.of(2002, 6, 18), Position.ST, Club.HB, new Club[]{Club.HB, Club.ESBJERG, Club.VESTUR, Club.ESBJERG}, 64, 58, 35, 95),
            new Player("Mikkel", "Dahl", Country.DK, 60, LocalDate.of(1993, 6, 22), Position.ST, Club.HB, new Club[]{Club.HB, Club.LEIKNIR, Club.HB, Club.NYKOBING, Club.HVIDOVRE}, 60, 56, 38, 17),
            new Player("Jákup", "Thomsen", Country.FO, 57, LocalDate.of(1997, 11, 23), Position.ST, Club.HB, new Club[]{Club.HB, Club.MIDTJYLLAND, Club.HAFNARFJORDUR, Club.MIDTJYLLAND, Club.HAFNARFJORDUR, Club.MIDTJYLLAND, Club.THISTED, Club.MIDTJYLLAND, Club.SKIVE}, 57, 55, 35, 47),
            new Player("Rani", "Sørensen", Country.FO, 56, LocalDate.of(2004, 4, 22), Position.ST, Club.HB, new Club[]{Club.HB}, 58, 49, 31, 100),

            new Player("Rói", "Zachariasen", Country.FO, 55, LocalDate.of(1998, 10, 12), Position.GK, Club.ARGIR, new Club[]{Club.ARGIR, Club.STREYMUR}, 20, 20, 55, 47),
            new Player("Antonío", "Borelli", Country.US, 55, LocalDate.of(1998, 11, 23), Position.GK, Club.ARGIR, new Club[]{Club.ARGIR}, 21, 22, 56, 53),
            new Player("Ramzi", "Idrissou", Country.TG, 57, LocalDate.of(1996, 7, 31), Position.CB, Club.ARGIR, new Club[]{Club.ARGIR, Club.FUZINAR, Club.HODD, Club.LEVANGER, Club.HODD}, 38, 38, 58, 41),
            new Player("Tróndur", "á Høvdanum", Country.FO, 54, LocalDate.of(1995, 8, 19), Position.CB, Club.ARGIR, new Club[]{Club.ARGIR}, 33, 34, 54, 34),
            new Player("Dánjal", "Danielsen", Country.FO, 54, LocalDate.of(2004, 7, 5), Position.CB, Club.ARGIR, new Club[]{Club.ARGIR}, 35, 33, 55, 100),
            new Player("Sam", "Pollard", Country.ENG, 54, LocalDate.of(1999, 2, 21), Position.LB, Club.ARGIR, new Club[]{Club.ARGIR}, 51, 55, 52, 54),
            new Player("Rógvi", "Skala", Country.FO, 55, LocalDate.of(2000, 9, 5), Position.LB, Club.ARGIR, new Club[]{Club.ARGIR}, 52, 54, 54, 87),
            new Player("Gunnar", "Reynslág", Country.FO, 54, LocalDate.of(2004, 11, 10), Position.LB, Club.ARGIR, new Club[]{Club.ARGIR}, 50, 51, 54, 100),
            new Player("Beinir", "Ellefsen", Country.FO, 52, LocalDate.of(1993, 4, 7), Position.LB, Club.ARGIR, new Club[]{Club.ARGIR}, 51, 51, 51, 31),
            new Player("Jákup", "Breckmann", Country.FO, 56, LocalDate.of(1998, 4, 16), Position.RB, Club.ARGIR, new Club[]{Club.ARGIR, Club.TVOROYRI}, 52, 54, 56, 54),
            new Player("Bjarni", "Skála", Country.FO, 58, LocalDate.of(1997, 11, 14), Position.CDM, Club.ARGIR, new Club[]{Club.ARGIR}, 48, 51, 57, 56),
            new Player("Santiago", "Lebus", Country.AR, 57, LocalDate.of(1996, 7, 18), Position.CM, Club.ARGIR, new Club[]{Club.ARGIR, Club.FUGLAFJORDUR, Club.ARGIR, Club.PETROLERO, Club.ALL_BOYS}, 56, 57, 45, 48),
            new Player("Ragnar", "Skála", Country.FO, 57, LocalDate.of(2000, 9, 5), Position.CM, Club.ARGIR, new Club[]{Club.ARGIR}, 54, 57, 57, 87),
            new Player("Bartal", "Petersen", Country.FO, 56, LocalDate.of(2000, 11, 22), Position.CM, Club.ARGIR, new Club[]{Club.ARGIR}, 50, 57, 51, 86),
            new Player("Viktor", "Benediktsson", Country.IS, 55, LocalDate.of(1998, 9, 15), Position.CM, Club.ARGIR, new Club[]{Club.ARGIR, Club.AKRANES, Club.HAFNARFJORDUR, Club.KOPAVOGUR, Club.HAFNARFJORDUR}, 54, 55, 45, 60),
            new Player("Marius", "Lindh", Country.DK, 55, LocalDate.of(1999, 6, 22), Position.RM, Club.ARGIR, new Club[]{Club.ARGIR}, 55, 53, 30, 75),
            new Player("Jakob", "Gottberg", Country.FI, 55, LocalDate.of(2002, 7, 20), Position.LW, Club.ARGIR, new Club[]{Club.ARGIR, Club.EKENAS}, 55, 54, 26, 95),
            new Player("Teitur", "Olsen", Country.FO, 56, LocalDate.of(1998, 1, 27), Position.RW, Club.ARGIR, new Club[]{Club.ARGIR, Club.STREYMUR}, 56, 55, 29, 62),
            new Player("Tóki", "á Lofti", Country.FO, 53, LocalDate.of(1993, 12, 6), Position.RW, Club.ARGIR, new Club[]{Club.ARGIR, Club.STREYMUR, Club.VESTUR, Club.ARGIR}, 53, 50, 25, 21),
            new Player("Brian", "Jakobsen", Country.FO, 57, LocalDate.of(1991, 11, 4), Position.ST, Club.ARGIR, new Club[]{Club.ARGIR, Club.B36}, 58, 50, 30, 13),
            new Player("Rói", "Nielsen", Country.FO, 52, LocalDate.of(2005, 6, 10), Position.ST, Club.ARGIR, new Club[]{Club.ARGIR}, 53, 48, 27, 100),

            new Player("Markus", "Pettersen", Country.NO, 59, LocalDate.of(1999, 2, 12), Position.GK, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK, Club.BRANN}, 23, 22, 60, 46),
            new Player("Rói", "Hentze", Country.FO, 59, LocalDate.of(1999, 9, 22), Position.GK, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK, Club.TOFTIR, Club.B36, Club.HB, Club.B36}, 22, 23, 61, 50),

            new Player("Jóannes", "Davidsen", Country.FO, 52, LocalDate.of(2002, 9, 19), Position.GK, Club.STREYMUR, new Club[]{Club.STREYMUR}, 15, 15, 53, 86),
            new Player("Fayo", "Kruse", Country.FO, 51, LocalDate.of(2004, 4, 16), Position.GK, Club.STREYMUR, new Club[]{Club.STREYMUR}, 14, 14, 52, 100),

            new Player("Benjamin", "Schubert", Country.DK, 54, LocalDate.of(1996, 9, 22), Position.GK, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.SONDERJYSKE, Club.KOLDING}, 21, 20, 54, 28),
            new Player("Tórdur", "Thomsen", Country.FO, 54, LocalDate.of(1986, 6, 11), Position.GK, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.B36, Club.FUGLAFJORDUR, Club.TOFTIR, Club.HB, Club.ARGIR, Club.TOFTIR, Club.FUGLAFJORDUR}, 19, 19, 55, 6),
            new Player("Aleksandur", "Jensen", Country.FO, 62, LocalDate.of(2001, 5, 7), Position.CB, Club.TOFTIR, new Club[]{Club.TOFTIR}, 37, 37, 63, 81),
            new Player("Aidan", "Liu", Country.US, 61, LocalDate.of(2000, 7, 1), Position.CB, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.VEJLE, Club.TOFTIR, Club.VEJLE, Club.INDY_ELEVEN, Club.VEJLE}, 40, 42, 60, 78),
            new Player("Aron", "Hansen", Country.FO, 51, LocalDate.of(2004, 10, 4), Position.CB, Club.TOFTIR, new Club[]{Club.TOFTIR}, 33, 33, 51, 100),
            new Player("Hjalti", "Strømsten", Country.FO, 53, LocalDate.of(1997, 1, 21), Position.LB, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.VIKINGUR_GOTA}, 49, 46, 52, 34)
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
}
