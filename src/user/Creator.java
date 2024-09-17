package user;

import games_database.*;

public class Creator extends AbstractUser {

    public Creator(String email, String password, String nickname, int age, int score, double credits) {
        super(email, password, nickname, age, score, credits);
    }
    
    @Override
    public void updateScore() {}

    @Override
    public String showLibrary()
    {
        StringBuilder gameString = new StringBuilder();

        gameString.append("\tLIBRARY\n\n");
        for (Game game : createdGames.getGameList()) {
            gameString.append("\t").append(createdGames.getGameList().indexOf(game)+1).append(" >> ").append(game.getName()).append("\n");
        }
        gameString.append("\n");

        if (gameString.toString() == "") return "You have created no game yet...\n";
        return gameString.toString();
    }

    @Override
    public String toString() 
    {
        return  "NAME:\t " + this.nickname + "\n\n" + 
                "AGE:\t " + this.age + "\n\n" +
                "CONTACT: " + this.email + "\n\n" +
                "\n\n";
    }

}
