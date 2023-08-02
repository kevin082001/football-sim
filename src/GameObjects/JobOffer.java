package GameObjects;

import enums.Club;

public class JobOffer {
    Club club;

    public JobOffer(Club club) {
        this.club = club;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
