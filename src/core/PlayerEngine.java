package core;

import GameObjects.Match;
import GameObjects.Player;
import GameObjects.PlayerCareer;
import GameObjects.PlayerName;
import enums.Club;
import enums.Country;
import enums.NewsType;
import enums.Position;
import helper.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerEngine {
    private final static Random rand = new Random(System.nanoTime());

    //TODO consider improving logic (maybe add some randomness)
    public static int[] getPotential(Player player) {
        if (player == null) {
            return new int[]{0, 0};
        }

        int[] potential = new int[2]; // index 0: min. potential / index 1: max. potential
        int talent = player.getTalent();
        int rating = player.getRating();

        if (talent == 0) {
            potential[0] = rating;
            potential[1] = rating;
        } else if (talent <= 10) {
            potential[0] = rating;
            potential[1] = rating + 2;
        } else if (talent <= 20) {
            potential[0] = rating + 1;
            potential[1] = rating + 5;
        } else if (talent <= 35) {
            potential[0] = rating + 2;
            potential[1] = rating + 7;
        } else if (talent <= 50) {
            potential[0] = rating + 3;
            potential[1] = rating + 8;
        } else if (talent <= 70) {
            potential[0] = rating + 5;
            potential[1] = rating + 11;
        } else if (talent <= 85) {
            potential[0] = rating + 9;
            potential[1] = rating + 16;
        } else {
            potential[0] = rating + 18;
            potential[1] = rating + 30;
        }

        potential[0] = Math.min(potential[0], 99);
        potential[1] = Math.min(potential[1], 99);
        return potential;
    }

    //TODO only check for players who performed well in the match (How is "good performance" defined?)
    public static void checkForPlayerLevelUp(Match match, boolean isOwnClub) { //TODO 'isOwnClub' is a bad hack, extract println instead
        List<Player> toCheck = new ArrayList<>();
        toCheck.addAll(PlayerHelper.getPlayersForClub(match.getHome()));
        toCheck.addAll(PlayerHelper.getPlayersForClub(match.getAway()));

        for (Player p : toCheck) {
            double tmp = (double) p.getTalent() / 10;
            if (rand.nextDouble(100) <= tmp) {
                int oldRating = p.getRating();
                p.levelUp();
                if (isOwnClub) {
                    System.out.println("LEVEL-UP: " + p.getFirstName() + " " + p.getLastName() + " (" + oldRating + " -> " + p.getRating() + ")");
                }
            }
        }
    }

    public static String getClubsSoFarAsString(Club[] clubsSoFar) {
        if (clubsSoFar.length == 1) {
            return clubsSoFar[0].toString();
        }

        String result = "";
        for (int i = 0; i < clubsSoFar.length - 1; i++) {
            result += clubsSoFar[i] + ",";
        }

        result += clubsSoFar[clubsSoFar.length - 1];
        return result;
    }

    public static Club[] getClubsSoFar(String asString) {
        Club[] clubsSoFar = new Club[0];
        String[] clubsSeparated = asString.split(",");

        for (int i = 0; i < clubsSeparated.length; i++) {
            clubsSoFar = ArrayHelper.extend(clubsSoFar);
            clubsSoFar[clubsSoFar.length - 1] = Club.B36.getByEnumName(clubsSeparated[i]);
        }

        return clubsSoFar;
    }


    // --------------------------
    // -----   RETIREMENT   -----
    // --------------------------

    public static void checkForPlayerRetirement(int currentSeason) {
        List<Player> allPlayers = PlayerHelper.getAllPlayers();
        Random rand = new Random(System.nanoTime());
        for (Player p : allPlayers) {
            int retirementChance = getRetirementChance(p);
            int randNumber = rand.nextInt(100);
            if (randNumber <= retirementChance) {
                retirePlayer(p, currentSeason);
                NewsEngine.createNewsEntry(null, p, NewsType.RETIREMENT, true);
            }
        }
    }

    private static void retirePlayer(Player p, int currentSeason) {
        p.setClub(Club.RETIRED);
        p.setAttack(0);
        p.setControl(0);
        p.setDefense(0);
        p.setMarketValue(0);
        p.setRating(0);
        p.setRetirementSeason(currentSeason);
        p.setTalent(0);

        Club[] clubsSoFar = p.getClubsSoFar();
        clubsSoFar = ArrayHelper.extend(clubsSoFar);
        clubsSoFar[clubsSoFar.length - 1] = Club.RETIRED;
        p.setClubsSoFar(clubsSoFar);

        PlayerCareer[] career = p.getCareer();
        if (career != null) { //This is kind of a bad hack, career should not be null at all
            career = ArrayHelper.extend(career);
            career[career.length - 1] = new PlayerCareer(p.getClub(), p, 0);
        }

        PrintHelper.printMessagePlayerRetirement(p);
    }

    private static int getRetirementChance(Player p) {
        int playerAge = getPlayerAge(p);
        if (playerAge <= 0) {
            throw new RuntimeException("An error occurred during calculating retirement chances");
        }
        if (playerAge <= 24) {
            return 0;
        }
        if (playerAge <= 28) {
            return 2;
        }
        if (playerAge <= 30) {
            return 4;
        }
        if (playerAge <= 32) {
            return 8;
        }
        if (playerAge <= 34) {
            return 20;
        }
        if (playerAge == 35) {
            return 35;
        }
        if (playerAge == 36) {
            return 50;
        }
        if (playerAge == 37) {
            return 60;
        }
        if (playerAge <= 40) {
            return 80;
        } else {
            return 95;
        }
    }

    public static int getPlayerAge(Player p) {
        //TODO make this calculation correct
        return p == null ? -1 : LocalDate.now().getYear() - p.getBirthDate().getYear();
    }

    // -----------------------------
    // -----   YOUTH ACADEMY   -----
    // -----------------------------

    public static void checkPlayersJoiningFromAcademy() {
        List<Club> allClubs = ClubHelper.getAllClubs();

        for (Club club : allClubs) {
            int chanceToGeneratePlayer = rand.nextInt(100);

            //60% for 1 player to join
            //30% for 2 players to join
            //10% for 3 players to join
            if (chanceToGeneratePlayer <= 60) {
                Player newPlayer = generateYouthPlayer(club);
                PlayerHelper.addPlayer(newPlayer);
            } else if (chanceToGeneratePlayer <= 90) {
                for (int i = 1; i <= 2; i++) {
                    Player newPlayer = generateYouthPlayer(club);
                    PlayerHelper.addPlayer(newPlayer);
                }
            } else {
                for (int i = 1; i <= 3; i++) {
                    Player newPlayer = generateYouthPlayer(club);
                    PlayerHelper.addPlayer(newPlayer);
                }
            }
        }
    }

    private static Player generateYouthPlayer(Club club) {
        NameGenerator ng = new NameGenerator();
        PlayerName name = ng.getRandomName();
        String firstName = name.getFirst();
        String lastName = name.getLast();
        Country nation = getRandomNation(club);
        int rating = rand.nextInt(40, 55);
        LocalDate birthDate = getRandomBirthDate();
        Position position = Position.values()[rand.nextInt(Position.values().length)];
        long marketValue = TransferMarketEngine.getRandomMarketValue();
        Club[] clubsSoFar = new Club[]{club};

        int[] stats = getRandomStats(rating, position);
        if (stats == null) {
            throw new IllegalArgumentException("Error while calculating Random stats (youth player)");
        }
        int talent = 100;

        Player newPlayer = new Player(
                firstName, lastName, nation, rating, birthDate, position,
                marketValue, club, clubsSoFar, stats[0], stats[1], stats[2], talent);

        PlayerCareer career = new PlayerCareer(club, newPlayer, 0);
        newPlayer.addClubToCareer(career);
        PlayerHelper.addPlayer(newPlayer);
        return newPlayer;
    }

    private static Country getRandomNation(Club club) {
        int randNo = rand.nextInt(100);

        //TODO maybe change chance depending on country (f.e. A team from Liechtenstein would have many Swiss players)
        int chanceForHomeCountry = 75;

        if (randNo <= chanceForHomeCountry) {
            return club.getLeague().getCountry();
        } else {
            return Country.values()[rand.nextInt(Country.values().length)];
        }
    }

    private static LocalDate getRandomBirthDate() {
        int minYear = LocalDate.now().getYear() - 19;
        int maxYear = LocalDate.now().getYear() - 15;
        int year = rand.nextInt(minYear, maxYear);

        int month = rand.nextInt(1, 13);

        int day;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            day = rand.nextInt(32);
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            day = rand.nextInt(31);
        } else if (month == 2 && TimeUtils.isLeapYear(year)) {
            day = rand.nextInt(29);
        } else {
            day = rand.nextInt(28);
        }

        return LocalDate.of(year, month, day);
    }

    private static int[] getRandomStats(int rating, Position position) {
        if (rating < 0 || position == null) {
            return null;
        }

        int statSum;
        int att = 0;
        int con = 0;
        int def = 0;
        int minAtt, maxAtt;
        int minCon, maxCon;
        int minDef, maxDef;

        if ((position.getType().equals("ATT") || position.getType().equals("CON")) && !position.equals(Position.CM)) {
            statSum = (int) (rating * 2.5);

            if (position.equals(Position.ST)) {
                minAtt = rating - 2;
                maxAtt = rating + 4;
                att = rand.nextInt(minAtt, maxAtt + 1);
                minCon = (int) (rating * 0.6);
                maxCon = rating;
                con = rand.nextInt(minCon, maxCon + 1);
                def = statSum - att - con;
            }
            if (position.equals(Position.CF)) {
                minAtt = rating - 5;
                maxAtt = rating + 2;
                att = rand.nextInt(minAtt, maxAtt + 1);
                minCon = (int) (rating * 0.7);
                maxCon = rating + 2;
                con = rand.nextInt(minCon, maxCon + 1);
                def = statSum - att - con;
            }
            if (position.equals(Position.LM) || position.equals(Position.RM)
                    || position.equals(Position.LW) || position.equals(Position.RW)
                    || position.equals(Position.CAM)) {
                minAtt = (int) (rating * 0.8);
                maxAtt = rating + 2;
                att = rand.nextInt(minAtt, maxAtt + 1);
                minCon = (int) (rating * 0.8);
                maxCon = rating + 3;
                con = rand.nextInt(minCon, maxCon + 1);
                def = statSum - att - con;
            }
            if (position.equals(Position.CDM)) {
                minAtt = (int) (rating * 0.6);
                maxAtt = (int) (rating * 0.9);
                att = rand.nextInt(minAtt, maxAtt + 1);
                minCon = (int) Math.floor(rating * 0.8);
                maxCon = rating + 2;
                con = rand.nextInt(minCon, maxCon + 1);
                def = statSum - att - con;
            }

        } else if (position.equals(Position.CM) || position.equals(Position.LB) || position.equals(Position.RB)) {
            statSum = (int) (rating * 2.7);
            minAtt = (int) (rating * 0.6);
            maxAtt = rating;
            att = rand.nextInt(minAtt, maxAtt + 1);
            minCon = (int) Math.floor(rating * 0.8);
            maxCon = rating + 2;
            con = rand.nextInt(minCon, maxCon + 1);
            def = statSum - att - con;
        } else if (position.equals(Position.CB)) {
            statSum = (int) (rating * 2.4);
            minDef = rating - 3;
            maxDef = rating + 2;
            def = rand.nextInt(minDef, maxDef + 1);
            minCon = (int) (rating * 0.6);
            maxCon = (int) (rating * 0.8);
            con = rand.nextInt(minCon, maxCon + 1);
            att = statSum - def - con;
        } else if (position.equals(Position.GK)) {
            statSum = (int) (rating * 1.8);
            minDef = rating - 2;
            maxDef = rating + 3;
            def = rand.nextInt(minDef, maxDef + 1);
            con = ((statSum - def) / 2);
            att = statSum - def - con;
        }

        return new int[]{att, con, def};
    }

}
