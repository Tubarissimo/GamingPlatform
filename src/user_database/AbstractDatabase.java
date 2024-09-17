package user_database;

import java.util.ArrayList;
import java.util.Scanner;

import games_database.GameLibrary;
import user.*;

public abstract class AbstractDatabase {
    protected ArrayList<AbstractUser> userList;
    protected AbstractUser connectedUser;
    private Scanner in = new Scanner(System.in);

    public AbstractDatabase(){
        this.userList = new ArrayList<>();
        this.connectedUser = null;
    }

    // GETTERS
    public ArrayList<AbstractUser> getUserList() {
        return userList;
    }
    public AbstractUser getConnectedUser() {
        return connectedUser;
    }

    // SETTERS
    public void setConnectedUser(AbstractUser connectedUser) {
        this.connectedUser = connectedUser;
    }

    public abstract void registerUser();

    public abstract void login();

    public abstract void logout();

    public abstract void ranking();

    public abstract void depositCredits();

    public abstract AbstractUser findMatch();

    public abstract void createGame(GameLibrary gameLibrary);

    public AbstractUser validateUser(String email, String password) {
        for (AbstractUser user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public AbstractUser searchUser(String nickname) {
        for (AbstractUser user : userList) {
            if (user.getNickname().equals(nickname)) {
                return user;
            }
        }
        return null;
    }

    public AbstractUser userExists(String string) {
        for (AbstractUser user : userList) {
            if (user.getEmail().equals(string)) {
                return user;
            } else if (user.getNickname().equals(string)){
                return user;
            }
        }
        return null;
    }

    public void sendMessage(AbstractUser user)
    {
        try {
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
            
        } catch (Exception e) {
            System.out.println("An error occurred during message sending...");
        } 

    }

    public String showSentMessages(AbstractUser user)
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

    public String showReceivedMessages(AbstractUser user)
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

        for (AbstractUser user : userList) {
            userString.append(user);
        }

        return userString.toString();
    }
}
