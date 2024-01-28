import GameObjects.PlayerName;
import core.Game;
import helper.NameGenerator;

public class Main { //TODO implement: international cups (UEL, UCL, ...), more leagues, WC and EC

    public static void main(String[] args) {
        //randomNameTest();

        Game game = new Game();
        game.run();
    }

    private static void randomNameTest() {
        NameGenerator ng = new NameGenerator();
        for (int i = 0; i < 30; i++) {
            PlayerName name = ng.getRandomName();
            System.out.println(i + ": " + name.getFirst() + " " + name.getLast());
        }

        System.exit(666);
    }
}