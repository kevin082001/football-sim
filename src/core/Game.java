package core;

import GameObjects.Club;
import GameObjects.News;
import GameObjects.SaveState;
import helper.PlayerHelper;
import helper.PrintHelper;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final Path savePath = FileSystems.getDefault().getPath(".", "savegame.txt");
    private static int currentSeason = 0;
    private static List<News> news = new ArrayList<>();
    //private static long money = 500_000; //TODO instead of having a class variable, use currentClub.getMoney()
    private static Club currentClub;

    public static void run() {
        initAllPlayers();
        int newOrLoad = PrintHelper.askNewGameOrLoad();

        if (newOrLoad == 1) {
            currentClub = PrintHelper.printSelectStartClub();
            ClubEngine.initSquad(currentClub);
        } else {
            SaveLoadGame slg = new SaveLoadGame(savePath);
            SaveState savedGame = slg.loadGame();
            currentClub = savedGame.getCurrentClub();
        }
        while (true) {
            MatchEngine.initMatchesForSeason(currentClub);
            SeasonEngine.initTable(currentClub);
            PrintHelper.printHomeMenu();

            //TODO if all matches of the season are played, end the season
            SeasonEngine.endCurrentSeason(currentSeason);
            currentSeason++;
            SeasonEngine.startNewSeason(currentSeason);
        }
    }

    public static Club getCurrentClub() {
        return currentClub;
    }

    public static void setCurrentClub(Club club) {
        currentClub = club;
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

    private static void initAllPlayers() {
        PlayerHelper.getAllPlayers();
    }
}
