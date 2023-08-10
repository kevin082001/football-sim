package helper;

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
}
