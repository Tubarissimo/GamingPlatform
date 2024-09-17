package user;

import games_database.*;

public class User extends AbstractUser{ 


    public User(String email, String password, String nickname, int age, int score, double credits) {
        super(email, password, nickname, age, score, credits);
    }

    @Override
    public void updateScore()
    {
        int newScore = (this.getOwnedGames().getGameList().size() * 27) + (moneySpent * 2);
        this.setScore(newScore);
    }

    @Override
    public String showLibrary()
    {
        StringBuilder gameString = new StringBuilder();

        gameString.append("\tLIBRARY\n\n");
        for (Game game : ownedGames.getGameList()) {
            gameString.append("\t").append(ownedGames.getGameList().indexOf(game)+1).append(" >> ").append(game.getName()).append("\n");
        }
        gameString.append("\n");

        if (gameString.toString() == "") return "You have no game yet...\n";
        return gameString.toString();
    }

    @Override
    public String toString() 
    {
        return "NAME:\t " + this.nickname + "\n\n" + 
                "SCORE:\t " + this.score + "\n\n" + 
                "AGE:\t " + this.age + "\n\n" + 
                "CREDITS: R$" + String.format("%.2f", this.credits) + "\n\n" + 
                "\n\n";
    }
}