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
        User newUser = new User(null, null, null, 0, 0, 0);
        Scanner in = new Scanner(System.in);
        System.out.println("Type your e-mail adress: ");
        newUser.setEmail(in.nextLine());
        System.out.println("Type your password: ");
        newUser.setPassword(in.nextLine());
        System.out.println("Type your user nickname: ");
        newUser.setNickname(in.nextLine());
        System.out.println("How old are you: ");
        newUser.setAge(in.nextInt());
        userList.add(newUser);
        System.out.println("New user created successfully!\n");
    }

    public User validateUser(String email, String password) {
        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public User searchUser(String nickname) {
        for (User user : userList) {
            if (user.getNickname().equals(nickname)) {
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
        
        if (validateUser(emailString, passwordString) != null)
        {
            setConnectedUser(validateUser(emailString, passwordString));
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

        if (this.getConnectedUser().getAge() < 18)
        {
            int confirmation = -1;
            System.out.println("You must have your parents permission to do that!\n\nParents, do you allow to do the deposit?\n[1] YES   [2] NO\n");
            confirmation = in.nextInt();
            if (confirmation == 2)
            {
                System.out.println("\nTransaction failed...\nYou don't have your parents permission!\n");
                return;
            }
        }
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

    public void sendMessage(User user)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Write the nickname of the user you wanna chat: ");
        String searchedUser = in.nextLine();

        if (searchUser(searchedUser) == null)
        {
            System.out.println("User not found\n");
            return;
        }

        System.out.println("Type the message tou wanna send to this user: ");
        String message = in.nextLine();

        StringBuilder messageBuilder = new StringBuilder();

        messageBuilder.append("\n\t[ ").append(getConnectedUser().getNickname()).append(" ]\n").append(message).append("\n\n");

        user.getSentChatMessages().add(messageBuilder.toString());
        searchUser(searchedUser).getReceivedChatMessages().add(messageBuilder.toString());

        System.out.println("Message sent succesfully\n");
    }

    public String showSentMessages(User user)
    {
        StringBuilder messageString = new StringBuilder();

        if (user.getSentChatMessages().isEmpty() == true)
        {
            return "You have no sent messages\n";
        }
        else
        {
            for (String message : user.getSentChatMessages()) {
                messageString.append(message);
            }
            
            return messageString.toString();
        }
    }

    public String showReceivedMessages(User user)
    {
        StringBuilder messageString = new StringBuilder();

        if (user.getReceivedChatMessages().isEmpty() == true)
        {
            return "You have no messages\n";
        }
        else
        {
            for (String message : user.getReceivedChatMessages()) {
                messageString.append(message);
            }
            
            return messageString.toString();
        }
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
