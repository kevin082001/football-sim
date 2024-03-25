package GameObjects;

import enums.ClubEnum;
import enums.Country;
import enums.Position;
import helper.ArrayHelper;

import java.time.LocalDate;
import java.util.Random;

public class Player { //TODO implement: update talent, decrease rating when performing very badly
    private final Random rand = new Random(System.nanoTime());


    private int id;
    private final String firstName;
    private final String lastName;
    private Country nation;
    private int rating;
    private int ratingWrongPos;
    private final LocalDate birthDate;
    private Position position;

    private long marketValue;
    private ClubEnum club;
    private ClubEnum[] clubsSoFar; //TODO is clubsSoFar still needed when we have career?
    private PlayerCareer[] career;
    private int attack;
    private int control;
    private int defense;
    private int matches;
    private int goals;
    private int assists;
    private int saves;
    private int goalsConceded;
    private int talent;

    private Integer retirementSeason;

    public Player(int id, String firstName, String lastName, Country nation, int rating, LocalDate birthDate, Position position, long marketValue, ClubEnum club,
                  ClubEnum[] clubsSoFar, int attack, int control, int defense, int talent) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nation = nation;
        this.rating = rating;
        this.ratingWrongPos = (int) (0.7 * rating);
        this.birthDate = birthDate;
        this.position = position;
        this.marketValue = marketValue;
        this.club = club;
        this.clubsSoFar = clubsSoFar;
        this.attack = attack;
        this.control = control;
        this.defense = defense;
        this.matches = 0;
        this.goals = 0;
        this.assists = 0;
        this.saves = 0;
        this.goalsConceded = 0;
        this.talent = talent;
        this.retirementSeason = null;
    }

    public Player(String firstName, String lastName, Country nation, int rating, LocalDate birthDate, Position position, long marketValue, ClubEnum club,
                  ClubEnum[] clubsSoFar, int attack, int control, int defense, int talent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nation = nation;
        this.rating = rating;
        this.ratingWrongPos = (int) (0.7 * rating);
        this.birthDate = birthDate;
        this.position = position;
        this.marketValue = marketValue;
        this.club = club;
        this.clubsSoFar = clubsSoFar;
        this.career = new PlayerCareer[0];
        this.attack = attack;
        this.control = control;
        this.defense = defense;
        this.matches = 0;
        this.goals = 0;
        this.assists = 0;
        this.saves = 0;
        this.goalsConceded = 0;
        this.talent = talent;
        this.retirementSeason = null;
    }

    public void levelUp() { // Is this really the right place for this method? Shouldn't it be in PlayerEngine??
        setRating(getRating() + 1);
        ratingWrongPos = (int) (rating * 0.7);
        int upgradingStat = rand.nextInt(3); //TODO maybe change how stats are chosen (f.e: 70 attack, 40 defense --> attack has more chance to get increased)
        switch (upgradingStat) {
            case 0 -> attack++;
            case 1 -> control++;
            case 2 -> defense++;
            default -> System.out.println("Something went wrong");
        }
    }

    /**
     * This method is used to calculate the player's rating depending on his position when editing the squad.
     *
     * @param newPosition The position the player gets moved to
     */
    public void changePosition(Position newPosition) {
        if (newPosition == null) return;
        if (!position.getType().equals(newPosition.getType())) {
            rating = ratingWrongPos;
        } else if (rating == ratingWrongPos) {
            //I'm not sure if this works properly
            rating = (ratingWrongPos / 0.7) % 1 == 0 ? (int) (ratingWrongPos / 0.7) : (int) (ratingWrongPos / 0.7) + 1;
        }
        position = newPosition;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Country getNation() {
        return nation;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public long getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(long marketValue) {
        this.marketValue = marketValue;
    }

    public ClubEnum getClub() {
        return club;
    }

    public void setClub(ClubEnum club) {
        this.club = club;
    }

    public ClubEnum[] getClubsSoFar() {
        return clubsSoFar;
    }

    public void setClubsSoFar(ClubEnum[] clubsSoFar) {
        this.clubsSoFar = clubsSoFar;
    }

    public PlayerCareer[] getCareer() {
        return career;
    }

    /**
     * @deprecated Use {@link #addClubToCareer} instead
     */
    @Deprecated
    public void setCareer(PlayerCareer[] career) {
        this.career = career;
    }

    public void addClubToCareer(PlayerCareer club) {
        career = ArrayHelper.extend(career);
        career[career.length - 1] = club;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getControl() {
        return control;
    }

    public void setControl(int control) {
        this.control = control;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getSaves() {
        return saves;
    }

    public void setSaves(int saves) {
        this.saves = saves;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public int getTalent() {
        return talent;
    }

    public void setTalent(int talent) {
        this.talent = talent;
    }

    public Integer getRetirementSeason() {
        return retirementSeason;
    }

    public void setRetirementSeason(Integer retirementSeason) {
        this.retirementSeason = retirementSeason;
    }
}
