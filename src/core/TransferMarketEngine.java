package core;

import GameObjects.Player;
import enums.Club;
import enums.NewsType;
import helper.ClubHelper;
import helper.PlayerHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TransferMarketEngine {
    private static Random rand = new Random(System.nanoTime());
    private static List<Player> playersOnMarket = new ArrayList<>();

    /**
     * Generates a random market value for youth players who join the club.
     * <br>
     * IMPORTANT: Use this method ONLY for youth players!
     *
     * @return randomly generated market value
     */
    public static long getRandomMarketValue() {
        int[] values = new int[]{1_000, 2_000, 5_000, 10_000, 15_000, 20_000, 25_000};
        return values[rand.nextInt(values.length)];
    }

    public static void checkForMarketUpdate() {
        //TODO Decide whether to put players on the market (RNG) (NOT own players)
        Club currentClub = Game.getCurrentClub();

        List<Club> allNpcClubs = ClubHelper.getAllClubs()
                .stream()
                .filter(x -> x != currentClub)
                .toList();

        int chanceForPuttingPlayerOnMarket = 100; //TODO ONLY FOR TESTING, SET VALUE TO 1 LATER!!
        for (Club c : allNpcClubs) {
            if (rand.nextInt(1000) <= chanceForPuttingPlayerOnMarket) {
                List<Player> playersInClub = PlayerHelper.getPlayersForClub(c);
                putPlayerOnMarket(playersInClub.get(rand.nextInt(playersInClub.size())));
            }
        }
    }

    public static void buyPlayer(Player player) {
        if (!isOnMarket(player)) {
            return;
        }

        //TODO buy player (subtract money from own club, add money to selling club, change player's club, update player.getCareer())
    }

    public static List<Player> getPlayersOnMarket() {
        return playersOnMarket;
    }

    // -----   PRIVATE METHODS   -----

    private static void putPlayerOnMarket(Player p) {
        if (p == null || isOnMarket(p)) {
            return;
        }
        playersOnMarket.add(p);
        NewsEngine.createNewsEntry(Game.getCurrentClub(), p, NewsType.TRANSFER, false);
    }

    private static boolean isOnMarket(Player player) {
        if (player == null) {
            return false;
        }

        for (Player p : playersOnMarket) {
            if (p.getId() == player.getId()) {
                return true;
            }
        }
        return false;
    }
}
