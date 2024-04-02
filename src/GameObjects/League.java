package GameObjects;

import enums.Country;

public class League {
    private String fullName;
    private String displayName;
    private String internalName;
    private Country country;
    private int tier;
    private boolean playable;

    public League(String fullName, String displayName, String internalName, Country country, int tier, boolean playable) {
        this.fullName = fullName;
        this.displayName = displayName;
        this.internalName = internalName;
        this.country = country;
        this.tier = tier;
        this.playable = playable;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getInternalName() {
        return internalName;
    }

    public Country getCountry() {
        return country;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public boolean isPlayable() {
        return playable;
    }
}
