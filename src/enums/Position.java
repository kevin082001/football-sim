package enums;

import java.util.ArrayList;
import java.util.List;

public enum Position {
    GK("Goalkeeper", "DEF"),
    LB("Left back", "DEF"),
    CB("Central back", "DEF"),
    RB("Right back", "DEF"),
    CDM("Central Defensive Midfield", "CON"),
    CM("Central Midfield", "CON"),
    CAM("Central Attacking Midfield", "CON"),
    LM("Left Midfield", "CON"),
    RM("Right Midfield", "CON"),
    LW("Left Wing", "ATT"),
    CF("Central Forward", "ATT"),
    ST("Striker", "ATT"),
    RW("Right Wing", "ATT");

    private final String fullName;
    private final String type;

    Position(String fullName, String type) {
        this.fullName = fullName;
        this.type = type;
    }

    public List<Position> getByType(String type) {
        List<Position> result = new ArrayList<>();
        for (Position p : Position.values()) {
            if (p.getType().equalsIgnoreCase(type)) {
                result.add(p);
            }
        }
        return result;
    }

    public String getFullName() {
        return fullName;
    }

    public String getType() {
        return type;
    }
}
