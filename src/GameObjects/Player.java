package GameObjects;

import enums.Club;
import enums.Country;
import enums.Position;

import java.time.LocalDate;
import java.util.Random;

public class Player { //TODO implement: retirement, market value
    private final Random rand = new Random(System.nanoTime());
    private String firstName;
    private String lastName;
    private Country nation;
    private int rating;
    private int ratingWrongPos;
    private LocalDate birthDate;
    private Position position;
    private Club club;

    private Club[] clubsSoFar; //TODO Maybe make new Object where Club and Year from/to is stored (Transfer)
    private int attack;
    private int control;
    private int defense;
    private int matches;
    private int goals;
    private int talent;

    public Player(String firstName, String lastName, Country nation, int rating, LocalDate birthDate, Position position, Club club,
                  Club[] clubsSoFar, int attack, int control, int defense, int talent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nation = nation;
        this.rating = rating;
        this.ratingWrongPos = (int) (0.7 * rating);
        this.birthDate = birthDate;
        this.position = position;
        this.club = club;
        this.clubsSoFar = clubsSoFar;
        this.attack = attack;
        this.control = control;
        this.defense = defense;
        this.matches = 0;
        this.goals = 0;
        this.talent = talent;
    }

    public void levelUp() {
        rating++;
        ratingWrongPos = (int) (rating * 0.7);
        int upgradingStat = rand.nextInt(3);
        switch (upgradingStat) {
            case 0 -> attack++;
            case 1 -> control++;
            case 2 -> defense++;
            default -> System.out.println("Something went wrong");
        }
    }

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


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Country getNation() {
        return nation;
    }

    public void setNation(Country nation) {
        this.nation = nation;
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

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Club[] getClubsSoFar() {
        return clubsSoFar;
    }

    public void setClubsSoFar(Club[] clubsSoFar) {
        this.clubsSoFar = clubsSoFar;
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

    public int getTalent() {
        return talent;
    }

    public void setTalent(int talent) {
        this.talent = talent;
    }
}
