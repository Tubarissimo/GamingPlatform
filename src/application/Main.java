package application;

import java.util.Scanner;

import games_database.*;
import user_database.*;

public class Main {
    public static void main(String[] args) {
        GameLibrary gameLibrary = new GameLibrary();
        AbstractDatabase userDatabase = new UserDatabase();
        AbstractDatabase creatorDatabase = new CreatorDatabase();
        Menu menu = new Menu();

        String fileGameList = "src/banco_de_dados/gamelist.txt"; 
        String fileUserDataBase = "src/banco_de_dados/userdatabase.txt";
        String fileCreatorDatabase = "src/banco_de_dados/creatordatabase.txt";
        
        int option = -1;

        // importing game database from gamelist.txt
        Utils.importGameDatabase(fileGameList, gameLibrary);

        // importing user database from userdatabase.txt
        Utils.importUserDatabase(fileUserDataBase, gameLibrary, userDatabase);

        // importing creators database from creatordatabase.txt
        Utils.importCreatorDatabase(fileCreatorDatabase, creatorDatabase);

        Scanner input = new Scanner(System.in);
        do {
            Utils.updateScore(userDatabase);

            // DEFAULT
            if (userDatabase.getConnectedUser() == null && creatorDatabase.getConnectedUser() == null)
            {
                System.out.println(menu.menuDefault);
                Options.optionsDefault(input,option,gameLibrary,userDatabase, creatorDatabase);
            }
            // USER
            else if (userDatabase.getConnectedUser() != null && creatorDatabase.getConnectedUser() == null)
            {
                System.out.println(userDatabase.getConnectedUser());
                System.out.println(menu.menuUser);
                Options.optionsUser(input, option, gameLibrary, userDatabase, creatorDatabase);
            }
            // CREATOR
            else if (userDatabase.getConnectedUser() == null && creatorDatabase.getConnectedUser() != null)
            {
                System.out.println(creatorDatabase.getConnectedUser());
                System.out.println(menu.menuCreator);
                Options.optionsCreator(input, option, gameLibrary, userDatabase, creatorDatabase);
            }
        } while (option != 0);
    }
}
