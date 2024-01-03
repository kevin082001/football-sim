package helper;

import enums.Club;

public class ArrayHelper {
    public static Club[] extend(Club[] array) {
        Club[] newArray = new Club[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
}
