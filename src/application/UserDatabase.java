package application;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;


public class UserDatabase {
    private ArrayList<User> userList;
    private User connectedUser;

    public UserDatabase()
    {
        this.userList = new ArrayList<>();
        this.connectedUser = null;
    }

    // getters
    public ArrayList<User> getUserList() {
        return userList;
    }
    public User getConnectedUser() {
        return connectedUser;
    }

    // setters
    public void setConnectedUser(User connectedUser) {
        this.connectedUser = connectedUser;
    }

    public void registerUser()
    {
        User newUser = new User(null, null, null, 0, 0);
        Scanner in = new Scanner(System.in);
        System.out.println("Type your e-mail adress: ");
        newUser.setEmail(in.nextLine());
        System.out.println("Type your password: ");
        newUser.setPassword(in.nextLine());
        System.out.println("Type your user nickname: ");
        newUser.setNickname(in.nextLine());
        userList.add(newUser);
        System.out.println("New user created successfully!\n");
    }

    public User searchUser(String email, String password) {
        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void login()
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Type your e-mail adress: ");
        String emailString = in.nextLine();
        System.out.println("Type your password: ");
        String passwordString = in.nextLine();
        
        if (searchUser(emailString, passwordString) != null)
        {
            setConnectedUser(searchUser(emailString, passwordString));
            System.out.println("Logged in successfully!\n");
        }
        else
        {
            System.out.println("User not found\n");
        }
    }

    public void depositCredits()
    {
        Scanner in = new Scanner(System.in);

        System.out.println("How much credits do you wanna deposit in your account?\n");
        this.getConnectedUser().setCredits(getConnectedUser().getCredits() + in.nextInt());
        System.out.println("Deposit made successfully!\n");
    }

    public void logout()
    {
        setConnectedUser(null);
    }

    public void ranking()
    {
        Collections.sort(userList, Comparator.comparingInt(User::getScore).reversed());

        int rankRange = Math.min(10, userList.size());
        System.out.println("\tTop users from Sharkbyte\n");
        for (int i = 0; i < rankRange; i++) {
            User user = userList.get(i);
            System.out.println("\t" + (i + 1) + " >> " + user.getNickname() + ": " + user.getScore() + " points");
        }
        System.out.println();
    }

    public User findMatch(User currentUser) {
        int targetScore = currentUser.getScore();
        User bestMatch = null;
        int minScoreDifference = Integer.MAX_VALUE;

        for (User user : userList) {
            if (!user.getNickname().equals(currentUser.getNickname())) {
                int scoreDifference = Math.abs(targetScore - user.getScore());

                if (scoreDifference < minScoreDifference) {
                    minScoreDifference = scoreDifference;
                    bestMatch = user;
                }
            }
        }

        return bestMatch;
    }

    @Override
    public String toString() {
        StringBuilder userString = new StringBuilder();

        for (User user : userList) {
            userString.append(user);
        }

        return userString.toString();
    }

}
