package core;

import GameObjects.JobOffer;
import GameObjects.LeagueTable;
import GameObjects.Match;
import enums.Club;
import enums.Country;
import enums.League;
import helper.ClubHelper;
import helper.LeagueHelper;

import java.util.*;

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

    private static List<JobOffer> jobOffers = new ArrayList<>(); //TODO add Job offers

    //GETTER METHODS

    public static Map<Country, List<League>> getCountriesWithLeagues() {
        return countriesWithLeagues;
    }

    public static Map<League, List<Club>> getPlayableLeagues() {
        return playableLeagues;
    }



    public static List<JobOffer> getJobOffers() {
        return jobOffers;
    }
}