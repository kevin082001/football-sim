package core;

import GameObjects.Player;
import enums.Club;
import helper.PlayerHelper;

import java.util.ArrayList;
import java.util.List;

public class ClubEngine {
    private static List<Player> currentSquad;

    /**
     * Initializes the squad of the currently managed club
     * @param club The currently managed club
     */
    public static void initSquad(Club club) {
        currentSquad = new ArrayList<>();
        currentSquad.addAll(PlayerHelper.getPlayersForClub(club));
    }

    /**
     * Updates the squad of your current club
     * @param toRemove A player to remove from the squad
     * @param toAdd A player to add to the squad
     * @param toUpdate A player in the squad to be updated
     */
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
}
