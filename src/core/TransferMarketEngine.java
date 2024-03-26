package core;

import GameObjects.Club;
import GameObjects.Player;
import GameObjects.PlayerCareer;
import helper.ArrayHelper;
import helper.ClubHelper;
import helper.PlayerHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TransferMarketEngine {
    private static Random rand = new Random(System.nanoTime());
    private static Map<Player, Long> playersOnMarket = new HashMap<>(); //Key: Player, Value: transfer cost (rougly market value)

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

    private static long getRandomTransferCost(Player p) { //TODO possibly rework the cost calculation
        if (p == null) {
            return -1;
        }

        long marketValue = p.getMarketValue();

        long minCost = (long) (marketValue * 0.6);
        long maxCost = (long) (marketValue * 2.5);

        return rand.nextLong(minCost, maxCost + 1);
    }

    public static void checkForMarketUpdate() {
        Club currentClub = Game.getCurrentClub();

        List<Club> allNpcClubs = ClubHelper.getAllClubs()
                .stream()
                .filter(x -> x != currentClub)
                .toList();

        for (Club c : allNpcClubs) {
            int chanceForPuttingPlayerOnMarket = 800; //TODO ONLY FOR TESTING, SET VALUE TO 1 LATER!!
            if (rand.nextInt(1000) <= chanceForPuttingPlayerOnMarket) {
                List<Player> playersInClub = PlayerHelper.getPlayersForClub(c);

                if (!playersInClub.isEmpty()) {
                    putPlayerOnMarket(playersInClub.get(rand.nextInt(playersInClub.size())));
                }
            }
        }
    }

    public static void buyPlayer(Player player) {
        if (!isOnMarket(player)) {
            return;
        }

        //TODO buy player (subtract money from own club, add money to selling club, change player's club, update player.getCareer())
        long cost = playersOnMarket.get(player);
        Game.getCurrentClub().setMoney(Game.getCurrentClub().getMoney() - cost);
        player.setClub(Game.getCurrentClub());
        Club[] clubsSoFar = ArrayHelper.extend(player.getClubsSoFar());
        clubsSoFar[clubsSoFar.length - 1] = player.getClub();
        PlayerCareer[] career = player.getCareer();
        career = ArrayHelper.extend(career);

        //TODO also update career of last club (highestMarketValue,...)
        career[career.length - 1] = new PlayerCareer(Game.getCurrentClub(), player, cost);
    }

    public static Map<Player, Long> getPlayersOnMarket() {
        return playersOnMarket;
    }

    public static boolean canBuyPlayer(Player p, long money) {
        if (p == null || money < 1) {
            return false;
        }

        for (Player player : playersOnMarket.keySet()) {
            if (player.equals(p)) {
                return money >= playersOnMarket.get(p);
            }
        }

        return false;
    }

    // -----   PRIVATE METHODS   -----

    private static void putPlayerOnMarket(Player p) {
        if (p == null || isOnMarket(p)) {
            return;
        }

        Long transferCost = getRandomTransferCost(p);
        playersOnMarket.put(p, transferCost);
    }

    private static boolean isOnMarket(Player player) {
        if (player == null) {
            return false;
        }

        for (Player p : playersOnMarket.keySet()) {
            if (p.getId() == player.getId()) {
                return true;
            }
        }
        return false;
    }
}
