package helper;

import GameObjects.*;
import enums.Club;
import enums.Country;
import enums.League;
import enums.Position;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.*;

public class GameLogic {
    //private static Club currentClub;
    //private static List<Match> matches = new ArrayList<>();
    private final static Random rand = new Random(System.nanoTime());

    private final static Path savePath = FileSystems.getDefault().getPath(".", "savegame.txt");

    private static LeagueTable table;

    private static List<Player> currentSquad;

    public static void initSquad(Club club) {
        currentSquad = new ArrayList<>();
        currentSquad.addAll(PlayerHelper.getPlayersForClub(club));
    }

    public static void updateSquad(Player toRemove, Player toAdd, Player toUpdate) {
        if (toAdd != null) {
            currentSquad.add(toAdd);
        }

        for (int i = 0; i < currentSquad.size(); i++) {
            if (currentSquad.get(i).equals(toRemove)) {
                currentSquad.remove(i);
            } else if (currentSquad.get(i).equals(toUpdate)) {
                currentSquad.set(i, toUpdate);
            }
        }
    }

    public static List<Player> getCurrentSquad() {
        return currentSquad;
    }

    public static List<Match> initMatchesForSeason(Club club) {
        List<Match> result = new ArrayList<>();

        League league = club.getLeague();
        List<Club> clubsInLeague = ClubHelper.getClubsForLeague(league);

        for (int homeIndex = 0; homeIndex < clubsInLeague.size(); homeIndex++) {
            for (int awayIndex = homeIndex; awayIndex < clubsInLeague.size(); awayIndex++) {
                if (clubsInLeague.get(homeIndex).equals(clubsInLeague.get(awayIndex))) {
                    continue;
                }
                result.add(new Match(clubsInLeague.get(homeIndex), clubsInLeague.get(awayIndex), null));
                result.add(new Match(clubsInLeague.get(awayIndex), clubsInLeague.get(homeIndex), null));
            }
        }

        return shuffleMatches(result);
    }

    public static Match getNextMatch(Club club, List<Match> matchesThisSeason) {
        for (Match m : matchesThisSeason) {
            if (m.getScore() != null) {
                continue;
            }
            if (m.getHome().equals(club) || m.getAway().equals(club)) {
                return m;
            }
        }
        return null;
    }

    public static void initTable(Club club) {
        League league = club.getLeague();

        table = new LeagueTable(league, new HashMap<>());
        for (Club c : ClubHelper.getClubsForLeague(league)) {
            table.getPoints().put(c, 0);
        }
    }

    public static void updateTable(List<Match> round) {
        League league = round.get(0).getHome().getLeague();
        for (Match m : round) {
            Club home = m.getHome();
            Club away = m.getAway();
            Integer homePoints = table.getPoints().get(home);
            Integer awayPoints = table.getPoints().get(away);
            if (m.getWinner() == null) {
                table.getPoints().put(home, homePoints + 1);
                table.getPoints().put(away, awayPoints + 1);
            } else if (m.getWinner().equals(home)) {
                table.getPoints().put(home, homePoints + 3);
            } else if (m.getWinner().equals(away)) {
                table.getPoints().put(away, awayPoints + 3);
            }
        }
        sortTable(league);
    }

    public static LeagueTable getTable() {
        return table;
    }

    private static List<Match> shuffleMatches(List<Match> toShuffle) {
        List<Match> shuffled = new ArrayList<>();

        while (!toShuffle.isEmpty()) {
            Match m = toShuffle.get(rand.nextInt(toShuffle.size()));
            shuffled.add(m);
            toShuffle.remove(m);
        }
        return shuffled;
    }

    private static void sortTable(League league) { //TODO not sure if this method works as intended
        LeagueTable sorted = new LeagueTable(league, null);
        LeagueTable tmp = sorted;
        Integer highest = 0;

        while (!tmp.getPoints().isEmpty()) {
            Club best = null;
            for (Club c : table.getPoints().keySet()) {
                if (table.getPoints().get(c) > highest) {
                    highest = table.getPoints().get(c);
                    best = c;
                }
            }
            sorted.getPoints().put(best, highest);
            tmp.getPoints().remove(best);
        }
    }

    public static void saveGame(Club currentClub, int money) { //TODO think about what else is needed when saving
        SaveState saveState = new SaveState(currentClub, money, currentSquad);

        try {
            FileWriter writer = new FileWriter(savePath.toFile());

            writer.write("");
            writer.flush();

            writer.write(saveState.getCurrentClub() + System.lineSeparator());
            writer.write(saveState.getMoney() + System.lineSeparator());
            for (Player player : currentSquad) {
                writer.write(player.getId() + System.lineSeparator() + player.getNation() + System.lineSeparator()
                        + player.getRating() + System.lineSeparator() + player.getPosition() + System.lineSeparator()
                        + player.getClub() + System.lineSeparator() + getClubsSoFarAsString(player.getClubsSoFar())
                        + System.lineSeparator() + player.getAttack() + System.lineSeparator() + player.getControl()
                        + System.lineSeparator() + player.getDefense() + System.lineSeparator() + player.getMatches()
                        + System.lineSeparator() + player.getGoals() + System.lineSeparator()
                        + player.getTalent() + System.lineSeparator());

                writer.write("###" + System.lineSeparator());
            }
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static SaveState loadGame() {
        Club currentClub;
        int money;
        List<Player> currentSquad;

        try {
            Scanner fileScanner = new Scanner(savePath.toFile());

            currentClub = Club.B36.getByEnumName(fileScanner.nextLine());
            money = Integer.parseInt(fileScanner.nextLine());

            currentSquad = new ArrayList<>();
            while (fileScanner.hasNextLine()) {
                int id = Integer.parseInt(fileScanner.nextLine());

                Country nation = Country.AR.getByEnumName(fileScanner.nextLine());
                int rating = Integer.parseInt(fileScanner.nextLine());
                Position position = Position.CM.getByEnumName(fileScanner.nextLine());
                Club club = Club.B36.getByEnumName(fileScanner.nextLine());
                Club[] clubsSoFar = getClubsSoFar(fileScanner.nextLine());
                int attack = Integer.parseInt(fileScanner.nextLine());
                int control = Integer.parseInt(fileScanner.nextLine());
                int defense = Integer.parseInt(fileScanner.nextLine());
                int matches = Integer.parseInt(fileScanner.nextLine());
                int goals = Integer.parseInt(fileScanner.nextLine());
                int talent = Integer.parseInt(fileScanner.nextLine());


                if (fileScanner.nextLine().equals("###")) {
                    StaticPlayerData staticData = PlayerHelper.getStaticPlayerData(id);
                    if (staticData == null) {
                        throw new RuntimeException("Something went wrong while reading player data (PlayerID: " + id + ")");
                    }
                    Player player = new Player(id, staticData.getFirstName(), staticData.getLastName(), nation, rating,
                            staticData.getBirthDate(), position, club, clubsSoFar, attack, control, defense, talent);
                    player.setMatches(matches);
                    player.setGoals(goals);

                    currentSquad.add(player);
                }
            }
            return new SaveState(currentClub, money, currentSquad);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    // ------- PRIVATE METHODS -------

    private static String getClubsSoFarAsString(Club[] clubsSoFar) {
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

    private static Club[] getClubsSoFar(String asString) {
        Club[] clubsSoFar = new Club[0];
        String[] clubsSeparated = asString.split(",");

        for (int i = 0; i < clubsSeparated.length; i++) {
            clubsSoFar = extend(clubsSoFar);
            clubsSoFar[clubsSoFar.length - 1] = Club.B36.getByEnumName(clubsSeparated[i]);
        }

        return clubsSoFar;
    }

    private static Club[] extend(Club[] array) {
        Club[] newArray = new Club[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
}
