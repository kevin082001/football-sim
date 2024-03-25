package GameObjects;

import enums.ClubEnum;

public class Match {
    private ClubEnum home;
    private ClubEnum away;
    private Score score;

    public Match(ClubEnum home, ClubEnum away, Score score) {
        this.home = home;
        this.away = away;
        this.score = score;
    }

    public ClubEnum getHome() {
        return home;
    }

    public void setHome(ClubEnum home) {
        this.home = home;
    }

    public ClubEnum getAway() {
        return away;
    }

    public void setAway(ClubEnum away) {
        this.away = away;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public ClubEnum getWinner() {
        return score == null || score.getScoreHome() == score.getScoreAway() ? null :
                score.getScoreHome() > score.getScoreAway() ? home : away;
    }
}
