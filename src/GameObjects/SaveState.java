package GameObjects;

import enums.ClubEnum;

import java.util.List;

public class SaveState {
    //TODO implement (all the important stuff when saving the game is stored here)
    ClubEnum currentClub;
    long money;

    List<Player> allPlayers;

    //LeagueTable currentTable;
    // List<Club> jobOffers;

    public SaveState(ClubEnum currentClub, long money, List<Player> allPlayers) {
        this.currentClub = currentClub;
        this.money = money;
        this.allPlayers=allPlayers;
        //this.currentTable = currentTable;
        //this.jobOffers = jobOffers;
    }

    public ClubEnum getCurrentClub() {
        return currentClub;
    }

    public void setCurrentClub(ClubEnum currentClub) {
        this.currentClub = currentClub;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public List<Player> getAllPlayers() {
        return allPlayers;
    }

    public void setAllPlayers(List<Player> allPlayers) {
        this.allPlayers = allPlayers;
    }

    /*public LeagueTable getCurrentTable() {
        return currentTable;
    }

    public void setCurrentTable(LeagueTable currentTable) {
        this.currentTable = currentTable;
    }

    public List<Club> getJobOffers() {
        return jobOffers;
    }

    public void setJobOffers(List<Club> jobOffers) {
        this.jobOffers = jobOffers;
    }*/
}
