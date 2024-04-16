package GameObjects;

public class Club {
    private String fullName;
    private String displayName;
    private String shortName; //3-letter abbreviation
    //private String internalName; //only used in code
    private League league;
    private Manager manager;
    private long money;
    private final boolean custom; //"true" if created via "Create custom club"

    /**
     * Used to construct pre-generated objects (before the game starts)
     *
     * @param fullName The full (long) name of the club
     * @param displayName The name which is displayed most of the time throughout the game
     * @param shortName The 'code name' of the club (f.e. FCB for FC Bayern or RMA for Real Madrid)
     * @param league The league the club is in
     */
    public Club(String fullName, String displayName, String shortName, League league, Manager manager, long money) {
        this.fullName = fullName;
        this.displayName = displayName;
        this.shortName = shortName;
        //this.internalName = internalName;
        this.league = league;
        //this.squad = PlayerEngine.generateSquad(this); //TODO see todo in PlayerEngine!
        this.manager = manager;
        this.money = money;
        this.custom = false;
    }

    /**
     * Used to construct objects when feature 'create custom club' is used.
     * <br>
     * The squad is generated randomly (Starting XI + 12 reserve)
     *
     * @param displayName
     */
    public Club(String displayName, League league, Manager manager) {
        this.fullName = displayName;
        this.displayName = displayName;
        this.shortName = getShortName(displayName);
        //this.internalName = displayName;
        this.league = league;
        //this.squad = PlayerEngine.generateSquad(this); //TODO see todo in PlayerEngine!
        this.manager = manager;
        this.money = 500_000;
        this.custom = true;
    }


    private String getShortName(String displayName) {
        if (displayName == null || displayName.trim().isEmpty()) {
            return null;
        }
        if (displayName.length() < 3) {
            return displayName.toUpperCase();
        }
        return displayName.substring(0, 3).toUpperCase();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /*public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }*/

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    /*public List<Player> getSquad() {
        return squad;
    }

    public void setSquad(List<Player> squad) {
        this.squad = squad;
    }*/

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public boolean isCustom() {
        return custom;
    }
}
