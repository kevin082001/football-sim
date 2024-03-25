package GameObjects;

import enums.ClubEnum;
import enums.League;

import java.util.Map;

public class LeagueTable {
    League league;
    Map<ClubEnum, Integer> points;

    public LeagueTable(League league, Map<ClubEnum, Integer> points) {
        this.league = league;
        this.points = points;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Map<ClubEnum, Integer> getPoints() {
        return points;
    }

    public void setPoints(Map<ClubEnum, Integer> points) {
        this.points = points;
    }
}
