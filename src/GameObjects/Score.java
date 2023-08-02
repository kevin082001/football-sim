package GameObjects;

import java.util.Map;

public class Score {
    private int scoreHome;
    private int scoreAway;
    private Map<Player, Integer> scorers;

    public Score(int scoreHome, int scoreAway, Map<Player, Integer> scorers) {
        this.scoreHome = scoreHome;
        this.scoreAway = scoreAway;
        this.scorers = scorers;
    }

    public int getScoreHome() {
        return scoreHome;
    }

    public void setScoreHome(int scoreHome) {
        this.scoreHome = scoreHome;
    }

    public int getScoreAway() {
        return scoreAway;
    }

    public void setScoreAway(int scoreAway) {
        this.scoreAway = scoreAway;
    }

    public Map<Player, Integer> getScorers() {
        return scorers;
    }

    public void setScorers(Map<Player, Integer> scorers) {
        this.scorers = scorers;
    }
}
