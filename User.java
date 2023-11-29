package application;

public class User {
    protected String email;
    protected String nickname;
    protected double score;
    protected double credits;

    
    public User(String email,String nickname,double score,double credits)
    {
        this.email = email;
        this.nickname = nickname;
        this.score = score;
        this.credits = credits;
    }


    // getters
    public String getEmail() {
        return email;
    }
    public String getNickname() {
        return nickname;
    }
    public double getScore() {
        return score;
    }
    public double getCredits() {
        return credits;
    }

    // setters
    public void setEmail(String email) {
        this.email = email;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public void setCredits(double credits) {
        this.credits = credits;
    }




}