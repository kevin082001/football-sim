package core;

import GameObjects.SaveState;
import enums.Club;
import helper.PrintHelper;

/**
 * This class is only responsible for the game's 'flow'. Processing of data is handled by {@link Engine}
 */
public class Game {
    public void run() {
        Club clubToManage;
        int newOrLoad = PrintHelper.askNewGameOrLoad();

        if (newOrLoad == 1) {
            clubToManage = PrintHelper.printSelectStartClub();
            Engine.initSquad(clubToManage);
        } else {
            SaveState savedGame = Engine.loadGame();
            clubToManage = savedGame.getCurrentClub();
        }

        Engine.initMatchesForSeason(clubToManage);
        Engine.initTable(clubToManage);
        PrintHelper.printHomeMenu();
    }
}
