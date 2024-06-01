package core;

import GameObjects.JobOffer;
import enums.Club;
import enums.Country;
import enums.League;
import helper.ClubHelper;
import helper.LeagueHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Handles stuff which none of the other engines are responsible for
 * <br>See also:<br>
 * <ul>
 *     <li>{@link PlayerEngine}</li>
 *     <li>{@link MatchEngine}</li>
 *     <li>{@link TransferMarketEngine}</li>
 *     <li>{@link NewsEngine}</li>
 *     <li>{@link ClubEngine}</li>
 *     <li>{@link SeasonEngine}</li>
 * </ul>
 */
public class Engine {
    private final static Random rand = new Random(System.nanoTime());
    private final static Map<Country, List<League>> countriesWithLeagues = LeagueHelper.getCountriesThatHaveLeagues();
    private final static Map<League, List<Club>> playableLeagues = LeagueHelper.getPlayableLeagues();

    private static List<JobOffer> jobOffers = new ArrayList<>();


    public static void checkForJobOffers(Club currentClub) {
        if (currentClub == null) {
            return;
        }

        int chanceForJobOffer = 60; //TODO IMPORTANT: change back to 3 (only for testing)
        int chanceForJobOfferFromSameCountry = 2;

        //Only allow clubs that have
        //more than 0.5x currentClub value
        //and less than 3x currentClub value
        List<Club> potentialClubs = new ArrayList<>();
        for (Club club : ClubHelper.getAllClubs()) {
            if ((ClubHelper.getTotalMarketValue(club) >= 0.5 * ClubHelper.getTotalMarketValue(currentClub))
                    && ClubHelper.getTotalMarketValue(club) <= 3 * ClubHelper.getTotalMarketValue(currentClub)) {
                potentialClubs.add(club);
            }
        }

        int randomNumber = rand.nextInt(100);
        if (randomNumber <= chanceForJobOffer) {
            if (randomNumber <= chanceForJobOfferFromSameCountry) {
                //SAME COUNTRY
                potentialClubs = potentialClubs
                        .stream()
                        .filter(x -> x.getLeague().getCountry() == currentClub.getLeague().getCountry())
                        .toList();
                Club offeringClub = potentialClubs.isEmpty() ? null : potentialClubs.get(rand.nextInt(potentialClubs.size()));
                generateJobOffer(offeringClub);
            } else {
                //ANY COUNTRY
                Club offeringClub = potentialClubs.isEmpty() ? null : potentialClubs.get(rand.nextInt(potentialClubs.size()));
                generateJobOffer(offeringClub);
            }
        }
    }

    private static void generateJobOffer(Club club) {
        if (club == null || club.equals(Game.getCurrentClub())) {
            return;
        }

        //Don't allow multiple offers from the same club
        for (JobOffer offer : jobOffers) {
            if (offer.getClub().equals(club) || !isSelectable(club)) {
                return;
            }
        }

        jobOffers.add(new JobOffer(club));
    }

    public static void acceptOffer(JobOffer offer) {
        //TODO if offer accepted, the money should also be updated (POSSIBLY ALREADY DONE)

        if (offer == null) {
            return;
        }

        Game.setCurrentClub(offer.getClub());
        ClubEngine.initSquad(offer.getClub());
        SeasonEngine.initTable(offer.getClub());
        jobOffers = new ArrayList<>();
    }

    public static void declineOffer(JobOffer offer) {
        if (offer == null) {
            return;
        }

        removeFromOffers(offer);
    }

    public static Map<Country, List<League>> getCountriesWithLeagues() {
        return countriesWithLeagues;
    }

    public static Map<League, List<Club>> getPlayableLeagues() {
        return playableLeagues;
    }


    public static List<JobOffer> getJobOffers() {
        return jobOffers;
    }

    /**
     * Removes a job offer from {@link #jobOffers}.
     * This method may only be used when an offer expires or gets accepted/declined.
     *
     * @param offer The job offer
     */
    private static void removeFromOffers(JobOffer offer) {
        if (offer == null) {
            return;
        }

        //Solved like this because otherwise, a ConcurrentModificationException would occur when trying to remove an offer
        JobOffer toRemove = null;
        for (JobOffer jobOffer : jobOffers) {
            if (jobOffer.getClub().equals(offer.getClub())) {
                toRemove = jobOffer;
                break;
            }
        }
        jobOffers.remove(toRemove);
    }

    private static boolean isSelectable(Club club) {
        if (club == null) {
            return false;
        }

        return !club.equals(Club.WITHOUT_CLUB) && !club.equals(Club.RETIRED);
    }
}