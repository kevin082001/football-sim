package GameObjects;

import enums.Club;

public class Match {
    private Club home;
    private Club away;
    private Score score;

    public Match(Club home, Club away, Score score) {
        this.home = home;
        this.away = away;
        this.score = score;
    }

    public Club getHome() {
        return home;
    }

    public void setHome(Club home) {
        this.home = home;
    }

    public Club getAway() {
        return away;
    }

    public void setAway(Club away) {
        this.away = away;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
