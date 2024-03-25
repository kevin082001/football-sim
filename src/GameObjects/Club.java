package GameObjects;

import core.PlayerEngine;
import enums.League;

import java.util.List;

public class Club {
    private String fullName;
    private String displayName;
    private String shortName; //3-letter abbreviation
    private League league;
    private List<Player> squad;
    private Manager manager;
    private long money;

    /**
     * Used to construct pre-generated objects (before the game starts)
     *
     * @param fullName
     * @param displayName
     * @param shortName
     * @param league
     */
    public Club(String fullName, String displayName, String shortName, League league, Manager manager, long money) {
        this.fullName = fullName;
        this.displayName = displayName;
        this.shortName = shortName;
        this.league = league;
        this.squad = PlayerEngine.generateSquad(this); //TODO see todo in PlayerEngine!
        this.manager = manager;
        this.money = money;
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
        this.league = league;
        this.squad = PlayerEngine.generateSquad(this); //TODO see todo in PlayerEngine!
        this.manager = manager;
        this.money = 500_000;
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

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public List<Player> getSquad() {
        return squad;
    }

    public void setSquad(List<Player> squad) {
        this.squad = squad;
    }

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
}
