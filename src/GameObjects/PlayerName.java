package GameObjects;

public class PlayerName {
    private final String first;
    private final String last;

    public PlayerName(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }
}
