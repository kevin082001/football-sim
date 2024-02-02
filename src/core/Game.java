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
    private static final Path savePath = FileSystems.getDefault().getPath(".", "savegame.txt");
    private static int currentSeason = 0;
    private static List<News> news = new ArrayList<>();
    private static long money = 500_000;
    private static Club currentClub;

    public static void run() {
        int newOrLoad = PrintHelper.askNewGameOrLoad();

        if (newOrLoad == 1) {
            currentClub = PrintHelper.printSelectStartClub();
            Engine.initSquad(currentClub);
        } else {
            SaveLoadGame slg = new SaveLoadGame(savePath);
            SaveState savedGame = slg.loadGame();
            currentClub = savedGame.getCurrentClub();
        }
        while (true) {
            Engine.initMatchesForSeason(currentClub);
            Engine.initTable(currentClub);
            PrintHelper.printHomeMenu();

            //TODO if all matches of the season are played, end the season
            Engine.endCurrentSeason(currentSeason);
            currentSeason++;
            Engine.startNewSeason(currentSeason);
        }
    }

    public static long getMoney() {
        return money;
    }

    public static Club getCurrentClub() {
        return currentClub;
    }

    public static List<News> getNews() {
        return news;
    }

    public static void addToNews(News entry) {
        if (entry == null || (entry.getClub() == null && entry.getPlayer() == null)) {
            return;
        }
        news.add(entry);
    }

    public static Path getSavePath() {
        return savePath;
    }
}
