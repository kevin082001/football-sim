package helper;

import enums.Club;
import enums.Country;
import enums.Position;
import player.Player;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class PlayerHelper {
    private static Player[] players = new Player[]{ //Maximum talent = 30 (30% chance to level-up after a match)
            //Bundesliga (Germany 1)
            new Player("Manuel", "Neuer", Country.DE, 88, LocalDate.of(1986, 3, 27), Position.GK, Club.BAYERN, new Club[]{Club.BAYERN, Club.SCHALKE}, 35, 35, 88, 0, 0, 3),

            //Betri-deildin (Faroe Islands 1)
            new Player("Teitur", "Gestsson", Country.FO, 60, LocalDate.of(1992, 8, 19), Position.GK, Club.HB, new Club[]{Club.HB}, 20, 22, 61, 0, 0, 8),
            new Player("Bjarti", "Mørk", Country.FO, 56, LocalDate.of(2001, 6, 7), Position.GK, Club.HB, new Club[]{Club.HB, Club.ARGIR, Club.HB}, 18, 17, 59, 0, 0, 22),

            new Player("Rói", "Zachariasen", Country.FO, 55, LocalDate.of(1998, 10, 12), Position.GK, Club.ARGIR, new Club[]{Club.ARGIR, Club.STREYMUR}, 17, 17, 55, 0, 0, 14),
            new Player("Antonío", "Borelli", Country.US, 55, LocalDate.of(1998, 11, 23), Position.GK, Club.ARGIR, new Club[]{Club.ARGIR}, 18, 18, 56, 0, 0, 17),

            new Player("Markus", "Pettersen", Country.NO, 59, LocalDate.of(1999, 2, 12), Position.GK, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK, Club.BRANN}, 23, 22, 60, 0, 0, 14),
            new Player("Rói", "Hentze", Country.FO, 59, LocalDate.of(1999, 9, 22), Position.GK, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK, Club.TOFTIR, Club.B36, Club.HB, Club.B36}, 22, 23, 61, 0, 0, 15),

            new Player("Jóannes", "Davidsen", Country.FO, 52, LocalDate.of(2002, 9, 19), Position.GK, Club.STREYMUR, new Club[]{Club.STREYMUR}, 15, 15, 53, 0, 0, 25),
            new Player("Fayo", "Kruse", Country.FO, 51, LocalDate.of(2004, 4, 16), Position.GK, Club.STREYMUR, new Club[]{Club.STREYMUR}, 14, 14, 52, 0, 0, 30),

            new Player("Benjamin", "Schubert", Country.DK, 54, LocalDate.of(1996, 9, 22), Position.GK, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.SONDERJYSKE, Club.KOLDING}, 21, 20, 54, 0, 0, 9),
            new Player("Tórdur", "Thomsen", Country.FO, 54, LocalDate.of(1986, 6, 11), Position.GK, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.B36, Club.FUGLAFJORDUR, Club.TOFTIR, Club.HB, Club.ARGIR, Club.TOFTIR, Club.FUGLAFJORDUR}, 19, 19, 55, 0, 0, 2),
            new Player("Aleksandur", "Jensen", Country.FO, 62, LocalDate.of(2001, 5, 7), Position.CB, Club.TOFTIR, new Club[]{Club.TOFTIR}, 37, 37, 63, 0, 0, 25),
            new Player("Aidan", "Liu", Country.US, 61, LocalDate.of(2000, 7, 1), Position.CB, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.VEJLE, Club.TOFTIR, Club.VEJLE, Club.INDY_ELEVEN, Club.VEJLE}, 40, 42, 60, 0, 0, 24),
            new Player("Aron", "Hansen", Country.FO, 51, LocalDate.of(2004, 10, 4), Position.CB, Club.TOFTIR, new Club[]{Club.TOFTIR}, 33, 33, 51, 0, 0, 30),
            new Player("Hjalti", "Strømsten", Country.FO, 53, LocalDate.of(1997, 1, 21), Position.LB, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.VIKINGUR_GOTA}, 49, 46, 52, 0, 0, 11)
    };

    public static List<Player> getAllPlayers() {
        return Arrays.asList(players);
    }
}
