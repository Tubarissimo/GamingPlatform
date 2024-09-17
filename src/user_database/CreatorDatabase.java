package user_database;

import java.util.Scanner;
import games_database.*;
import user.*;
import user_database.UserFactory.UserType;

public class CreatorDatabase extends AbstractDatabase{
    private Scanner in = new Scanner(System.in);

    @Override
    public void registerUser()
    {
        in.nextLine();
        AbstractUser newUser = UserFactory.createUser(UserType.CREATOR);
        try {
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
            
            if (newUser.getAge() < 18)
            {
                System.out.println("You're a minor, you don't have permission to create a creator account!!!");
                return;
            }

            userList.add(newUser);
            System.out.println("New creator created successfully!\n");
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
    public void logout()
    {
        setConnectedUser(null);
    }

    @Override
    public void createGame(GameLibrary gameLibrary)
    {
        in.nextLine();
        try {
            Game newGame = new Game(null, 0);

            System.out.println("What's the name of the game?");
            newGame.setName(in.nextLine());
            System.out.println("How much it costs?");
            newGame.setPrice(in.nextInt());

            gameLibrary.getGameList().add(newGame);
            connectedUser.getCreatedGames().getGameList().add(newGame);
            System.out.println("Game published succesfully!\n");
            return;
        } catch (Exception e) {
            System.out.println("Invalid game information...");
        }
    }

    public void showCreatedGames(AbstractUser connectedCreator)
    {
        if (connectedCreator.getCreatedGames() == null)
        {
            System.out.println("You haven't created any games yet...\n");
            return;
        }
        System.out.println(connectedCreator.getCreatedGames());
    }

    @Override
    public void ranking(){}

    @Override
    public void depositCredits(){}

    @Override
    public AbstractUser findMatch() {
        return connectedUser;
    }
}
