package helper;

import GameObjects.Club;
import GameObjects.Player;
import GameObjects.StaticPlayerData;
import enums.ClubEnum;
import enums.Country;
import enums.Position;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Last updated on: Jan 14, 2024
 */
public class PlayerHelper {
    private static Player[] players = new Player[]{ //Maximum talent = 100 (10% chance to level-up after a match)
            //------------------------------------------------------
            //----------      Bundesliga (Germany 1)      ----------
            //------------------------------------------------------
            new Player("Manuel", "Neuer", Country.DE, 88, LocalDate.of(1986, 3, 27), Position.GK, 5_000_000, ClubEnum.BAYERN, new ClubEnum[]{ClubEnum.BAYERN, ClubEnum.SCHALKE}, 35, 35, 88, 5),

            //-------------------------------------------------------
            //----------  Betri-deildin (Faroe Islands 1)  ----------
            //-------------------------------------------------------
            new Player("Teitur", "Gestsson", Country.FO, 60, LocalDate.of(1992, 8, 19), Position.GK, 100_000, ClubEnum.HB, new ClubEnum[]{ClubEnum.HB}, 20, 22, 61, 27),
            new Player("Bjarti", "Mørk", Country.FO, 56, LocalDate.of(2001, 6, 7), Position.GK, 50_000, ClubEnum.HB, new ClubEnum[]{ClubEnum.HB, ClubEnum.ARGIR, ClubEnum.HB}, 18, 17, 59, 78),
            new Player("Samuel", "Chukwudi", Country.FO, 61, LocalDate.of(2003, 6, 25), Position.CB, 125_000, ClubEnum.HB, new ClubEnum[]{ClubEnum.HB}, 35, 34, 63, 92),
            new Player("Bartal", "Wardum", Country.FO, 59, LocalDate.of(1997, 5, 3), Position.CB, 75_000, ClubEnum.HB, new ClubEnum[]{ClubEnum.HB}, 37, 33, 59, 47),
            new Player("Ejvind", "Mouritsen", Country.FO, 53, LocalDate.of(2004, 2, 14), Position.CB, 25_000, ClubEnum.HB, new ClubEnum[]{ClubEnum.HB}, 28, 28, 54, 100),
            new Player("Viljormur", "Davidsen", Country.FO, 64, LocalDate.of(1991, 7, 19), Position.LB, 250_000, ClubEnum.HB, new ClubEnum[]{ClubEnum.HB, ClubEnum.HELSINGBORG, ClubEnum.VEJLE, ClubEnum.FREDERICIA, ClubEnum.JERV, ClubEnum.ODENSE}, 62, 65, 65, 15),
            new Player("Ári", "Jónsson", Country.FO, 61, LocalDate.of(1994, 7, 22), Position.LB, 100_000, ClubEnum.HB, new ClubEnum[]{ClubEnum.HB, ClubEnum.SANDNES, ClubEnum.HB, ClubEnum.SILKEBORG}, 60, 62, 61, 45),
            new Player("Hanus", "Sørensen", Country.FO, 58, LocalDate.of(2001, 2, 19), Position.RB, 100_000, ClubEnum.HB, new ClubEnum[]{ClubEnum.HB, ClubEnum.MIDDELFART, ClubEnum.HB, ClubEnum.MIDDELFART, ClubEnum.HB, ClubEnum.MIDDELFART}, 59, 58, 58, 93),
            new Player("Heri", "Mohr", Country.FO, 57, LocalDate.of(1997, 5, 13), Position.RB, 50_000, ClubEnum.HB, new ClubEnum[]{ClubEnum.HB, ClubEnum.ARGIR, ClubEnum.HB, ClubEnum.TVOROYRI}, 55, 56, 58, 53),
            new Player("Magnus", "Jacobsen", Country.FO, 59, LocalDate.of(2000, 5, 23), Position.CDM, 75_000, ClubEnum.HB, new ClubEnum[]{ClubEnum.HB, ClubEnum.VESTUR, ClubEnum.B36}, 40, 46, 56, 80),
            new Player("Heðin", "Hansen", Country.FO, 59, LocalDate.of(1993, 7, 30), Position.CDM, 75_000, ClubEnum.HB, new ClubEnum[]{ClubEnum.HB, ClubEnum.VIKINGUR_GOTA, ClubEnum.HB, ClubEnum.VIKINGUR_GOTA}, 56, 55, 59, 26),
            new Player("Tróndur", "Jensen", Country.FO, 59, LocalDate.of(1993, 2, 6), Position.CDM, 50_000, ClubEnum.HB, new ClubEnum[]{ClubEnum.HB, ClubEnum.ARGIR, ClubEnum.HB}, 57, 57, 58, 25),
            new Player("Djóni", "Samuelsen", Country.FO, 52, LocalDate.of(2006, 11, 28), Position.CM, 25_000, ClubEnum.HB, new ClubEnum[]{ClubEnum.HB}, 50, 53, 50, 100),
            new Player("Dánjal", "Reginsson", Country.FO, 54, LocalDate.of(2001, 12, 17), Position.RM, 25_000, ClubEnum.HB, new ClubEnum[]{ClubEnum.HB, ClubEnum.ARGIR}, 54, 54, 26, 90),
            new Player("Ási", "Dam", Country.FO, 52, LocalDate.of(2002, 12, 18), Position.LM, 25_000, ClubEnum.HB, new ClubEnum[]{ClubEnum.HB, ClubEnum.VESTUR, ClubEnum.HB}, 51, 50, 33, 90),
            new Player("Dan", "í Soylu", Country.FO, 59, LocalDate.of(1996, 7, 9), Position.CAM, 75_000, ClubEnum.HB, new ClubEnum[]{ClubEnum.HB, ClubEnum.STREYMUR, ClubEnum.ARGIR}, 60, 61, 30, 50),
            new Player("Áki", "Samuelsen", Country.FO, 59, LocalDate.of(2004, 4, 17), Position.LW, 125_000, ClubEnum.HB, new ClubEnum[]{ClubEnum.HB}, 59, 59, 24, 100),
            new Player("Maha", "Samba", Country.GM, 56, LocalDate.of(1998, 11, 9), Position.RW, 50_000, ClubEnum.HB, new ClubEnum[]{ClubEnum.HB, ClubEnum.TOFTIR}, 55, 55, 36, 66),
            new Player("Leivur", "Guttesen", Country.FO, 56, LocalDate.of(2002, 1, 17), Position.RW, 25_000, ClubEnum.HB, new ClubEnum[]{ClubEnum.HB, ClubEnum.ARGIR}, 57, 56, 23, 96),
            new Player("Adrian", "Justinussen", Country.FO, 62, LocalDate.of(1998, 7, 21), Position.ST, 200_000, ClubEnum.HB, new ClubEnum[]{ClubEnum.HB}, 63, 60, 32, 53),
            new Player("Mikkel", "Dahl", Country.DK, 60, LocalDate.of(1993, 6, 22), Position.ST, 125_000, ClubEnum.HB, new ClubEnum[]{ClubEnum.HB, ClubEnum.LEIKNIR, ClubEnum.HB, ClubEnum.NYKOBING, ClubEnum.HVIDOVRE}, 60, 56, 38, 17),
            new Player("Jákup", "Thomsen", Country.FO, 57, LocalDate.of(1997, 11, 23), Position.ST, 50_000, ClubEnum.HB, new ClubEnum[]{ClubEnum.HB, ClubEnum.MIDTJYLLAND, ClubEnum.HAFNARFJORDUR, ClubEnum.MIDTJYLLAND, ClubEnum.HAFNARFJORDUR, ClubEnum.MIDTJYLLAND, ClubEnum.THISTED, ClubEnum.MIDTJYLLAND, ClubEnum.SKIVE}, 57, 55, 35, 47),
            new Player("Rani", "Sørensen", Country.FO, 56, LocalDate.of(2004, 4, 22), Position.ST, 25_000, ClubEnum.HB, new ClubEnum[]{ClubEnum.HB}, 58, 49, 31, 100),
            new Player("Markus", "Pettersen", Country.NO, 59, LocalDate.of(1999, 2, 12), Position.GK, 75_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK, ClubEnum.BRANN}, 23, 22, 60, 46),
            new Player("Jonathan", "Johansson", Country.SE, 55, LocalDate.of(1991, 8, 19), Position.GK, 50_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK, ClubEnum.RANHEIM, ClubEnum.NOTODDEN, ClubEnum.LJUNGSKILE}, 25, 25, 57, 22),
            new Player("Hannis", "Matras", Country.FO, 52, LocalDate.of(2000, 11, 21), Position.GK, 25_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK}, 19, 19, 53, 92),
            new Player("Heini", "Vatnsdal", Country.FO, 62, LocalDate.of(1991, 10, 18), Position.CB, 150_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK, ClubEnum.AMAGER, ClubEnum.HB, ClubEnum.SUDUROY}, 40, 42, 62, 26),
            new Player("Börge", "Petersen", Country.FO, 61, LocalDate.of(2002, 4, 24), Position.CB, 100_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK}, 43, 42, 62, 92),
            new Player("Odmar", "Færø", Country.FO, 58, LocalDate.of(1989, 11, 1), Position.CB, 50_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK, ClubEnum.HAMKAM, ClubEnum.B36, ClubEnum.FORFAR, ClubEnum.KEITH}, 36, 38, 58, 15),
            new Player("Símun", "Kalsø", Country.FO, 52, LocalDate.of(2003, 2, 24), Position.CB, 25_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK}, 31, 31, 51, 92),
            new Player("Jákup", "Vilhelmsen", Country.FO, 51, LocalDate.of(2004, 1, 30), Position.CB, 25_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK}, 32, 34, 51, 100),
            new Player("Patrick", "Da Silva", Country.DK, 64, LocalDate.of(1994, 10, 23), Position.LB, 275_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK, ClubEnum.LYNGBY, ClubEnum.ROSKILDE, ClubEnum.NORDSJAELLAND, ClubEnum.BRONDBY, ClubEnum.RANDERS, ClubEnum.BRONDBY}, 62, 62, 64, 32),
            new Player("Joánnes", "Danielsen", Country.FO, 63, LocalDate.of(1997, 9, 10), Position.RB, 175_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK, ClubEnum.NAESTVED}, 58, 59, 62, 40),
            new Player("Claes", "Kronberg", Country.DK, 52, LocalDate.of(1987, 4, 19), Position.RB, 25_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK, ClubEnum.SANDNES, ClubEnum.VIKING, ClubEnum.SARPSBORG, ClubEnum.NYKOBING}, 49, 47, 51, 0),
            new Player("Jákup", "Andreasen", Country.FO, 65, LocalDate.of(1998, 5, 31), Position.CDM, 350_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK}, 55, 57, 63, 45),
            new Player("Deni", "Pavlovic", Country.RS, 61, LocalDate.of(1993, 9, 1), Position.CDM, 125_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK, ClubEnum.NOVI_PAZAR, ClubEnum.MACVA, ClubEnum.VOZDOVAC, ClubEnum.CUKARICKI}, 52, 52, 60, 23),
            new Player("Luc", "Kassi", Country.NO, 63, LocalDate.of(1994, 8, 20), Position.CM, 200_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK, ClubEnum.STABAEK}, 59, 62, 57, 28),
            new Player("Hallur", "Hansson", Country.FO, 63, LocalDate.of(1992, 7, 8), Position.CM, 200_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK, ClubEnum.KR_RVK, ClubEnum.VEJLE, ClubEnum.HORSENS, ClubEnum.VENDSYSSEL, ClubEnum.VIKINGUR_GOTA, ClubEnum.AALBORG}, 63, 60, 49, 15),
            new Player("Mads", "Mikkelsen", Country.FO, 62, LocalDate.of(1999, 12, 11), Position.CM, 175_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK, ClubEnum.VENDSYSSEL}, 60, 60, 55, 55),
            new Player("René", "Joensen", Country.FO, 61, LocalDate.of(1993, 2, 8), Position.CM, 125_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK, ClubEnum.HB, ClubEnum.GRINDAVIK, ClubEnum.VENDSYSSEL, ClubEnum.HB, ClubEnum.BRONDBY, ClubEnum.HB, ClubEnum.BRONDBY}, 52, 55, 60, 18),
            new Player("Óli", "Poulsen", Country.FO, 55, LocalDate.of(2001, 5, 30), Position.CM, 50_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK}, 48, 48, 54, 85),
            new Player("Dávid", "Andreasen", Country.FO, 52, LocalDate.of(2004, 6, 27), Position.CM, 25_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK}, 35, 34, 52, 100),
            new Player("Latif", "Ahmed", Country.GH, 54, LocalDate.of(2002, 8, 29), Position.LM, 50_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK}, 53, 52, 34, 90),
            new Player("Jonn", "Johannesen", Country.FO, 54, LocalDate.of(2001, 12, 30), Position.LW, 50_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK}, 54, 51, 30, 92),
            new Player("Tóki", "á Lógv", Country.FO, 52, LocalDate.of(2004, 5, 1), Position.LW, 25_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK}, 53, 50, 28, 100),
            new Player("Árni", "Frederiksberg", Country.FO, 64, LocalDate.of(1992, 6, 13), Position.RW, 250_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK, ClubEnum.B36, ClubEnum.NSI}, 64, 63, 36, 20),
            new Player("Silas", "Gaard", Country.FO, 54, LocalDate.of(2004, 5, 22), Position.RW, 50_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK}, 55, 53, 26, 100),
            new Player("Olaf", "Hansen", Country.FO, 52, LocalDate.of(2002, 2, 20), Position.RW, 25_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK}, 52, 52, 30, 93),
            new Player("Sivert", "Gussiås", Country.NO, 63, LocalDate.of(1999, 8, 18), Position.ST, 175_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK, ClubEnum.SANDEFJORD, ClubEnum.STROMMEN}, 64, 55, 32, 77),
            new Player("Pætur", "Petersen", Country.FO, 56, LocalDate.of(1998, 3, 29), Position.ST, 75_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK, ClubEnum.AKUREYRI, ClubEnum.HB, ClubEnum.STREYMUR, ClubEnum.B36, ClubEnum.STREYMUR, ClubEnum.B36}, 58, 47, 30, 65),
            new Player("Páll", "Klettskard", Country.FO, 56, LocalDate.of(1990, 5, 17), Position.ST, 75_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK, ClubEnum.BRENO, ClubEnum.KLAKSVIK, ClubEnum.VIKINGUR_GOTA, ClubEnum.AMAGER, ClubEnum.KLAKSVIK}, 57, 52, 34, 6),
            new Player("Jóhan", "Josephsen", Country.FO, 54, LocalDate.of(2005, 9, 9), Position.ST, 50_000, ClubEnum.KLAKSVIK, new ClubEnum[]{ClubEnum.KLAKSVIK}, 56, 50, 30, 100),
            new Player("Jóannes", "Davidsen", Country.FO, 52, LocalDate.of(2002, 9, 19), Position.GK, 25_000, ClubEnum.STREYMUR, new ClubEnum[]{ClubEnum.STREYMUR}, 15, 15, 53, 86),
            new Player("Fayo", "Kruse", Country.FO, 51, LocalDate.of(2004, 4, 16), Position.GK, 10_000, ClubEnum.STREYMUR, new ClubEnum[]{ClubEnum.STREYMUR}, 14, 14, 52, 95),
            new Player("Mikkjal", "Hellisá", Country.FO, 54, LocalDate.of(2002, 2, 18), Position.CB, 50_000, ClubEnum.STREYMUR, new ClubEnum[]{ClubEnum.STREYMUR}, 33, 36, 53, 90),
            new Player("Andras", "Olsen", Country.FO, 54, LocalDate.of(1995, 10, 24), Position.CB, 50_000, ClubEnum.STREYMUR, new ClubEnum[]{ClubEnum.STREYMUR}, 32, 32, 54, 30),
            new Player("Árni Grunnveit", "Olsen", Country.FO, 49, LocalDate.of(1993, 9, 13), Position.CB, 10_000, ClubEnum.STREYMUR, new ClubEnum[]{ClubEnum.STREYMUR, ClubEnum.ARGIR, ClubEnum.STREYMUR}, 25, 25, 49, 8),
            new Player("Filip", "Johansen", Country.FO, 49, LocalDate.of(2003, 7, 21), Position.CB, 10_000, ClubEnum.STREYMUR, new ClubEnum[]{ClubEnum.STREYMUR}, 29, 30, 49, 95),
            new Player("Virgar", "Jónsson", Country.FO, 54, LocalDate.of(2006, 6, 13), Position.LB, 50_000, ClubEnum.STREYMUR, new ClubEnum[]{ClubEnum.STREYMUR}, 47, 46, 52, 100),
            new Player("Ólavur", "Niclasen", Country.FO, 50, LocalDate.of(1998, 7, 7), Position.LB, 10_000, ClubEnum.STREYMUR, new ClubEnum[]{ClubEnum.STREYMUR, ClubEnum.FUGLAFJORDUR, ClubEnum.KLAKSVIK}, 46, 46, 49, 50),
            new Player("Bergur", "Poulsen", Country.FO, 53, LocalDate.of(2003, 3, 5), Position.RB, 50_000, ClubEnum.STREYMUR, new ClubEnum[]{ClubEnum.STREYMUR}, 50, 52, 52, 95),
            new Player("Dánjal", "Godtfred", Country.FO, 55, LocalDate.of(1996, 3, 7), Position.CDM, 50_000, ClubEnum.STREYMUR, new ClubEnum[]{ClubEnum.STREYMUR, ClubEnum.TVOROYRI, ClubEnum.SUDUROY}, 47, 45, 54, 30),
            new Player("Elias", "El Moustage", Country.FO, 53, LocalDate.of(2001, 5, 30), Position.CDM, 25_000, ClubEnum.STREYMUR, new ClubEnum[]{ClubEnum.STREYMUR, ClubEnum.THISTED}, 49, 51, 52, 93),
            new Player("Rógvi", "Egilstoft", Country.FO, 55, LocalDate.of(1992, 12, 7), Position.CM, 50_000, ClubEnum.STREYMUR, new ClubEnum[]{ClubEnum.STREYMUR, ClubEnum.NSI, ClubEnum.STREYMUR, ClubEnum.SKALA, ClubEnum.STREYMUR, ClubEnum.VESTUR}, 52, 56, 49, 8),
            new Player("Tóki", "Johannesen", Country.FO, 52, LocalDate.of(1997, 3, 17), Position.CM, 25_000, ClubEnum.STREYMUR, new ClubEnum[]{ClubEnum.STREYMUR}, 51, 53, 45, 35),
            new Player("Jákup", "Hummeland", Country.FO, 52, LocalDate.of(2003, 12, 10), Position.CM, 25_000, ClubEnum.STREYMUR, new ClubEnum[]{ClubEnum.STREYMUR}, 44, 50, 49, 96),
            new Player("Niels Pauli", "Danielsen", Country.FO, 50, LocalDate.of(1989, 1, 18), Position.CM, 10_000, ClubEnum.STREYMUR, new ClubEnum[]{ClubEnum.STREYMUR, ClubEnum.SKALA, ClubEnum.FUGLAFJORDUR, ClubEnum.KLAKSVIK, ClubEnum.STREYMUR, ClubEnum.KLAKSVIK}, 45, 50, 42, 5),
            new Player("Sverri", "Mariusarson", Country.FO, 49, LocalDate.of(2004, 8, 2), Position.CM, 10_000, ClubEnum.STREYMUR, new ClubEnum[]{ClubEnum.STREYMUR}, 49, 47, 45, 100),
            new Player("Gutti", "Jóhansson", Country.FO, 50, LocalDate.of(2004, 8, 18), Position.CM, 10_000, ClubEnum.STREYMUR, new ClubEnum[]{ClubEnum.STREYMUR}, 47, 48, 48, 100),
            new Player("Arnar", "Dam", Country.FO, 49, LocalDate.of(1991, 10, 18), Position.CM, 10_000, ClubEnum.STREYMUR, new ClubEnum[]{ClubEnum.STREYMUR}, 48, 48, 48, 6),
            new Player("Hans Pauli", "á Bø", Country.FO, 52, LocalDate.of(2005, 10, 29), Position.LM, 25_000, ClubEnum.STREYMUR, new ClubEnum[]{ClubEnum.STREYMUR}, 52, 50, 35, 100),
            new Player("Niklas", "Kruse", Country.FO, 49, LocalDate.of(1999, 5, 11), Position.RW, 10_000, ClubEnum.STREYMUR, new ClubEnum[]{ClubEnum.STREYMUR, ClubEnum.HB, ClubEnum.STREYMUR}, 50, 50, 28, 85),
            new Player("Filip", "Djordjevic", Country.FO, 55, LocalDate.of(1994, 3, 7), Position.CF, 50_000, ClubEnum.STREYMUR, new ClubEnum[]{ClubEnum.STREYMUR, ClubEnum.TVOROYRI, ClubEnum.FUGLAFJORDUR, ClubEnum.VIKINGUR_GOTA, ClubEnum.KLAKSVIK}, 54, 55, 33, 16),
            new Player("Gutti", "Dahl-Olsen", Country.FO, 54, LocalDate.of(2002, 1, 19), Position.ST, 50_000, ClubEnum.STREYMUR, new ClubEnum[]{ClubEnum.STREYMUR}, 55, 50, 28, 95),
            new Player("Rani", "Hansen", Country.FO, 51, LocalDate.of(2000, 11, 27), Position.ST, 10_000, ClubEnum.STREYMUR, new ClubEnum[]{ClubEnum.STREYMUR}, 53, 45, 32, 92),

            new Player("Benjamin", "Schubert", Country.DK, 54, LocalDate.of(1996, 9, 22), Position.GK, 25_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR, ClubEnum.SONDERJYSKE, ClubEnum.KOLDING}, 21, 20, 54, 28),
            new Player("Tórdur", "Thomsen", Country.FO, 54, LocalDate.of(1986, 6, 11), Position.GK, 10_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR, ClubEnum.B36, ClubEnum.FUGLAFJORDUR, ClubEnum.TOFTIR, ClubEnum.HB, ClubEnum.ARGIR, ClubEnum.TOFTIR, ClubEnum.FUGLAFJORDUR}, 19, 19, 55, 6),
            new Player("Svend", "Danielsen", Country.FO, 49, LocalDate.of(2005, 10, 24), Position.GK, 10_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR}, 20, 20, 50, 100),
            new Player("Aleksandur", "Jensen", Country.FO, 62, LocalDate.of(2001, 5, 7), Position.CB, 50_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR}, 37, 37, 63, 81),
            new Player("Aron", "Hansen", Country.FO, 51, LocalDate.of(2004, 10, 4), Position.CB, 10_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR}, 33, 33, 51, 100),
            new Player("Ari", "Johannesen", Country.FO, 52, LocalDate.of(1996, 6, 7), Position.LB, 25_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR}, 47, 47, 52, 35),
            new Player("Hjalti", "Strømsten", Country.FO, 53, LocalDate.of(1997, 1, 21), Position.LB, 25_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR, ClubEnum.VIKINGUR_GOTA}, 49, 46, 52, 34),
            new Player("Alex", "Mellemgaard", Country.FO, 51, LocalDate.of(1991, 11, 27), Position.LB, 10_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR, ClubEnum.B36, ClubEnum.ARGIR}, 45, 45, 51, 12),
            new Player("Ragnar", "Samuelsen", Country.FO, 54, LocalDate.of(1999, 8, 23), Position.CDM, 50_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR, ClubEnum.B36, ClubEnum.STREYMUR, ClubEnum.B36}, 42, 46, 53, 73),
            new Player("Bárdur", "Jensen", Country.FO, 54, LocalDate.of(2001, 5, 7), Position.CM, 50_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR}, 48, 55, 48, 88),
            new Player("Áki", "Johannesen", Country.FO, 53, LocalDate.of(2002, 11, 11), Position.CM, 50_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR}, 53, 53, 39, 91),
            new Player("Karstin", "Clementsen", Country.FO, 49, LocalDate.of(2001, 9, 12), Position.RM, 10_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR}, 49, 50, 26, 90),
            new Player("Esmar", "Clementsen", Country.FO, 50, LocalDate.of(1996, 9, 29), Position.RM, 10_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR}, 50, 50, 32, 30),
            new Player("Hilmar", "Højgaard", Country.FO, 48, LocalDate.of(2003, 8, 22), Position.RM, 10_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR}, 49, 49, 25, 100),
            new Player("Eli", "Hansen", Country.FO, 48, LocalDate.of(2005, 10, 17), Position.LM, 10_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR}, 48, 50, 33, 100),
            new Player("Boubacar Sidik", "Dabo", Country.SN, 55, LocalDate.of(1997, 10, 10), Position.LW, 50_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR, ClubEnum.ANTONIANO}, 55, 50, 26, 36),
            new Player("Hanus", "Højgaard", Country.FO, 55, LocalDate.of(2005, 12, 3), Position.LW, 50_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR}, 55, 53, 30, 100),
            new Player("Gilli", "Samuelsen", Country.FO, 52, LocalDate.of(1999, 2, 12), Position.RW, 25_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR, ClubEnum.VESTUR, ClubEnum.B36, ClubEnum.VESTUR, ClubEnum.B36}, 53, 51, 24, 82),
            new Player("Sebastian", "Lau", Country.DK, 52, LocalDate.of(1996, 7, 2), Position.ST, 25_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR, ClubEnum.HELLERUP}, 54, 46, 27, 35),
            new Player("Jörgen", "Nielsen", Country.FO, 51, LocalDate.of(2003, 11, 30), Position.ST, 25_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR, ClubEnum.NSI, ClubEnum.OSTERS}, 52, 50, 35, 95),
            new Player("Frídi", "Petersen", Country.FO, 51, LocalDate.of(2003, 10, 18), Position.ST, 25_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR}, 52, 51, 32, 95),
            new Player("Hjarnar", "Johansen", Country.FO, 49, LocalDate.of(2004, 4, 13), Position.ST, 10_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR}, 52, 40, 22, 100),
            new Player("Bartal Páll", "Klein", Country.FO, 47, LocalDate.of(2006, 12, 15), Position.ST, 10_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR}, 49, 49, 30, 100),
            new Player("Villiam Emil", "Klein", Country.FO, 48, LocalDate.of(2000, 11, 21), Position.ST, 10_000, ClubEnum.TOFTIR, new ClubEnum[]{ClubEnum.TOFTIR, ClubEnum.HOYVIK, ClubEnum.HB}, 49, 49, 34, 93),

            new Player("Silas", "Eydsteinsson", Country.FO, 52, LocalDate.of(1998, 2, 13), Position.GK, 25_000, ClubEnum.B36, new ClubEnum[]{ClubEnum.B36, ClubEnum.STREYMUR, ClubEnum.B36, ClubEnum.TVOROYRI, ClubEnum.B36, ClubEnum.TVOROYRI, ClubEnum.B36, ClubEnum.VESTUR, ClubEnum.ARGIR, ClubEnum.HB, ClubEnum.VESTUR}, 18, 18, 52, 70),
            new Player("Hans", "Jørgensen", Country.FO, 49, LocalDate.of(1990, 8, 13), Position.GK, 10_000, ClubEnum.B36, new ClubEnum[]{ClubEnum.B36, ClubEnum.TOFTIR, ClubEnum.ARGIR, ClubEnum.HB, ClubEnum.STREYMUR, ClubEnum.HB, ClubEnum.TOFTIR, ClubEnum.VESTUR, ClubEnum.AMAGER, ClubEnum.SKALA}, 16, 16, 49, 5),
            new Player("Isak", "Jönsson", Country.SE, 63, LocalDate.of(1999, 1, 11), Position.CB, 200_000, ClubEnum.B36, new ClubEnum[]{ClubEnum.B36, ClubEnum.TRELLEBORGS, ClubEnum.BK_OLYMPIC}, 40, 38, 63, 77),
            new Player("Sonni", "Nattestad", Country.FO, 62, LocalDate.of(1994, 8, 5), Position.CB, 125_000, ClubEnum.B36, new ClubEnum[]{ClubEnum.B36, ClubEnum.DUNDALK, ClubEnum.B36, ClubEnum.FREDERICIA, ClubEnum.MOLDE, ClubEnum.HORSENS, ClubEnum.MOLDE, ClubEnum.AALESUND, ClubEnum.MOLDE, ClubEnum.HAFNARFJORDUR, ClubEnum.FYLKIR, ClubEnum.HAFNARFJORDUR, ClubEnum.MIDTJYLLAND, ClubEnum.VEJLE, ClubEnum.MIDTJYLLAND, ClubEnum.HORSENS, ClubEnum.MIDTJYLLAND, ClubEnum.VESTUR, ClubEnum.MIDVAGUR}, 42, 42, 61, 18),
            new Player("Andrias", "Eriksen", Country.FO, 52, LocalDate.of(1994, 2, 22), Position.CB, 25_000, ClubEnum.B36, new ClubEnum[]{ClubEnum.B36}, 33, 35, 52, 15),
            new Player("Mattias", "Joensen", Country.FO, 52, LocalDate.of(2003, 2, 15), Position.CB, 25_000, ClubEnum.B36, new ClubEnum[]{ClubEnum.B36, ClubEnum.STREYMUR, ClubEnum.B36}, 34, 33, 53, 95),
            new Player("Magnus", "Egilsson", Country.FO, 54, LocalDate.of(1994, 3, 19), Position.LB, 50_000, ClubEnum.B36, new ClubEnum[]{ClubEnum.B36, ClubEnum.VALUR, ClubEnum.HB, ClubEnum.B36_II, ClubEnum.HB, ClubEnum.ARGIR, ClubEnum.HB}, 49, 49, 52, 15),
            new Player("Jann", "Benjaminsen", Country.FO, 59, LocalDate.of(1997, 4, 3), Position.RB, 100_000, ClubEnum.B36, new ClubEnum[]{ClubEnum.B36, ClubEnum.HODD, ClubEnum.NSI, ClubEnum.NSI_II}, 55, 53, 57, 22),
            new Player("Benjamin", "Heinesen", Country.FO, 55, LocalDate.of(1996, 3, 26), Position.RB, 50_000, ClubEnum.B36, new ClubEnum[]{ClubEnum.B36}, 43, 43, 55, 20),
            new Player("Erlendur", "Magnusson", Country.FO, 53, LocalDate.of(1998, 7, 2), Position.RB, 25_000, ClubEnum.B36, new ClubEnum[]{ClubEnum.B36, ClubEnum.B36_II}, 47, 46, 51, 40),

            new Player("Bárdur", "á Reynatrød", Country.FO, 62, LocalDate.of(2000, 1, 8), Position.GK, 125_000, ClubEnum.VIKINGUR_GOTA, new ClubEnum[]{ClubEnum.VIKINGUR_GOTA, ClubEnum.SKALA, ClubEnum.VIKINGUR_GOTA}, 22, 22, 63, 90),
            new Player("Hans Jákup", "Arngrímsson", Country.FO, 53, LocalDate.of(2004, 3, 29), Position.GK, 25_000, ClubEnum.VIKINGUR_GOTA, new ClubEnum[]{ClubEnum.VIKINGUR_GOTA}, 17, 17, 53, 96),

            new Player("Ari", "Petersen", Country.FO, 60, LocalDate.of(2002, 12, 7), Position.GK, 100_000, ClubEnum.VESTUR, new ClubEnum[]{ClubEnum.VESTUR}, 24, 24, 60, 95),
            new Player("Steven", "van Dijk", Country.NL, 52, LocalDate.of(1997, 9, 1), Position.GK, 25_000, ClubEnum.VESTUR, new ClubEnum[]{ClubEnum.VESTUR, ClubEnum.STREYMUR, ClubEnum.VESTUR, ClubEnum.STREYMUR, ClubEnum.VESTUR, ClubEnum.VESTRI, ClubEnum.HAAKSBERGEN, ClubEnum.DEN_BOSCH}, 16, 16, 52, 35),
            new Player("Sámal", "á Steig", Country.FO, 49, LocalDate.of(2006, 12, 2), Position.GK, 10_000, ClubEnum.VESTUR, new ClubEnum[]{ClubEnum.VESTUR}, 14, 14, 50, 100),

            new Player("Tóri", "Tradará", Country.FO, 52, LocalDate.of(1996, 7, 16), Position.GK, 25_000, ClubEnum.FUGLAFJORDUR, new ClubEnum[]{ClubEnum.FUGLAFJORDUR, ClubEnum.SKALA, ClubEnum.FUGLAFJORDUR}, 21, 22, 53, 30),
            //Add fuglafjørður players
            new Player("Bogi", "Reinert-Petersen", Country.FO, 52, LocalDate.of(1993, 2, 20), Position.CDM, 25_000, ClubEnum.FUGLAFJORDUR, new ClubEnum[]{ClubEnum.FUGLAFJORDUR, ClubEnum.STREYMUR, ClubEnum.FUGLAFJORDUR, ClubEnum.VIKINGUR_GOTA, ClubEnum.FUGLAFJORDUR, ClubEnum.KOLDING, ClubEnum.FUGLAFJORDUR, ClubEnum.HB}, 42, 44, 51, 10),

            new Player("Markus", "Hellisdal", Country.FO, 53, LocalDate.of(2002, 10, 11), Position.CB, 25_000, ClubEnum.SKALA, new ClubEnum[]{ClubEnum.SKALA, ClubEnum.STREYMUR, ClubEnum.B36}, 28, 30, 54, 90),

            new Player("Kristian", "Joensen", Country.FO, 50, LocalDate.of(1991, 12, 21), Position.GK, 10_000, ClubEnum.NSI, new ClubEnum[]{ClubEnum.NSI, ClubEnum.STREYMUR, ClubEnum.KLAKSVIK, ClubEnum.STREYMUR, ClubEnum.KLAKSVIK, ClubEnum.VESTUR, ClubEnum.LYNGBY, ClubEnum.NSI, ClubEnum.TOFTIR, ClubEnum.NSI, ClubEnum.VESTUR, ClubEnum.NSI}, 23, 23, 50, 8),

            //-------------------------------------------------------
            //----------    1. deildin (Faroe Islands 2)   ----------
            //-------------------------------------------------------
            new Player("Antonío", "Borelli", Country.US, 55, LocalDate.of(1998, 11, 23), Position.GK, 25_000, ClubEnum.ARGIR, new ClubEnum[]{ClubEnum.ARGIR}, 21, 22, 56, 53),
            new Player("Rói", "Zachariasen", Country.FO, 55, LocalDate.of(1998, 10, 12), Position.GK, 10_000, ClubEnum.ARGIR, new ClubEnum[]{ClubEnum.ARGIR, ClubEnum.STREYMUR}, 20, 20, 55, 47),
            new Player("Tróndur", "á Høvdanum", Country.FO, 54, LocalDate.of(1995, 8, 19), Position.CB, 10_000, ClubEnum.ARGIR, new ClubEnum[]{ClubEnum.ARGIR}, 33, 34, 54, 34),
            new Player("Dánjal", "Danielsen", Country.FO, 54, LocalDate.of(2004, 7, 5), Position.CB, 10_000, ClubEnum.ARGIR, new ClubEnum[]{ClubEnum.ARGIR}, 35, 33, 55, 100),
            new Player("Rógvi", "Skala", Country.FO, 55, LocalDate.of(2000, 9, 5), Position.LB, 10_000, ClubEnum.ARGIR, new ClubEnum[]{ClubEnum.ARGIR}, 52, 54, 54, 87),
            new Player("Gunnar", "Reynslág", Country.FO, 54, LocalDate.of(2004, 11, 10), Position.LB, 10_000, ClubEnum.ARGIR, new ClubEnum[]{ClubEnum.ARGIR}, 50, 51, 54, 100),
            new Player("Beinir", "Ellefsen", Country.FO, 52, LocalDate.of(1993, 4, 7), Position.LB, 10_000, ClubEnum.ARGIR, new ClubEnum[]{ClubEnum.ARGIR}, 51, 51, 51, 31),
            new Player("Jákup", "Breckmann", Country.FO, 56, LocalDate.of(1998, 4, 16), Position.RB, 25_000, ClubEnum.ARGIR, new ClubEnum[]{ClubEnum.ARGIR, ClubEnum.TVOROYRI}, 52, 54, 56, 54),
            new Player("Bjarni", "Skála", Country.FO, 58, LocalDate.of(1997, 11, 14), Position.CDM, 25_000, ClubEnum.ARGIR, new ClubEnum[]{ClubEnum.ARGIR}, 48, 51, 57, 56),
            new Player("Santiago", "Lebus", Country.AR, 57, LocalDate.of(1996, 7, 18), Position.CM, 25_000, ClubEnum.ARGIR, new ClubEnum[]{ClubEnum.ARGIR, ClubEnum.FUGLAFJORDUR, ClubEnum.ARGIR, ClubEnum.PETROLERO, ClubEnum.ALL_BOYS}, 56, 57, 45, 48),
            new Player("Ragnar", "Skála", Country.FO, 57, LocalDate.of(2000, 9, 5), Position.CM, 25_000, ClubEnum.ARGIR, new ClubEnum[]{ClubEnum.ARGIR}, 54, 57, 57, 87),
            new Player("Bartal", "Petersen", Country.FO, 56, LocalDate.of(2000, 11, 22), Position.CM, 25_000, ClubEnum.ARGIR, new ClubEnum[]{ClubEnum.ARGIR}, 50, 57, 51, 86),
            new Player("Viktor", "Benediktsson", Country.IS, 55, LocalDate.of(1998, 9, 15), Position.CM, 25_000, ClubEnum.ARGIR, new ClubEnum[]{ClubEnum.ARGIR, ClubEnum.AKRANES, ClubEnum.HAFNARFJORDUR, ClubEnum.KOPAVOGUR, ClubEnum.HAFNARFJORDUR}, 54, 55, 45, 60),
            new Player("Marius", "Lindh", Country.DK, 55, LocalDate.of(1999, 6, 22), Position.RM, 25_000, ClubEnum.ARGIR, new ClubEnum[]{ClubEnum.ARGIR}, 55, 53, 30, 75),
            new Player("Filip", "í Lida", Country.FO, 52, LocalDate.of(2000, 11, 6), Position.RM, 25_000, ClubEnum.ARGIR, new ClubEnum[]{ClubEnum.ARGIR}, 53, 51, 33, 85),
            new Player("Teitur", "Olsen", Country.FO, 56, LocalDate.of(1998, 1, 27), Position.RW, 25_000, ClubEnum.ARGIR, new ClubEnum[]{ClubEnum.ARGIR, ClubEnum.STREYMUR}, 56, 55, 29, 62),
            new Player("Tóki", "á Lofti", Country.FO, 53, LocalDate.of(1993, 12, 6), Position.RW, 10_000, ClubEnum.ARGIR, new ClubEnum[]{ClubEnum.ARGIR, ClubEnum.STREYMUR, ClubEnum.VESTUR, ClubEnum.ARGIR}, 53, 50, 25, 21),
            new Player("Brian", "Jakobsen", Country.FO, 57, LocalDate.of(1991, 11, 4), Position.ST, 10_000, ClubEnum.ARGIR, new ClubEnum[]{ClubEnum.ARGIR, ClubEnum.B36}, 58, 50, 30, 13),
            new Player("Rói", "Nielsen", Country.FO, 52, LocalDate.of(2005, 6, 10), Position.ST, 10_000, ClubEnum.ARGIR, new ClubEnum[]{ClubEnum.ARGIR}, 53, 48, 27, 100),

            new Player("Anders", "Hoff", Country.DK, 54, LocalDate.of(2003, 9, 4), Position.GK, 50_000, ClubEnum.TVOROYRI, new ClubEnum[]{ClubEnum.TVOROYRI, ClubEnum.HORSENS, ClubEnum.MIDDELFART}, 23, 22, 55, 95),

            //-------------------------------------------------------
            //----------      1. Division (Denmark 2)      ----------
            //-------------------------------------------------------
            new Player("Mattias", "Lamhauge", Country.FO, 61, LocalDate.of(1999, 8, 2), Position.GK, 150_000, ClubEnum.FREDERICIA, new ClubEnum[]{ClubEnum.FREDERICIA, ClubEnum.B36, ClubEnum.HB, ClubEnum.ARGIR, ClubEnum.HB, ClubEnum.ARGIR, ClubEnum.HB}, 25, 25, 63, 77),

            //-------------------------------------------------------
            //----------      2. Division (Denmark 3)      ----------
            //-------------------------------------------------------
            new Player("Hørður", "Askham", Country.FO, 59, LocalDate.of(1994, 9, 22), Position.CB, 75_000, ClubEnum.AKADEMISK, new ClubEnum[]{ClubEnum.AKADEMISK, ClubEnum.HB, ClubEnum.KLAKSVIK, ClubEnum.B36, ClubEnum.VESTUR, ClubEnum.B36}, 32, 34, 59, 36),

            new Player("Daniel", "Johansen", Country.FO, 62, LocalDate.of(1998, 7, 9), Position.LB, 125_000, ClubEnum.THISTED, new ClubEnum[]{ClubEnum.THISTED, ClubEnum.HB, ClubEnum.FREDERICIA, ClubEnum.HB}, 59, 60, 61, 50),

            //-------------------------------------------------------
            //----------      Allsvenskan (Sweden 1)       ----------
            //-------------------------------------------------------
            new Player("Mads", "Borchers", Country.DK, 63, LocalDate.of(2002, 6, 18), Position.ST, 225_000, ClubEnum.VARBERGS, new ClubEnum[]{ClubEnum.VARBERGS, ClubEnum.HB, ClubEnum.ESBJERG, ClubEnum.VESTUR, ClubEnum.ESBJERG}, 64, 58, 35, 95),

            //-------------------------------------------------------
            //----------      Ettan Norra (Sweden 3)       ----------
            //-------------------------------------------------------
            new Player("Emil", "Berger", Country.SE, 59, LocalDate.of(1991, 5, 23), Position.CM, 75_000, ClubEnum.KARLSTAD, new ClubEnum[]{ClubEnum.KARLSTAD, ClubEnum.HB, ClubEnum.LEIKNIR, ClubEnum.DALKURD, ClubEnum.KONGSVINGER, ClubEnum.OREBRO, ClubEnum.FYLKIR, ClubEnum.OREBRO, ClubEnum.DEGERFORS, ClubEnum.AIK, ClubEnum.ESKILSTUNA, ClubEnum.AIK, ClubEnum.DEGERFORS}, 57, 61, 56, 11),

            //-------------------------------------------------------
            //---------  Norsk Tipping-Ligaen (Norway 4)   ----------
            //-------------------------------------------------------
            new Player("Vegard", "Forren", Country.NO, 52, LocalDate.of(1988, 2, 16), Position.CB, 25_000, ClubEnum.TRAEFF, new ClubEnum[]{ClubEnum.TRAEFF, ClubEnum.KLAKSVIK, ClubEnum.TRAEFF, ClubEnum.BRANN, ClubEnum.MOLDE, ClubEnum.BRIGHTON, ClubEnum.MOLDE, ClubEnum.SOUTHAMPTON, ClubEnum.MOLDE}, 35, 34, 52, 0),

            //-------------------------------------------------------
            //----------    Veikkausliiga (Finland 1)      ----------
            //-------------------------------------------------------
            new Player("Jakob", "Gottberg", Country.FI, 53, LocalDate.of(2002, 7, 20), Position.LW, 25_000, ClubEnum.EKENAS, new ClubEnum[]{ClubEnum.EKENAS, ClubEnum.ARGIR, ClubEnum.EKENAS}, 54, 53, 26, 93),

            //-------------------------------------------------------
            //----------     Besta deild (Iceland 1)       ----------
            //-------------------------------------------------------
            new Player("Matthias", "Præst", Country.DK, 61, LocalDate.of(2000, 6, 21), Position.CM, 125_000, ClubEnum.FYLKIR, new ClubEnum[]{ClubEnum.FYLKIR, ClubEnum.HB, ClubEnum.ARGIR, ClubEnum.MIDDELFART, ClubEnum.HORSENS}, 60, 61, 60, 85),

            //-------------------------------------------------------
            //----------     Regionalliga (Germany 4)      ----------
            //-------------------------------------------------------
            new Player("Aidan", "Liu", Country.US, 61, LocalDate.of(2000, 7, 1), Position.CB, 100_000, ClubEnum.VIKTORIA_BERLIN, new ClubEnum[]{ClubEnum.VIKTORIA_BERLIN, ClubEnum.TOFTIR, ClubEnum.VEJLE, ClubEnum.TOFTIR, ClubEnum.VEJLE, ClubEnum.INDY_ELEVEN, ClubEnum.VEJLE}, 40, 42, 60, 78),

            //-------------------------------------------------------
            //----------        Liga 3 (Portugal 3)        ----------
            //-------------------------------------------------------
            new Player("Sam", "Pollard", Country.ENG, 54, LocalDate.of(1999, 2, 21), Position.LB, 25_000, ClubEnum.VIANENSE, new ClubEnum[]{ClubEnum.VIANENSE, ClubEnum.ARGIR}, 51, 55, 52, 54),


            //-------------------------------------------------------
            //----------          WITHOUT CLUB             ----------
            //-------------------------------------------------------
            new Player("Rói", "Hentze", Country.FO, 59, LocalDate.of(1999, 9, 22), Position.GK, 75_000, ClubEnum.WITHOUT_CLUB, new ClubEnum[]{ClubEnum.WITHOUT_CLUB, ClubEnum.KLAKSVIK, ClubEnum.TOFTIR, ClubEnum.B36, ClubEnum.HB, ClubEnum.B36}, 22, 23, 61, 50),
            new Player("Ramzi", "Idrissou", Country.TG, 57, LocalDate.of(1996, 7, 31), Position.CB, 25_000, ClubEnum.WITHOUT_CLUB, new ClubEnum[]{ClubEnum.WITHOUT_CLUB, ClubEnum.ARGIR, ClubEnum.FUZINAR, ClubEnum.HODD, ClubEnum.LEVANGER, ClubEnum.HODD}, 38, 38, 58, 41),
    };

    public static List<Player> getAllPlayers() {
        Player checkId = getById(1);
        if (checkId == null) { //check if ID is set because otherwise it would be set EVERYTIME for ALL players
            //set IDs for all players
            int maxId = 1;
            for (Player p : players) {
                p.setId(maxId);
                maxId++;
            }
        }
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

    public static Player getById(int id) {
        if (id < 0) {
            return null;
        }
        for (Player p : players) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public static void addPlayer(Player p) {
        if (p == null) {
            return;
        }

        p.setId(getAllPlayers().size() + 1);
        players = ArrayHelper.extend(players);
        players[players.length - 1] = p;
    }
}
