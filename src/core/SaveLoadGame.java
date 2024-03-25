package core;

import GameObjects.Player;
import GameObjects.SaveState;
import GameObjects.StaticPlayerData;
import enums.ClubEnum;
import enums.Country;
import enums.Position;
import helper.ClubHelper;
import helper.PlayerHelper;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveLoadGame { //TODO update save/load methods
    private final Path savePath;

    public SaveLoadGame(Path savePath) {
        this.savePath = savePath;
    }

    public void saveGame() { //TODO think about what else is needed when saving
        ClubEnum currentClub = Game.getCurrentClub();
        long money = Game.getMoney();
        List<Player> allPlayers = PlayerHelper.getAllPlayers();
        SaveState saveState = new SaveState(currentClub, money, allPlayers);

        try {
            FileWriter writer = new FileWriter(savePath.toFile());

            writer.write("");
            writer.flush();

            writer.write(saveState.getCurrentClub() + System.lineSeparator());
            writer.write(saveState.getMoney() + System.lineSeparator());

            for (ClubEnum club : ClubHelper.getAllClubs()) {
                System.out.println("Saving: Club " + club.getName());
                for (Player player : PlayerHelper.getPlayersForClub(club)) {
                    writer.write(player.getId() + System.lineSeparator() + player.getNation() + System.lineSeparator()
                            + player.getRating() + System.lineSeparator() + player.getPosition() + System.lineSeparator()
                            + player.getClub() + System.lineSeparator() + PlayerEngine.getClubsSoFarAsString(player.getClubsSoFar())
                            + System.lineSeparator() + player.getAttack() + System.lineSeparator() + player.getControl()
                            + System.lineSeparator() + player.getDefense() + System.lineSeparator() + player.getMatches()
                            + System.lineSeparator() + player.getGoals() + System.lineSeparator()
                            + player.getTalent() + System.lineSeparator());

                    writer.write("###" + System.lineSeparator());
                }
            }

            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public SaveState loadGame() {
        ClubEnum currentClub;
        int money;
        //List<Player> currentSquad;
        List<Player> allPlayers;


        try {
            Scanner fileScanner = new Scanner(savePath.toFile());

            currentClub = ClubEnum.B36.getByEnumName(fileScanner.nextLine());
            money = Integer.parseInt(fileScanner.nextLine());

            allPlayers = new ArrayList<>();

            //boolean checkpointPassed = false;
            while (fileScanner.hasNextLine()) {
                int id = Integer.parseInt(fileScanner.nextLine());

                Country nation = Country.AR.getByEnumName(fileScanner.nextLine());
                int rating = Integer.parseInt(fileScanner.nextLine());
                Position position = Position.CM.getByEnumName(fileScanner.nextLine());
                long marketValue = Long.parseLong(fileScanner.nextLine());
                ClubEnum club = ClubEnum.B36.getByEnumName(fileScanner.nextLine());
                ClubEnum[] clubsSoFar = PlayerEngine.getClubsSoFar(fileScanner.nextLine());
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
                            staticData.getBirthDate(), position, marketValue, club, clubsSoFar, attack, control, defense, talent);
                    player.setMatches(matches);
                    player.setGoals(goals);

                    allPlayers.add(player);
                }
                /*else if(fileScanner.nextLine().equals("$$$$$$$$$$")){
                    checkpointPassed=true;
                }*/
            }
            return new SaveState(currentClub, money, allPlayers);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
