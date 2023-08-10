package GameObjects;

import enums.Club;

import java.util.List;

public class SaveState {
    //TODO implement (all the important stuff when saving the game is stored here)
    Club currentClub;
    int money;
    List<Player> squad;
    //LeagueTable currentTable;
    // List<Club> jobOffers;

    public SaveState(Club currentClub, int money, List<Player> squad) {
        this.currentClub = currentClub;
        this.money = money;
        this.squad = squad;
        //this.currentTable = currentTable;
        //this.jobOffers = jobOffers;
    }

    public Club getCurrentClub() {
        return currentClub;
    }

    public void setCurrentClub(Club currentClub) {
        this.currentClub = currentClub;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Player> getSquad() {
        return squad;
    }

    public void setSquad(List<Player> squad) {
        this.squad = squad;
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
