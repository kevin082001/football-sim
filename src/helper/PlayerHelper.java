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

/**
 * Last updated on: Nov 18, 2023
 */
public class PlayerHelper {
    private final static Player[] players = new Player[]{ //Maximum talent = 100 (10% chance to level-up after a match)
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
            new Player(47, "Jonathan", "Johansson", Country.SE, 55, LocalDate.of(1991, 8, 19), Position.GK, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK, Club.RANHEIM, Club.NOTODDEN, Club.LJUNGSKILE}, 25, 25, 57, 22),
            new Player(48, "Hannis", "Matras", Country.FO, 52, LocalDate.of(2000, 11, 21), Position.GK, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK}, 19, 19, 53, 92),
            new Player(49, "Heini", "Vatnsdal", Country.FO, 62, LocalDate.of(1991, 10, 18), Position.CB, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK, Club.AMAGER, Club.HB, Club.SUDUROY}, 40, 42, 62, 26),
            new Player(50, "Börge", "Petersen", Country.FO, 61, LocalDate.of(2002, 4, 24), Position.CB, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK}, 43, 42, 62, 92),
            new Player(51, "Odmar", "Færø", Country.FO, 58, LocalDate.of(1989, 11, 1), Position.CB, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK, Club.HAMKAM, Club.B36, Club.FORFAR, Club.KEITH}, 36, 38, 58, 15),
            new Player(52, "Vegard", "Forren", Country.NO, 52, LocalDate.of(1988, 2, 16), Position.CB, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK, Club.TRAEFF, Club.BRANN, Club.MOLDE, Club.BRIGHTON, Club.MOLDE, Club.SOUTHAMPTON, Club.MOLDE}, 35, 34, 52, 0),
            new Player(53, "Símun", "Kalsø", Country.FO, 52, LocalDate.of(2003, 2, 24), Position.CB, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK}, 31, 31, 51, 92),
            new Player(54, "Jákup", "Vilhelmsen", Country.FO, 51, LocalDate.of(2004, 1, 30), Position.CB, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK}, 32, 34, 51, 100),
            new Player(55, "Patrick", "Da Silva", Country.DK, 64, LocalDate.of(1994, 10, 23), Position.LB, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK, Club.LYNGBY, Club.ROSKILDE, Club.NORDSJAELLAND, Club.BRONDBY, Club.RANDERS, Club.BRONDBY}, 62, 62, 64, 32),
            new Player(56, "Joánnes", "Danielsen", Country.FO, 63, LocalDate.of(1997, 9, 10), Position.RB, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK, Club.NAESTVED}, 58, 59, 62, 40),
            new Player(57, "Claes", "Kronberg", Country.DK, 52, LocalDate.of(1987, 4, 19), Position.RB, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK, Club.SANDNES, Club.VIKING, Club.SARPSBORG, Club.NYKOBING}, 49, 47, 51, 0),
            new Player(58, "Jákup", "Andreasen", Country.FO, 65, LocalDate.of(1998, 5, 31), Position.CDM, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK}, 55, 57, 63, 45),
            new Player(59, "Deni", "Pavlovic", Country.RS, 61, LocalDate.of(1993, 9, 1), Position.CDM, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK, Club.NOVI_PAZAR, Club.MACVA, Club.VOZDOVAC, Club.CUKARICKI}, 52, 52, 60, 23),
            new Player(60, "Luc", "Kassi", Country.NO, 63, LocalDate.of(1994, 8, 20), Position.CM, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK, Club.STABAEK}, 59, 62, 57, 28),
            new Player(61, "Hallur", "Hansson", Country.FO, 63, LocalDate.of(1992, 7, 8), Position.CM, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK, Club.KR_REYKJAVIK, Club.VEJLE, Club.HORSENS, Club.VENDSYSSEL, Club.VIKINGUR_GOTA, Club.AALBORG}, 63, 60, 49, 15),
            new Player(62, "Mads", "Mikkelsen", Country.FO, 62, LocalDate.of(1999, 12, 11), Position.CM, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK, Club.VENDSYSSEL}, 60, 60, 55, 55),
            new Player(63, "René", "Joensen", Country.FO, 61, LocalDate.of(1993, 2, 8), Position.CM, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK, Club.HB, Club.GRINDAVIK, Club.VENDSYSSEL, Club.HB, Club.BRONDBY, Club.HB, Club.BRONDBY}, 52, 55, 60, 18),
            new Player(64, "Óli", "Poulsen", Country.FO, 55, LocalDate.of(2001, 5, 30), Position.CM, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK}, 48, 48, 54, 85),
            new Player(65, "Dávid", "Andreasen", Country.FO, 52, LocalDate.of(2004, 6, 27), Position.CM, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK}, 35, 34, 52, 100),
            new Player(66, "Latif", "Ahmed", Country.GH, 54, LocalDate.of(2002, 8, 29), Position.LM, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK}, 53, 52, 34, 90),
            new Player(67, "Jonn", "Johannesen", Country.FO, 54, LocalDate.of(2001, 12, 30), Position.LW, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK}, 54, 51, 30, 92),
            new Player(68, "Tóki", "á Lógv", Country.FO, 52, LocalDate.of(2004, 5, 1), Position.LW, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK}, 53, 50, 28, 100),
            new Player(69, "Árni", "Frederiksberg", Country.FO, 64, LocalDate.of(1992, 6, 13), Position.RW, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK, Club.B36, Club.NSI}, 64, 63, 36, 20),
            new Player(70, "Silas", "Gaard", Country.FO, 54, LocalDate.of(2004, 5, 22), Position.RW, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK}, 55, 53, 26, 100),
            new Player(71, "Olaf", "Hansen", Country.FO, 52, LocalDate.of(2002, 2, 20), Position.RW, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK}, 52, 52, 30, 93),
            new Player(72, "Sivert", "Gussiås", Country.NO, 63, LocalDate.of(1999, 8, 18), Position.ST, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK, Club.SANDEFJORD, Club.STROMMEN}, 64, 55, 32, 77),
            new Player(73, "Páll", "Klettskard", Country.FO, 56, LocalDate.of(1990, 5, 17), Position.ST, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK, Club.BRENO, Club.KLAKSVIK, Club.VIKINGUR_GOTA, Club.AMAGER, Club.KLAKSVIK}, 57, 52, 34, 6),
            new Player(74, "Jóhan", "Josephsen", Country.FO, 54, LocalDate.of(2005, 9, 9), Position.ST, Club.KLAKSVIK, new Club[]{Club.KLAKSVIK}, 56, 50, 30, 100),

            new Player(75, "Jóannes", "Davidsen", Country.FO, 52, LocalDate.of(2002, 9, 19), Position.GK, Club.STREYMUR, new Club[]{Club.STREYMUR}, 15, 15, 53, 86),
            new Player(76, "Steven", "van Dijk", Country.NL, 52, LocalDate.of(1997, 9, 1), Position.GK, Club.STREYMUR, new Club[]{Club.STREYMUR, Club.VESTUR, Club.STREYMUR, Club.VESTUR, Club.VESTRI, Club.HAAKSBERGEN, Club.DEN_BOSCH}, 16, 16, 52, 35),
            new Player(77, "Fayo", "Kruse", Country.FO, 51, LocalDate.of(2004, 4, 16), Position.GK, Club.STREYMUR, new Club[]{Club.STREYMUR}, 14, 14, 52, 95),
            new Player(78, "Mikkjal", "Hellisá", Country.FO, 54, LocalDate.of(2002, 2, 18), Position.CB, Club.STREYMUR, new Club[]{Club.STREYMUR}, 33, 36, 53, 90),
            new Player(79, "Andras", "Olsen", Country.FO, 54, LocalDate.of(1995, 10, 24), Position.CB, Club.STREYMUR, new Club[]{Club.STREYMUR}, 32, 32, 54, 30),
            new Player(80, "Markus", "Hellisdal", Country.FO, 53, LocalDate.of(2002, 10, 11), Position.CB, Club.STREYMUR, new Club[]{Club.STREYMUR, Club.B36}, 28, 30, 54, 90),
            new Player(81, "Árni Grunnveit", "Olsen", Country.FO, 49, LocalDate.of(1993, 9, 13), Position.CB, Club.STREYMUR, new Club[]{Club.STREYMUR, Club.ARGIR, Club.STREYMUR}, 25, 25, 49, 8),
            new Player(82, "Filip", "Johansen", Country.FO, 49, LocalDate.of(2003, 7, 21), Position.CB, Club.STREYMUR, new Club[]{Club.STREYMUR}, 29, 30, 49, 95),
            new Player(83, "Virgar", "Jónsson", Country.FO, 54, LocalDate.of(2006, 6, 13), Position.LB, Club.STREYMUR, new Club[]{Club.STREYMUR}, 47, 46, 52, 100),
            new Player(84, "Ólavur", "Niclasen", Country.FO, 50, LocalDate.of(1998, 7, 7), Position.LB, Club.STREYMUR, new Club[]{Club.STREYMUR, Club.FUGLAFJORDUR, Club.KLAKSVIK}, 46, 46, 49, 50),
            new Player(85, "Bergur", "Poulsen", Country.FO, 53, LocalDate.of(2003, 3, 5), Position.RB, Club.STREYMUR, new Club[]{Club.STREYMUR}, 50, 52, 52, 95),
            new Player(86, "Dánjal", "Godtfred", Country.FO, 55, LocalDate.of(1996, 3, 7), Position.CDM, Club.STREYMUR, new Club[]{Club.STREYMUR, Club.TVOROYRI, Club.SUDUROY}, 47, 45, 54, 30),
            new Player(87, "Elias", "El Moustage", Country.FO, 53, LocalDate.of(2001, 5, 30), Position.CDM, Club.STREYMUR, new Club[]{Club.STREYMUR, Club.THISTED}, 49, 51, 52, 93),
            new Player(88, "Bogi", "Reinert-Petersen", Country.FO, 52, LocalDate.of(1993, 2, 20), Position.CDM, Club.STREYMUR, new Club[]{Club.STREYMUR, Club.FUGLAFJORDUR, Club.VIKINGUR_GOTA, Club.FUGLAFJORDUR, Club.KOLDING, Club.FUGLAFJORDUR, Club.HB}, 42, 44, 51, 10),
            new Player(89, "Rógvi", "Egilstoft", Country.FO, 55, LocalDate.of(1992, 12, 7), Position.CM, Club.STREYMUR, new Club[]{Club.STREYMUR, Club.NSI, Club.STREYMUR, Club.SKALA, Club.STREYMUR, Club.VESTUR}, 52, 56, 49, 8),
            new Player(90, "Tóki", "Johannesen", Country.FO, 52, LocalDate.of(1997, 3, 17), Position.CM, Club.STREYMUR, new Club[]{Club.STREYMUR}, 51, 53, 45, 35),
            new Player(91, "Jákup", "Hummeland", Country.FO, 52, LocalDate.of(2003, 12, 10), Position.CM, Club.STREYMUR, new Club[]{Club.STREYMUR}, 44, 50, 49, 96),
            new Player(92, "Niels Pauli", "Danielsen", Country.FO, 50, LocalDate.of(1989, 1, 18), Position.CM, Club.STREYMUR, new Club[]{Club.STREYMUR, Club.SKALA, Club.FUGLAFJORDUR, Club.KLAKSVIK, Club.STREYMUR, Club.KLAKSVIK}, 45, 50, 42, 5),
            new Player(93, "Sverri", "Mariusarson", Country.FO, 49, LocalDate.of(2004, 8, 2), Position.CM, Club.STREYMUR, new Club[]{Club.STREYMUR}, 49, 47, 45, 100),
            new Player(94, "Gutti", "Jóhansson", Country.FO, 50, LocalDate.of(2004, 8, 18), Position.CM, Club.STREYMUR, new Club[]{Club.STREYMUR}, 47, 48, 48, 100),
            new Player(95, "Arnar", "Dam", Country.FO, 49, LocalDate.of(1991, 10, 18), Position.CM, Club.STREYMUR, new Club[]{Club.STREYMUR}, 48, 48, 48, 6),
            new Player(96, "Hans Pauli", "á Bø", Country.FO, 52, LocalDate.of(2005, 10, 29), Position.LM, Club.STREYMUR, new Club[]{Club.STREYMUR}, 52, 50, 35, 100),
            new Player(97, "Niklas", "Kruse", Country.FO, 49, LocalDate.of(1999, 5, 11), Position.RW, Club.STREYMUR, new Club[]{Club.STREYMUR, Club.HB, Club.STREYMUR}, 50, 50, 28, 85),
            new Player(98, "Filip", "Djordjevic", Country.FO, 55, LocalDate.of(1994, 3, 7), Position.CF, Club.STREYMUR, new Club[]{Club.STREYMUR, Club.TVOROYRI, Club.FUGLAFJORDUR, Club.VIKINGUR_GOTA, Club.KLAKSVIK}, 54, 55, 33, 16),
            new Player(99, "Gutti", "Dahl-Olsen", Country.FO, 54, LocalDate.of(2002, 1, 19), Position.ST, Club.STREYMUR, new Club[]{Club.STREYMUR}, 55, 50, 28, 95),
            new Player(100, "Rani", "Hansen", Country.FO, 51, LocalDate.of(2000, 11, 27), Position.ST, Club.STREYMUR, new Club[]{Club.STREYMUR}, 53, 45, 32, 92),

            new Player(101, "Benjamin", "Schubert", Country.DK, 54, LocalDate.of(1996, 9, 22), Position.GK, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.SONDERJYSKE, Club.KOLDING}, 21, 20, 54, 28),
            new Player(102, "Tórdur", "Thomsen", Country.FO, 54, LocalDate.of(1986, 6, 11), Position.GK, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.B36, Club.FUGLAFJORDUR, Club.TOFTIR, Club.HB, Club.ARGIR, Club.TOFTIR, Club.FUGLAFJORDUR}, 19, 19, 55, 6),
            new Player(103, "Svend", "Danielsen", Country.FO, 49, LocalDate.of(2005, 10, 24), Position.GK, Club.TOFTIR, new Club[]{Club.TOFTIR}, 20, 20, 50, 100),
            new Player(104, "Aleksandur", "Jensen", Country.FO, 62, LocalDate.of(2001, 5, 7), Position.CB, Club.TOFTIR, new Club[]{Club.TOFTIR}, 37, 37, 63, 81),
            new Player(105, "Aron", "Hansen", Country.FO, 51, LocalDate.of(2004, 10, 4), Position.CB, Club.TOFTIR, new Club[]{Club.TOFTIR}, 33, 33, 51, 100),
            new Player(106, "Ari", "Johannesen", Country.FO, 52, LocalDate.of(1996, 6, 7), Position.LB, Club.TOFTIR, new Club[]{Club.TOFTIR}, 47, 47, 52, 35),
            new Player(107, "Hjalti", "Strømsten", Country.FO, 53, LocalDate.of(1997, 1, 21), Position.LB, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.VIKINGUR_GOTA}, 49, 46, 52, 34),
            new Player(108, "Alex", "Mellemgaard", Country.FO, 51, LocalDate.of(1991, 11, 27), Position.LB, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.B36, Club.ARGIR}, 45, 45, 51, 12),
            new Player(109, "Ragnar", "Samuelsen", Country.FO, 54, LocalDate.of(1999, 8, 23), Position.CDM, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.B36, Club.STREYMUR, Club.B36}, 42, 46, 53, 73),
            new Player(110, "Bárdur", "Jensen", Country.FO, 54, LocalDate.of(2001, 5, 7), Position.CM, Club.TOFTIR, new Club[]{Club.TOFTIR}, 48, 55, 48, 88),
            new Player(111, "Áki", "Johannesen", Country.FO, 53, LocalDate.of(2002, 11, 11), Position.CM, Club.TOFTIR, new Club[]{Club.TOFTIR}, 53, 53, 39, 91),
            new Player(112, "Karstin", "Clementsen", Country.FO, 49, LocalDate.of(2001, 9, 12), Position.RM, Club.TOFTIR, new Club[]{Club.TOFTIR}, 49, 50, 26, 90),
            new Player(113, "Esmar", "Clementsen", Country.FO, 50, LocalDate.of(1996, 9, 29), Position.RM, Club.TOFTIR, new Club[]{Club.TOFTIR}, 50, 50, 32, 30),
            new Player(114, "Hilmar", "Højgaard", Country.FO, 48, LocalDate.of(2003, 8, 22), Position.RM, Club.TOFTIR, new Club[]{Club.TOFTIR}, 49, 49, 25, 100),
            new Player(115, "Eli", "Hansen", Country.FO, 48, LocalDate.of(2005, 10, 17), Position.LM, Club.TOFTIR, new Club[]{Club.TOFTIR}, 48, 50, 33, 100),
            new Player(116, "Boubacar Sidik", "Dabo", Country.SN, 55, LocalDate.of(1997, 10, 10), Position.LW, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.ANTONIANO}, 55, 50, 26, 36),
            new Player(117, "Hanus", "Højgaard", Country.FO, 55, LocalDate.of(2005, 12, 3), Position.LW, Club.TOFTIR, new Club[]{Club.TOFTIR}, 55, 53, 30, 100),
            new Player(118, "Maha", "Samba", Country.GM, 56, LocalDate.of(1998, 11, 9), Position.RW, Club.TOFTIR, new Club[]{Club.TOFTIR}, 55, 55, 36, 66),
            new Player(119, "Gilli", "Samuelsen", Country.FO, 52, LocalDate.of(1999, 2, 12), Position.RW, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.VESTUR, Club.B36, Club.VESTUR, Club.B36}, 53, 51, 24, 82),
            new Player(120, "Sebastian", "Lau", Country.DK, 52, LocalDate.of(1996, 7, 2), Position.ST, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.HELLERUP}, 54, 46, 27, 35),
            new Player(121, "Jörgen", "Nielsen", Country.FO, 51, LocalDate.of(2003, 11, 30), Position.ST, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.NSI, Club.OSTERS}, 52, 50, 35, 95),
            new Player(122, "Frídi", "Petersen", Country.FO, 51, LocalDate.of(2003, 10, 18), Position.ST, Club.TOFTIR, new Club[]{Club.TOFTIR}, 52, 51, 32, 95),
            new Player(123, "Hjarnar", "Johansen", Country.FO, 49, LocalDate.of(2004, 4, 13), Position.ST, Club.TOFTIR, new Club[]{Club.TOFTIR}, 52, 40, 22, 100),
            new Player(124, "Bartal Páll", "Klein", Country.FO, 47, LocalDate.of(2006, 12, 15), Position.ST, Club.TOFTIR, new Club[]{Club.TOFTIR}, 49, 49, 30, 100),
            new Player(125, "Villiam Emil", "Klein", Country.FO, 48, LocalDate.of(2000, 11, 21), Position.ST, Club.TOFTIR, new Club[]{Club.TOFTIR, Club.HOYVIK, Club.HB}, 49, 49, 34, 93),

            new Player(126, "Mattias", "Lamhauge", Country.FO, 61, LocalDate.of(1999, 8, 2), Position.GK, Club.B36, new Club[]{Club.B36, Club.HB, Club.ARGIR, Club.HB, Club.ARGIR, Club.HB}, 25, 25, 63, 77),
            new Player(127, "Silas", "Eydsteinsson", Country.FO, 52, LocalDate.of(1998, 2, 13), Position.GK, Club.B36, new Club[]{Club.B36, Club.STREYMUR, Club.B36, Club.TVOROYRI, Club.B36, Club.TVOROYRI, Club.B36, Club.VESTUR, Club.ARGIR, Club.HB, Club.VESTUR}, 18, 18, 52, 70),
            new Player(128, "Hans", "Jørgensen", Country.FO, 49, LocalDate.of(1990, 8, 13), Position.GK, Club.B36, new Club[]{Club.B36, Club.TOFTIR, Club.ARGIR, Club.HB, Club.STREYMUR, Club.HB, Club.TOFTIR, Club.VESTUR, Club.AMAGER, Club.SKALA}, 16, 16, 49, 5),
            new Player(129, "Isak", "Jönsson", Country.SE, 63, LocalDate.of(1999, 1, 11), Position.CB, Club.B36, new Club[]{Club.B36, Club.TRELLEBORGS, Club.BK_OLYMPIC}, 40, 38, 63, 77),
            new Player(130, "Sonni", "Nattestad", Country.FO, 62, LocalDate.of(1994, 8, 5), Position.CB, Club.B36, new Club[]{Club.B36, Club.DUNDALK, Club.B36, Club.FREDERICIA, Club.MOLDE, Club.HORSENS, Club.MOLDE, Club.AALESUND, Club.MOLDE, Club.HAFNARFJORDUR, Club.FYLKIR, Club.HAFNARFJORDUR, Club.MIDTJYLLAND, Club.VEJLE, Club.MIDTJYLLAND, Club.HORSENS, Club.MIDTJYLLAND, Club.VESTUR, Club.MIDVAGUR}, 42, 42, 61, 18),
            new Player(131, "Andrias", "Eriksen", Country.FO, 52, LocalDate.of(1994, 2, 22), Position.CB, Club.B36, new Club[]{Club.B36}, 33, 35, 52, 15),
            new Player(132, "Mattias", "Joensen", Country.FO, 52, LocalDate.of(2003, 2, 15), Position.CB, Club.B36, new Club[]{Club.B36, Club.STREYMUR, Club.B36}, 34, 33, 53, 95),


            new Player(133, "Bárdur", "á Reynatrød", Country.FO, 62, LocalDate.of(2000, 1, 8), Position.GK, Club.VIKINGUR_GOTA, new Club[]{Club.VIKINGUR_GOTA, Club.SKALA, Club.VIKINGUR_GOTA}, 22, 22, 63, 90),
            new Player(134, "Hans Jákup", "Arngrímsson", Country.FO, 53, LocalDate.of(2004, 3, 29), Position.GK, Club.VIKINGUR_GOTA, new Club[]{Club.VIKINGUR_GOTA}, 17, 17, 53, 96),

            new Player(135, "Ari", "Petersen", Country.FO, 60, LocalDate.of(2002, 12, 7), Position.GK, Club.VESTUR, new Club[]{Club.VESTUR}, 24, 24, 60, 95),
            new Player(136, "Sámal", "á Steig", Country.FO, 49, LocalDate.of(2006, 12, 2), Position.GK, Club.VESTUR, new Club[]{Club.VESTUR}, 14, 14, 50, 100),

            new Player(137, "Tóri", "Tradará", Country.FO, 52, LocalDate.of(1996, 7, 16), Position.GK, Club.FUGLAFJORDUR, new Club[]{Club.FUGLAFJORDUR, Club.SKALA, Club.FUGLAFJORDUR}, 21, 22, 53, 30),

            new Player(138, "Anders", "Hoff", Country.DK, 54, LocalDate.of(2003, 9, 4), Position.GK, Club.TVOROYRI, new Club[]{Club.TVOROYRI, Club.HORSENS, Club.MIDDELFART}, 23, 22, 55, 95),

            //-------------------------------------------------------
            //----------      2. Division (Denmark 3)      ----------
            //-------------------------------------------------------
            new Player(139, "Hørður", "Askham", Country.FO, 59, LocalDate.of(1994, 9, 22), Position.CB, Club.AKADEMISK, new Club[]{Club.AKADEMISK, Club.HB, Club.KLAKSVIK, Club.B36, Club.VESTUR, Club.B36}, 32, 34, 59, 36),

            new Player(140, "Daniel", "Johansen", Country.FO, 62, LocalDate.of(1998, 7, 9), Position.LB, Club.THISTED, new Club[]{Club.THISTED, Club.HB, Club.FREDERICIA, Club.HB}, 59, 60, 61, 50),

            //-------------------------------------------------------
            //----------      Allsvenskan (Sweden 1)       ----------
            //-------------------------------------------------------
            new Player(141, "Mads", "Borchers", Country.DK, 62, LocalDate.of(2002, 6, 18), Position.ST, Club.VARBERGS, new Club[]{Club.VARBERGS, Club.HB, Club.ESBJERG, Club.VESTUR, Club.ESBJERG}, 64, 58, 35, 95),

            //-------------------------------------------------------
            //----------       Ykkönen (Finland 2)         ----------
            //-------------------------------------------------------
            new Player(142, "Jakob", "Gottberg", Country.FI, 53, LocalDate.of(2002, 7, 20), Position.LW, Club.EKENAS, new Club[]{Club.EKENAS, Club.ARGIR, Club.EKENAS}, 54, 53, 26, 93),

            //-------------------------------------------------------
            //----------     Regionalliga (Germany 4)      ----------
            //-------------------------------------------------------
            new Player(143, "Aidan", "Liu", Country.US, 61, LocalDate.of(2000, 7, 1), Position.CB, Club.VIKTORIA_BERLIN, new Club[]{Club.VIKTORIA_BERLIN, Club.TOFTIR, Club.VEJLE, Club.TOFTIR, Club.VEJLE, Club.INDY_ELEVEN, Club.VEJLE}, 40, 42, 60, 78),


            //-------------------------------------------------------
            //----------          VEREINSLOS               ----------
            //-------------------------------------------------------
            new Player(144, "Rói", "Hentze", Country.FO, 59, LocalDate.of(1999, 9, 22), Position.GK, Club.WITHOUT_CLUB, new Club[]{Club.WITHOUT_CLUB, Club.KLAKSVIK, Club.TOFTIR, Club.B36, Club.HB, Club.B36}, 22, 23, 61, 50),
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
