package core;

import GameObjects.News;
import GameObjects.SaveState;
import enums.Club;
import helper.PrintHelper;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Path savePath = FileSystems.getDefault().getPath(".", "savegame.txt");
    private int currentSeason = 0;
    private List<News> news = new ArrayList<>();
    private long money = 500_000;

    public void run() {
        while (true) {
            Club clubToManage;
            int newOrLoad = PrintHelper.askNewGameOrLoad();

            if (newOrLoad == 1) {
                clubToManage = PrintHelper.printSelectStartClub();
                Engine.initSquad(clubToManage);
            } else {
                SaveLoadGame slg = new SaveLoadGame(savePath);
                SaveState savedGame = slg.loadGame();
                clubToManage = savedGame.getCurrentClub();
            }

            Engine.initMatchesForSeason(clubToManage);
            Engine.initTable(clubToManage);
            PrintHelper.printHomeMenu(clubToManage, money, news, savePath);

            //TODO if all matches of the season are played, end the season
            Engine.endCurrentSeason(currentSeason);
            currentSeason++;
            Engine.startNewSeason(currentSeason);
        }
    }
}
