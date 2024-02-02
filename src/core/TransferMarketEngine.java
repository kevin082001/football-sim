package core;

import java.util.Random;

public class TransferMarketEngine {
    private static Random rand = new Random(System.nanoTime());

    public static long getRandomMarketValue() {
        int[] values = new int[]{2_000, 5_000, 10_000, 15_000, 20_000, 25_000};
        return values[rand.nextInt(values.length)];
    }
}
