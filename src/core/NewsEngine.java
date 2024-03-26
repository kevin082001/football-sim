package core;

import GameObjects.Club;
import GameObjects.News;
import GameObjects.Player;
import enums.NewsType;

public class NewsEngine {
    public static void createNewsEntry(Club club, Player player, NewsType type, boolean isFollowingClub) {
        if (club == null && player == null) {
            throw new IllegalArgumentException("Either Club or Player must be set in order to create a News entry.");
        }

        News newNews = new News(player, type, null, isFollowingClub);
        if (club == null) {
            //newNews = new News(player, type, null, isFollowingClub);
            switch (type) {
                case RETIREMENT:
                    newNews.setMessage("Player retired: " + player.getFirstName() + " " + player.getLastName() + " (" + PlayerEngine.getPlayerAge(player) + " years)");
                    break;
                case TRANSFER:
                    newNews.setMessage("Transfer: " + player.getFirstName() + " " + player.getLastName() + " (" + player.getCareer()[1].getClub().getDisplayName() + " --> " + player.getCareer()[0].getClub().getDisplayName() + ")");
                    break;
                case BALLON_DOR:
                    newNews.setMessage(player.getFirstName() + " " + player.getLastName() + " won the Ballon d'Or this year! Congratulations!");
                    break;
                default:
                    break;
            }
        } else if (player == null) {
            //TODO add Club News (f.e. season winner (only shown when following), UCL winner, ...)
            return;
        }

        Game.addToNews(newNews);
    }
}
