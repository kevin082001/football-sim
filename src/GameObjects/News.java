package GameObjects;

import enums.Club;

public class News {
    private Club club;
    private String message;
    private int age; //Age in in-game days (remove from News page after 10 days)

    private boolean isFollowingClub;

    public News(Club club, String message) {
        this.club = club;
        this.message = message;
        this.age = 0;
    }

    public Club getClub() {
        return club;
    }

    public String getMessage() {
        return message;
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
