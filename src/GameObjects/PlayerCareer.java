package GameObjects;

import enums.Club;

import java.time.LocalDate;

public class PlayerCareer {
    //TODO Add: loans, transferCost

    private Club club;
    private Player player;

    private long transferCost;

    private long highestMarketValue;
    private LocalDate from;
    private LocalDate until;
    private int games;
    private int goals;

    //For already existing players
    public PlayerCareer(Club club, Player player, long transferCost, long highestMarketValue, LocalDate from, LocalDate until, int games, int goals) {
        this.club = club;
        this.player = player;
        this.transferCost = transferCost;
        this.highestMarketValue = highestMarketValue;
        this.from = from;
        this.until = until;
        this.games = games;
        this.goals = goals;
    }

    //For new players appearing during the game
    public PlayerCareer(Club club, Player player, long transferCost) {
        this.club = club;
        this.player = player;
        this.transferCost = transferCost;
        this.highestMarketValue = player.getMarketValue();
        this.from = LocalDate.now();
        this.until = null; //Take care of NullPointer exceptions!
        this.games = 0;
        this.goals = 0;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getUntil() {
        return until;
    }

    public void setUntil(LocalDate until) {
        this.until = until;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }
}
