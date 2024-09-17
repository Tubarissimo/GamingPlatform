package application;

import java.util.Scanner;

import games_database.*;
import user_database.*;

public class Options {
    public static void optionsDefault(Scanner input, int option, GameLibrary gameLibrary, AbstractDatabase userDatabase, AbstractDatabase creatorDatabase)
    {
        if (input.hasNextInt())
        {
            option = input.nextInt();

            switch (option) {
                case 1:
                    Utils.clearConsole();
                    System.out.println(gameLibrary);
                    break;
                case 2:
                    Utils.clearConsole();
                    userDatabase.login();
                    break;
                case 3:
                    Utils.clearConsole();
                    creatorDatabase.login();
                    break;
                case 4:
                    Utils.clearConsole();
                    userDatabase.registerUser();
                    break;
                case 5:
                    Utils.clearConsole();
                    creatorDatabase.registerUser();
                    break;
                case 6:
                    Utils.clearConsole();
                    System.out.println(userDatabase);
                    break;
                case 7:
                    Utils.clearConsole();
                    System.out.println(creatorDatabase);
                    break;
                case 8:
                    Utils.clearConsole();
                    userDatabase.ranking();
                    break;
                case 9:
                    Utils.clearConsole();
                    Utils.sharkByteFAQ();
                    break;
                case 10:
                    Utils.clearConsole();
                    gameLibrary.updatesAndPatches();
                    break;
                case 0:
                    Utils.clearConsole();
                    input.close();
                    System.out.println("Thanks for using Sharkbyte services!\n");
                    break;
                default:
                    Utils.clearConsole();
                    System.out.println("Choose a valid option.\n\n");
                    break;
            }
        } else {
            input.next();
        }
    }

    public static void optionsUser(Scanner input, int option, GameLibrary gameLibrary, AbstractDatabase userDatabase, AbstractDatabase creatorDatabase)
    {
        if (input.hasNextInt())
        {
            option = input.nextInt();

            switch (option) {
                case 1:
                    Utils.clearConsole();
                    System.out.println(gameLibrary);
                    break;
                case 2:
                    Utils.clearConsole();
                    System.out.println(userDatabase.getConnectedUser().showLibrary());
                    break;
                case 3:
                    Utils.clearConsole();
                    gameLibrary.buyGame(userDatabase.getConnectedUser());
                    break;
                case 4:
                    Utils.clearConsole();
                    userDatabase.logout();
                    break;
                case 5:
                    Utils.clearConsole();
                    userDatabase.depositCredits();
                    break;
                case 6:
                    Utils.clearConsole();
                    System.out.println(userDatabase.findMatch());
                    break;
                case 7:
                    Utils.clearConsole();
                    gameLibrary.inGamePurchases(userDatabase.getConnectedUser());
                    break;
                case 8:
                    Utils.clearConsole();
                    userDatabase.sendMessage(userDatabase.getConnectedUser());
                    break;
                case 9:
                    Utils.clearConsole();
                    System.out.println(userDatabase.showSentMessages(userDatabase.getConnectedUser()));
                    break;
                case 10:
                    Utils.clearConsole();
                    System.out.println(userDatabase.showReceivedMessages(userDatabase.getConnectedUser()));
                    break;
                case 11:
                    Utils.clearConsole();
                    System.out.println(userDatabase);
                    break;
                case 12:
                    Utils.clearConsole();
                    userDatabase.ranking();
                    break;
                case 13:
                    Utils.clearConsole();
                    Utils.sharkByteFAQ();
                    break;
                case 14:
                    Utils.clearConsole();
                    gameLibrary.updatesAndPatches();
                    break;
                case 0:
                    Utils.clearConsole();
                    input.close();
                    System.out.println("Thanks for using Sharkbyte services!\n");
                    break;
                default:
                    Utils.clearConsole();
                    System.out.println("Choose a valid option.\n\n");
                    break;
            }
        } else {
            input.next();
        }
    }

    public static void optionsCreator(Scanner input, int option, GameLibrary gameLibrary, AbstractDatabase userDatabase, AbstractDatabase creatorDatabase)
    {
        if (input.hasNextInt())
        {
            option = input.nextInt();

            switch (option) {
                case 1:
                    Utils.clearConsole();
                    System.out.println(gameLibrary);
                    break;
                case 2:
                    System.out.println(creatorDatabase.getConnectedUser().showLibrary());
                    break;
                case 3:
                    creatorDatabase.createGame(gameLibrary);
                    break;
                case 4:
                    creatorDatabase.logout();
                    break;
                case 0:
                    Utils.clearConsole();
                    input.close();
                    System.out.println("Thanks for using Sharkbyte services!\n");
                    break;
                default:
                    Utils.clearConsole();
                    System.out.println("Choose a valid option.\n\n");
                    break;
            }
            
        } else {
            input.next();
        }
    }
}
