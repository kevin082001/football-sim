package core;

import GameObjects.Player;
import GameObjects.PlayerCareer;
import enums.Club;
import enums.Country;
import helper.ArrayHelper;
import helper.ClubHelper;
import helper.PlayerHelper;

import java.util.*;

public class TransferMarketEngine {
    private static Random rand = new Random(System.nanoTime());
    private static Map<Player, Long> playersOnMarket = new HashMap<>(); //Key: Player, Value: transfer cost

    private static Map<Club, Long> clubsWithMoney = ClubHelper.initClubsWithAccountBalance();

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

    private static long getRandomTransferCost(Player p) { //TODO possibly rework the cost calculation (according to current form etc)
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
            int chanceForPuttingPlayerOnMarket = 500; //TODO ONLY FOR TESTING, SET VALUE TO 1 LATER!!
            int chanceForBuyingPlayer = 50; //TODO ONLY FOR TESTING, SET VALUE TO  1 LATER!!

            if (rand.nextInt(1000) <= chanceForPuttingPlayerOnMarket) {
                List<Player> playersInClub = PlayerHelper.getPlayersForClub(c);

                if (!playersInClub.isEmpty()) {
                    putPlayerOnMarket(playersInClub.get(rand.nextInt(playersInClub.size())));
                }
            }

            if (rand.nextInt(1000) <= chanceForBuyingPlayer) {
                List<Player> playersInClub = PlayerHelper.getPlayersForClub(c);

                //Only allow purchases for clubs that have less than 30 players
                if (playersInClub.size() < 30) {
                    buyPlayer(PlayerHelper.getRandomPlayer(playersOnMarket.keySet().stream().toList(), true), c);
                }
            }
        }
    }

    /**
     * Tries to buy a player from the market
     *
     * @param player     the player to buy
     * @param buyingClub the club that's buying the player
     * @return whether the purchase was successful
     */
    public static boolean buyPlayer(Player player, Club buyingClub) {
        if (!isOnMarket(player) || buyingClub == null || player.getClub().equals(buyingClub)
            //!! Only commented out for testing purposes !!
            /*|| PlayerHelper.getPlayersForClub(player.getClub()).size() <= 11*/) {
            return false;
        }

        long cost = playersOnMarket.get(player);
        long sellingClubMoney = clubsWithMoney.get(player.getClub());
        clubsWithMoney.put(player.getClub(), sellingClubMoney + cost);

        player.setClub(buyingClub);
        Club[] clubsSoFar = ArrayHelper.extend(player.getClubsSoFar());
        clubsSoFar[clubsSoFar.length - 1] = player.getClub();
        PlayerCareer[] career = player.getCareer();
        career = ArrayHelper.extend(career);

        //TODO also update career of last club (highestMarketValue,...)
        career[career.length - 1] = new PlayerCareer(buyingClub, player, cost);

        if (buyingClub.equals(Game.getCurrentClub())) {
            Game.setMoney(Game.getMoney() - cost);
        } else {
            clubsWithMoney.put(buyingClub, clubsWithMoney.get(buyingClub) - cost);
        }

        playersOnMarket.remove(player);
        return true;
    }

    public static void sellPlayer(Player player, long transferCost) {
        putPlayerOnMarket(player, transferCost);
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

    public static Map<Player, Long> getPlayersByName(String name) {
        //TODO Improve search (the more the name matches, the higher up in the list the player is in the search results)

        if (name == null || name.trim().isEmpty()) {
            return null;
        }

        Map<Player, Long> result = new HashMap<>();
        for (Player p : playersOnMarket.keySet()) {
            if (p.getFirstName().toLowerCase().contains(name.toLowerCase())
                    || p.getLastName().toLowerCase().contains(name.toLowerCase())) {
                result.put(p, playersOnMarket.get(p));
            }
        }

        return result;
    }

    /*public static List<Player> getPlayersByName(String name, List<Player> searchList) {
        if (name == null || name.trim().isEmpty() || searchList == null || searchList.isEmpty()) {
            return null;
        }

        List<Player> result = new ArrayList<>();
        for (Player p : searchList) {
            if (p.getFirstName().toLowerCase().contains(name.toLowerCase())
                    || p.getLastName().toLowerCase().contains(name.toLowerCase())) {
                result.add(p);
            }
        }

        return result;
    }*/

    public static Map<Player, Long> getPlayersForNation(Country nation) {
        if (nation == null) {
            return null;
        }

        Map<Player, Long> result = new HashMap<>();
        for (Player p : playersOnMarket.keySet()) {
            if (p.getNation().equals(nation)) {
                result.put(p, playersOnMarket.get(p));
            }
        }

        return result;
    }

    /*public static List<Player> getPlayersForNation(Country nation, List<Player> searchList) {
        if (nation == null || searchList == null || searchList.isEmpty()) {
            return null;
        }

        List<Player> result = new ArrayList<>();
        for (Player p : searchList) {
            if (p.getNation().equals(nation)) {
                result.add(p);
            }
        }

        return result;
    }*/

    public static Map<Player, Long> getPlayersForRating(int rating) {
        if (rating <= 0) {
            return null;
        }

        Map<Player, Long> result = new HashMap<>();
        for (Player p : playersOnMarket.keySet()) {
            if (p.getRating() == rating) {
                result.put(p, playersOnMarket.get(p));
            }
        }

        return result;
    }

    /*public static List<Player> getPlayersForRating(int rating, List<Player> searchList) {
        if (rating <= 0 || searchList == null || searchList.isEmpty()) {
            return null;
        }

        List<Player> result = new ArrayList<>();
        for (Player p : searchList) {
            if (p.getRating() == rating) {
                result.add(p);
            }
        }

        return result;
    }*/

    // -----   PRIVATE METHODS   -----

    /**
     * Puts a player on the transfer market. Also randomly generates the player's transfer cost
     *
     * @param p The player to put on the market
     */
    private static void putPlayerOnMarket(Player p) {
        if (p == null || isOnMarket(p)) {
            return;
        }

        Long transferCost = getRandomTransferCost(p);
        playersOnMarket.put(p, transferCost);
    }

    /**
     * Puts a player on the transfer market.
     *
     * @param p            The player to put on the market
     * @param transferCost The cost at which the player is put on the market
     */
    private static void putPlayerOnMarket(Player p, long transferCost) {
        if (p == null || isOnMarket(p)) {
            return;
        }

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
