package enums;

import java.util.ArrayList;
import java.util.List;

public enum Club {
    BAYERN("Bayern München", League.BUNDESLIGA),
    BVB("Borussia Dortmund", League.BUNDESLIGA),
    LEIPZIG("RB Leipzig", League.BUNDESLIGA),
    SCHALKE("Schalke 04", League.BUNDESLIGA),

    ARGIR("AB Argir", League.BETRIDEILD),
    TOFTIR("B68 Toftir", League.BETRIDEILD),
    STREYMUR("EB/Streymur", League.BETRIDEILD),
    B36("B36 Tórshavn", League.BETRIDEILD),
    KLAKSVIK("KI Klaksvík", League.BETRIDEILD),
    HB("HB Tórshavn", League.BETRIDEILD);


    private final String name;
    private League league;

    Club(String name, League league) {
        this.name = name;
        this.league = league;
    }

    public List<Club> getByLeague(League league) {
        if (league == null) return null;

        List<Club> result = new ArrayList<>();
        for (Club c : Club.values()) {
            if (c.getLeague().equals(league)) {
                result.add(c);
            }
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
}
