package GameObjects;

import enums.Club;
import enums.League;

import java.util.List;

public class SaveState {
    //TODO implement (all the important stuff when saving the game is stored here)
    Club currentClub;
    int money;
    //List<Player> currentSquad;

    List<Player> allPlayers;

    //LeagueTable currentTable;
    // List<Club> jobOffers;

    public SaveState(Club currentClub, int money, List<Player> allPlayers) {
        this.currentClub = currentClub;
        this.money = money;
        //this.currentSquad = squad;
        this.allPlayers=allPlayers;
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

    /*public List<Player> getCurrentSquad() {
        return currentSquad;
    }

    public void setCurrentSquad(List<Player> currentSquad) {
        this.currentSquad = currentSquad;
    }*/

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
