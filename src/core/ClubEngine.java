package core;

import GameObjects.Player;
import enums.ClubEnum;
import helper.PlayerHelper;

import java.util.ArrayList;
import java.util.List;

public class ClubEngine {
    private static List<Player> currentSquad;

    public static void initSquad(ClubEnum club) {
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
}
