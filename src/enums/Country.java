package enums;

public enum Country {
    AT("Austria"),
    BE("Belgium"),
    CA("Canada"),
    CH("Switzerland"),
    CN("China"),
    CZ("Czech Republic"),
    DE("Germany"),
    DK("Denmark"),
    EE("Estonia"),
    ENG("England"),
    ES("Spain"),
    FI("Finland"),
    FO("Faroe Islands"),
    FR("France"),
    GB("Great Britain"),
    GL("Greenland"),
    HR("Croatia"),
    HU("Hungary"),
    IE("Ireland"),
    IS("Iceland"),
    IT("Italy"),
    JP("Japan"),
    LI("Liechtenstein"),
    LT("Lithuania"),
    LU("Luxembourg"),
    LV("Latvia"),
    NL("Netherlands"),
    NO("Norway"),
    NOR("Northern Ireland"),
    PL("Poland"),
    PT("Portugal"),
    RU("Russia"),
    SCO("Scotland"),
    SE("Sweden"),
    UA("Ukraine"),
    US("United States"),
    WAL("Wales");

    private final String name;

    Country(String name) {
        this.name = name;
    }

    public Country getByName(String name) {
        if (name == null || name.equals("")) return null;

        for (Country c : Country.values()) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
