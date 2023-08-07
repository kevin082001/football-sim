package helper;

import GameObjects.LeagueTable;
import GameObjects.Match;
import GameObjects.Player;
import GameObjects.SaveState;
import enums.Club;
import enums.League;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystem;
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
        SaveState saveState = new SaveState(currentClub, money, currentSquad, table);

        //TODO implement (research how to write/read to/from files)
        try {
            FileWriter writer = new FileWriter(savePath.toFile());

            writer.write("");
            writer.flush();

            writer.write(saveState.getCurrentClub().getName() + System.lineSeparator());
            writer.write(saveState.getMoney() + System.lineSeparator());
            for (Player player : currentSquad) {
                //TODO write method to get non-changing data for a player (firstname, birthdate,...)
                writer.write(player.getFirstName() + System.lineSeparator() + player.getLastName() + System.lineSeparator() + player.getNation()
                        + System.lineSeparator() + player.getRating() + System.lineSeparator() + player.getBirthDate() + System.lineSeparator()
                        + player.getPosition() + System.lineSeparator() + player.getClub().getName() + System.lineSeparator()
                        + getClubsSoFarAsString(player.getClubsSoFar()) + System.lineSeparator() + player.getAttack() + System.lineSeparator()
                        + player.getControl() + System.lineSeparator() + player.getDefense() + System.lineSeparator() + player.getMatches()
                        + System.lineSeparator() + player.getGoals() + System.lineSeparator() + player.getTalent() + System.lineSeparator());
                writer.write("###" + System.lineSeparator());
            }
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static SaveState loadGame() {
        //TODO implement
        return null;
    }

    private static String getClubsSoFarAsString(Club[] clubsSoFar) {
        if (clubsSoFar.length == 1) {
            return clubsSoFar[0].getName();
        }

        String result = "";
        for (int i = 0; i < clubsSoFar.length - 1; i++) {
            result += clubsSoFar[i] + ",";
        }

        result += clubsSoFar[clubsSoFar.length - 1];
        return result;
    }
}
