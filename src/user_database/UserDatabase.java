package user_database;

import java.util.Scanner;

import games_database.GameLibrary;

import java.util.Collections;
import java.util.Comparator;
import user_database.UserFactory.UserType;
import user.*;

public class UserDatabase extends AbstractDatabase{
    private Scanner in = new Scanner(System.in);
    
    @Override
    public void registerUser()
    {
        AbstractUser newUser = UserFactory.createUser(UserType.USER);
        try {
            in.nextLine();
            System.out.println("Type your e-mail adress: ");
            newUser.setEmail(in.nextLine());
            if (userExists(newUser.getEmail()) != null) {
                System.out.println("This e-mail is already in use, choose other");
                return;
            }
            System.out.println("Type your password: ");
            newUser.setPassword(in.nextLine());
            System.out.println("Type your user nickname: ");
            newUser.setNickname(in.nextLine());
            if (userExists(newUser.getNickname()) != null) {
                System.out.println("This nickname is already in use, choose other");
                return;
            }
            System.out.println("How old are you: ");
            newUser.setAge(in.nextInt());
            userList.add(newUser);
            System.out.println("New user created successfully!\n");
            
        } catch (Exception e) {
            System.out.println("An error occured during the registration...");
        }
    }

    @Override
    public void login()
    {
        in.nextLine();
        try {
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
            
        } catch (Exception e) {
            System.out.println("An error occurred during login...");
        } 
    }

    @Override
    public void depositCredits()
    {
        in.nextLine();
        try {
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
            
        } catch (Exception e) {
            System.out.println("An error occurred during the deposit...");
        }
    }

    @Override
    public void logout()
    {
        setConnectedUser(null);
    }

    @Override
    public void ranking()
    {
        Collections.sort(userList, Comparator.comparingInt(AbstractUser::getScore).reversed());

        int rankRange = Math.min(10, userList.size());
        System.out.println("\tTop users from Sharkbyte\n");
        for (int i = 0; i < rankRange; i++) {
            AbstractUser user = userList.get(i);
            System.out.println("\t" + (i + 1) + " >> " + user.getNickname() + ": " + user.getScore() + " points");
        }
        System.out.println();
    }

    @Override
    public AbstractUser findMatch() {
        int targetScore = connectedUser.getScore();
        AbstractUser bestMatch = null;
        int minScoreDifference = Integer.MAX_VALUE;

        for (AbstractUser user : userList) {
            if (!user.getNickname().equals(connectedUser.getNickname()) && user.getScore() > 0) {
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
    public void createGame(GameLibrary gameLibrary){}
}