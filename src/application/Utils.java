package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import games_database.*;
import user_database.*;
import user_database.UserFactory.UserType;
import user.*;

public class Utils {
    public static void updateScore(AbstractDatabase userDatabase)
    {
        for (AbstractUser user : userDatabase.getUserList()) {
            user.updateScore();
        }
    }

    public static void importGameDatabase(String fileGameList, GameLibrary gameLibrary)
    {
        try 
        {
            BufferedReader gameReader = new BufferedReader(new FileReader(fileGameList));
            String line = gameReader.readLine();

            while (line != null)
            {
                String[] dataStrings = line.split("\\*");

                Game newGame = new Game(dataStrings[0],Double.parseDouble(dataStrings[1]));
                gameLibrary.getGameList().add(newGame);

                line = gameReader.readLine();
            }
            gameReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void importUserDatabase(String fileUserDataBase, GameLibrary gameLibrary, AbstractDatabase userDatabase)
    {
        try 
        {
            BufferedReader userReader = new BufferedReader(new FileReader(fileUserDataBase));
            String line = userReader.readLine();

            while (line != null)
            {
                Random random = new Random();
                String[] dataStrings = line.split(" ");

                AbstractUser newUser = UserFactory.createUser(UserType.USER);
                newUser.setEmail(dataStrings[0]);
                newUser.setPassword(dataStrings[1]);
                newUser.setNickname(dataStrings[2]);
                newUser.setAge(random.nextInt(25) + 14);
                newUser.setScore(0);
                newUser.setCredits(Double.parseDouble(dataStrings[3]));
                
                for (int i = 0; i < 30; i++) {
                    gameLibrary.buyGameSimple(newUser, random.nextInt(99) + 1);
                }

                userDatabase.getUserList().add(newUser);
                
                line = userReader.readLine();
            }
            userReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void importCreatorDatabase(String fileCreatorDatabase, AbstractDatabase creatorDatabase)
    {
        try 
        {
            BufferedReader creatorReader = new BufferedReader(new FileReader(fileCreatorDatabase));
            String line = creatorReader.readLine();

            while (line != null)
            {
                String[] dataStrings = line.split(" ");

                AbstractUser newUser = UserFactory.createUser(UserType.USER);
                newUser.setEmail(dataStrings[0]);
                newUser.setPassword(dataStrings[1]);
                newUser.setNickname(dataStrings[2]);
                newUser.setAge(Integer.parseInt(dataStrings[3]));
                newUser.setScore(0);
                newUser.setCredits(0);

                creatorDatabase.getUserList().add(newUser);
                
                line = creatorReader.readLine();
            }
            creatorReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearConsole() 
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

    public static void sharkByteFAQ() {
        Scanner scanner = new Scanner(System.in);

        try {
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
        } catch (Exception e) {
            System.out.println("An error occurred...");
        } 
    }
}
