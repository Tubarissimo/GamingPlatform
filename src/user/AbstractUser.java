package user;

import java.util.ArrayList;

import games_database.GameLibrary;

public abstract class AbstractUser {
    protected String email;
    protected String password;
    protected String nickname;
    protected int age;

    // user
    protected int score;
    protected double credits;
    protected int moneySpent;
    protected GameLibrary ownedGames;
    protected ArrayList<String> sentChatMessages;
    protected ArrayList<String> receivedChatMessages;

    // creator
    protected GameLibrary createdGames;

    public AbstractUser(String email, String password, String nickname, int age,
                        int score,double credits)
    {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.age = age;

        // user
        this.score = score;
        this.credits = credits;
        this.moneySpent = 0;
        this.ownedGames = new GameLibrary();
        this.sentChatMessages = new ArrayList<>();
        this.receivedChatMessages = new ArrayList<>();

        // creator
        this.createdGames = new GameLibrary();
    }

    // GETTERS
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getNickname() {
        return nickname;
    }
    public int getAge() {
        return age;
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
    public ArrayList<String> getSentChatMessages() {
        return sentChatMessages;
    }
    public ArrayList<String> getReceivedChatMessages() {
        return receivedChatMessages;
    }
    public GameLibrary getCreatedGames() {
        return createdGames;
    }

    // SETTERS
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setAge(int age) {
        this.age = age;
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

    public abstract void updateScore();
    public abstract String showLibrary();
}
