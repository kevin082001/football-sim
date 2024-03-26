package helper;

import GameObjects.Club;
import GameObjects.Player;
import GameObjects.PlayerCareer;

public class ArrayHelper {
    public static Club[] extend(Club[] array) {
        Club[] newArray = new Club[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    public static PlayerCareer[] extend(PlayerCareer[] array) {
        PlayerCareer[] newArray = new PlayerCareer[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    public static Player[] extend(Player[] array) {
        Player[] newArray = new Player[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
}
