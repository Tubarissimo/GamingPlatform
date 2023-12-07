package application;

import java.util.Random;

public class User {
    private String email;
    private String password;
    private String nickname;
    private int score;
    private double credits;
    private int moneySpent;
    private GameLibrary ownedGames;

    
    public User(String email,String password,String nickname,int score,double credits)
    {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.score = score;
        this.credits = credits;
        this.moneySpent = 0;
        this.ownedGames = new GameLibrary();
    }


    // getters
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getNickname() {
        return nickname;
    }
    public int getScore() {
        return score;
    }
    public int getMoneySpent() {
        return moneySpent;
    }
    public double getCredits() {
        return credits;
    }
    public GameLibrary getOwnedGames() {
        return ownedGames;
    }

    // setters
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setMoneySpent(int moneySpent) {
        this.moneySpent = moneySpent;
    }
    public void setCredits(double credits) {
        this.credits = credits;
    }

    Random random = new Random();
    public void updateScore()
    {
        int newScore = (this.getOwnedGames().getGameList().size() * 27) + (moneySpent * 2);
        this.setScore(newScore);
    }

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
                "CREDITS: R$" + String.format("%.2f", this.credits) + "\n\n" + 
                "\n\n";
    }

}