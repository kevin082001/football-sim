package GameObjects;

import enums.Country;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Country nationality;
    private Club currentClub;
    private List<Club> previousClubs; //TODO Rework: details about career at club (duration,...)

    public Manager(String firstName, String lastName, LocalDate birthDate, Country nationality, Club currentClub) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.currentClub = currentClub;
        this.previousClubs = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Club getCurrentClub() {
        return currentClub;
    }

    public void setCurrentClub(Club currentClub) {
        this.currentClub = currentClub;
    }

    public List<Club> getPreviousClubs() {
        return previousClubs;
    }

    public void leaveClub(Club newClub) {
        if (newClub == null) {
            return;
        }

        previousClubs.add(currentClub);
        currentClub = newClub;
    }
}
