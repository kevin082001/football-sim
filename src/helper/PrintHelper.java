package helper;

import GameObjects.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PrintHelper {
    public static int askNewGameOrLoad(Scanner sc) {
        System.out.println("1) New Game");
        System.out.println("2) Load Game");
        System.out.println();
        System.out.print(">>");
        int choice = sc.nextInt();
        if (choice < 1 || choice > 2) {
            System.out.println("Invalid input\n\n\n\n\n\n\n\n\n\n");
            askNewGameOrLoad(sc);
        }
        return choice;
    }

    public static String getSpacesForTable(int ranking, String clubName) {
        int spacesRemaining = 22;
        spacesRemaining -= String.valueOf(ranking).length();
        spacesRemaining -= clubName.length();

        String spaces = "";
        while (spacesRemaining-- > 0) {
            spaces += " ";
        }
        return spaces;
    }

    public static void printGoalsList(Map<Player, List<Integer>> scorers) {
        System.out.println("\n\nGOALS:");
        for (int minute = 0; minute <= 120; minute++) { //Think whether 120 is enough as the maximum amount of minutes
            for (Player p : scorers.keySet()) {
                for (Integer min : scorers.get(p)) {
                    if (min.equals(minute)) {
                        System.out.println(p.getLastName() + " (" + min + "')");
                    }
                }
            }
        }

        /*for (Player p : scorers.keySet()) {
            System.out.println(p.getLastName() + scorers.get(p));
        }*/
    }
}
