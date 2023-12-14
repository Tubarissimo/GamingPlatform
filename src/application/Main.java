package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        GameLibrary gameLibrary = new GameLibrary();
        UserDatabase userDatabase = new UserDatabase();
        String fileGameList = "C:\\Users\\paugu\\OneDrive\\Documentos\\codes\\repositorio\\GamingPlatform\\src\\application\\gamelist.txt"; 
        String fileUserDataBase = "C:\\Users\\paugu\\OneDrive\\Documentos\\codes\\repositorio\\GamingPlatform\\src\\application\\userdatabase.txt";
        int option = -1;


        // importing game database from gamelist.txt
        try 
        {
            BufferedReader reader = new BufferedReader(new FileReader(fileGameList));
            String line = reader.readLine();

            while (line != null)
            {
                String[] dataStrings = line.split("\\*");

                Game newGame = new Game(dataStrings[0],Double.parseDouble(dataStrings[1]));
                gameLibrary.getGameList().add(newGame);

                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // importing user database from userdatabase.txt
        try 
        {
            BufferedReader reader = new BufferedReader(new FileReader(fileUserDataBase));
            String line = reader.readLine();

            while (line != null)
            {
                Random random = new Random();
                String[] dataStrings = line.split(" ");

                User newUser = new User(dataStrings[0], dataStrings[1], dataStrings[2],random.nextInt(25) + 14, 0, Double.parseDouble(dataStrings[3]));
                
                for (int i = 0; i < 30; i++) {
                    gameLibrary.buyGameSimple(newUser, random.nextInt(99) + 1);
                }

                userDatabase.getUserList().add(newUser);
                
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Scanner input = new Scanner(System.in);
        do
        {
            for (User user : userDatabase.getUserList()) {
                user.updateScore();
            }
            if (userDatabase.getConnectedUser() == null)
            {
                System.out.println(
                "\t<<   SHARKBYTE   >>\n\n" +
                "[1] SHOP\n" +
                "[2] LOGIN\n" +
                "[3] REGISTER\n" +
                "[4] SHOW USERS\n" + 
                "[5] RANKING\n" +
                "[6] SharkByteFAQ\n" +
                "[7] UPDATES AND PATCHES\n" +
                "[0] EXIT\n\n"
                );
                option = input.nextInt();

                switch (option) {
                case 1:
                    clearConsole();
                    System.out.println(gameLibrary);
                    break;
                case 2:
                    clearConsole();
                    userDatabase.login();
                    break;
                case 3:
                    clearConsole();
                    userDatabase.registerUser();
                    break;
                case 4:
                    clearConsole();
                    System.out.println(userDatabase);
                    break;
                case 5:
                    clearConsole();
                    userDatabase.ranking();
                    break;
                case 6:
                    clearConsole();
                    sharkByteFAQ();
                    break;
                case 7:
                    clearConsole();
                    gameLibrary.updatesAndPatches();
                    break;
                case 0:
                    clearConsole();
                    input.close();
                    System.out.println("Thanks for using Sharkbyte services!\n");
                    break;
                default:
                    clearConsole();
                    System.out.println("Choose a valid option.\n\n");
                    break;
                }
            }
            else
            {
                System.out.println(userDatabase.getConnectedUser());
                System.out.println(
                    "\t<<   SHARKBYTE   >>\n\n" +
                    "[1] SHOP\n" +
                    "[2] USER LIBRARY\n" +
                    "[3] BUY GAME\n" + 
                    "[4] LOGOUT\n" +
                    "[5] DEPOSIT CREDITS\n" +
                    "[6] FIND A PLAYER TO PLAY\n" +
                    "[7] BUY SKINS/GAMEPASS\n" +
                    "[8] SEND MESSAGE\n" +
                    "[9] SENT MESSAGES\n" +
                    "[10] RECEIVED MESSAGES\n" +
                    "[11] SHOW USERS\n" + 
                    "[12] RANKING\n" +
                    "[13] SharkByteFAQ\n" +
                    "[14] UPDATES AND PATCHES\n" +    
                    "[0] EXIT\n\n"
                );
                option = input.nextInt();

                switch (option) {
                case 1:
                    clearConsole();
                    System.out.println(gameLibrary);
                    break;
                case 2:
                    clearConsole();
                    System.out.println(userDatabase.getConnectedUser().showLibrary());
                    break;
                case 3:
                    clearConsole();
                    gameLibrary.buyGame(userDatabase.getConnectedUser());
                    break;
                case 4:
                    clearConsole();
                    userDatabase.logout();
                    break;
                case 5:
                    clearConsole();
                    userDatabase.depositCredits();
                    break;
                case 6:
                    clearConsole();
                    System.out.println(userDatabase.findMatch(userDatabase.getConnectedUser()));
                    break;
                case 7:
                    clearConsole();
                    gameLibrary.inGamePurchases(userDatabase.getConnectedUser());
                    break;
                case 8:
                    clearConsole();
                    userDatabase.sendMessage(userDatabase.getConnectedUser());
                    break;
                case 9:
                    clearConsole();
                    System.out.println(userDatabase.showSentMessages(userDatabase.getConnectedUser()));
                    break;
                case 10:
                    clearConsole();
                    System.out.println(userDatabase.showReceivedMessages(userDatabase.getConnectedUser()));
                    break;
                case 11:
                    clearConsole();
                    System.out.println(userDatabase);
                    break;
                case 12:
                    clearConsole();
                    userDatabase.ranking();
                    break;
                case 13:
                    clearConsole();
                    sharkByteFAQ();
                    break;
                case 14:
                    clearConsole();
                    gameLibrary.updatesAndPatches();
                    break;
                case 0:
                    clearConsole();
                    input.close();
                    System.out.println("Thanks for using Sharkbyte services!\n");
                    break;
                default:
                    clearConsole();
                    System.out.println("Choose a valid option.\n\n");
                    break;
                }
            }
        }while(option != 0);
    }

    private static void clearConsole() 
    {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void sharkByteFAQ() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("SharkByte FAQ - Please choose a question (1-10):");
        System.out.println("[1] How do I purchase a game on SharkByte?");
        System.out.println("[2] What payment methods does SharkByte accept?");
        System.out.println("[3] Can I refund a game on SharkByte if I change my mind?");
        System.out.println("[4] How do I download and install a game on SharkByte after purchase?");
        System.out.println("[5] Are my personal and payment details secure on SharkByte?");
        System.out.println("[6] Can I gift a game to a friend on SharkByte?");
        System.out.println("[7] What are the system requirements on SharkByte, and how can I check if my PC can run a game?");
        System.out.println("[8] How do I access customer support on SharkByte if I encounter issues?");
        System.out.println("[9] Does SharkByte offer discounts or promotions?");
        System.out.println("[10] Can I pre-order upcoming games on SharkByte?");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("To buy a game on SharkByte, simply explore our catalog, choose the game you want, and click on the \"Buy\" or \"Add to Cart\" button. Follow the on-screen instructions to complete the purchase.");
                break;
            case 2:
                System.out.println("SharkByte accepts various payment methods, including credit cards, PayPal, and other secure payment options. You can view the available payment methods during the checkout process.");
                break;
            case 3:
                System.out.println("Yes, SharkByte offers a refund policy. Please refer to our refund policy page for details on eligibility and procedures. Keep in mind that some restrictions may apply.");
                break;
            case 4:
                System.out.println("After completing your purchase on SharkByte, you'll receive instructions on how to download and install the game. Typically, this involves accessing your account library or receiving a download link.");
                break;
            case 5:
                System.out.println("Yes, SharkByte takes security seriously. We use industry-standard encryption and security measures to protect your personal and payment information. Your data is confidential and safe with us.");
                break;
            case 6:
                System.out.println("Absolutely! Many games on SharkByte have a gifting option. During the purchase process, look for the \"Gift\" option, and follow the prompts to send the game to your friend.");
                break;
            case 7:
                System.out.println("System requirements are the minimum specifications a computer needs to run a game. You can find this information on the game's product page on SharkByte. We recommend checking your PC against these requirements before purchasing.");
                break;
            case 8:
                System.out.println("If you encounter any issues on SharkByte, please visit our support page or contact our customer support team via email at support@sharkbyte.com. We are here to assist you with any problems or questions you may have.");
                break;
            case 9:
                System.out.println("Yes, SharkByte regularly offers discounts and promotions on various games. Keep an eye on our website, newsletter, or social media channels to stay informed about the latest deals and offers.");
                break;
            case 10:
                System.out.println("Certainly! SharkByte offers pre-orders for many upcoming games. Visit our pre-order section to reserve your copy and receive exclusive bonuses or early access when available.");
                break;
            default:
                System.out.println("Invalid choice. Please choose a number between 1 and 10.");
        }
    }

}
