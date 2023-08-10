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

    public Position getByEnumName(String enumName) {
        if (enumName == null || enumName.trim().isEmpty()) {
            return null;
        }

        for (Position p : Position.values()) {
            if (p.toString().equalsIgnoreCase(enumName)) {
                return p;
            }
        }

        return null;
    }


    public String getFullName() {
        return fullName;
    }

    public String getType() {
        return type;
    }
}
