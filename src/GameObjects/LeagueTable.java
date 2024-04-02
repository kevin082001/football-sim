package GameObjects;

import java.util.Map;

public class LeagueTable {
    League league;
    Map<Club, Integer> points;

    public LeagueTable(League league, Map<Club, Integer> points) {
        this.league = league;
        this.points = points;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Map<Club, Integer> getPoints() {
        return points;
    }

    public void setPoints(Map<Club, Integer> points) {
        this.points = points;
    }
}
