package GameObjects;

import enums.ClubEnum;

public class JobOffer {
    ClubEnum club;

    public JobOffer(ClubEnum club) {
        this.club = club;
    }

    public ClubEnum getClub() {
        return club;
    }

    public void setClub(ClubEnum club) {
        this.club = club;
    }
}
