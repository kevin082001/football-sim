package GameObjects;

import enums.Club;
import enums.NewsType;

public class News {
    private Club club;

    private Player player;

    private NewsType type;
    private String message;
    private int age; //Age in in-game days (remove from News page after 10 days)

    private boolean isFollowingClub;

    /**
     * Creates a News object for a club
     *
     * @param club            the club
     * @param type            the News type
     * @param message         The News message
     * @param isFollowingClub whether the user follows the club
     */
    public News(Club club, NewsType type, String message, boolean isFollowingClub) {
        this.club = club;
        this.type = type;
        this.message = message;
        this.age = 0;
        this.isFollowingClub = isFollowingClub;
    }

    /**
     * Creates a News object for a club
     *
     * @param player          the player
     * @param type            the News type
     * @param message         The News message
     * @param isFollowingClub whether the user follows the club where the {@param player} plays
     */
    public News(Player player, NewsType type, String message, boolean isFollowingClub) {
        this.player = player;
        this.type = type;
        this.message = message;
        this.age = 0;
        this.isFollowingClub = isFollowingClub;
    }

    public Club getClub() {
        return club;
    }

    public NewsType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFollowingClub() {
        return isFollowingClub;
    }

    public void setFollowingClub(boolean isFollowingClub) {
        this.isFollowingClub = isFollowingClub;
    }
}
