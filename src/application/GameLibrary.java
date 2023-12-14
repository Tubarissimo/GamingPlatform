package application;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class GameLibrary {
    private ArrayList<Game> gameList;

    public GameLibrary()
    {
        this.gameList = new ArrayList<>();
    }

    // getters
    public ArrayList<Game> getGameList() {
        return gameList;
    }

    public void buyGameSimple(User user, int indexGame)
    {
        if (user.getOwnedGames().getGameList().contains(gameList.get(indexGame))) 
        {
            return;
        }
        if (user.getCredits() >= gameList.get(indexGame).getPrice())
        {
            user.getOwnedGames().getGameList().add(gameList.get(indexGame));
            user.setCredits(user.getCredits() - gameList.get(indexGame).getPrice());
            user.setMoneySpent(user.getMoneySpent() + (int) gameList.get(indexGame).getPrice());
        }
    }

    public void buyGame(User user)
    {
        int indexGame = -1;
        Scanner in = new Scanner(System.in);
        System.out.println("You have R$" + user.getCredits());
        System.out.println("\nType the number of the game wich you wanna buy: ");
        indexGame = in.nextInt() - 1;

        System.out.println("The game you chose was:\n" + gameList.get(indexGame));

        if (user.getAge() < 18)
        {
            int confirmation = -1;
            System.out.println("You must have your parents permission to do that!\n\nParents, do you allow to this purchase?\n[1] YES   [2] NO\n");
            confirmation = in.nextInt();
            if (confirmation == 2)
            {
                System.out.println("\nTransaction failed...\nYou don't have your parents permission!\n");
                return;
            }
        }

        if (user.getOwnedGames().getGameList().contains(gameList.get(indexGame))) 
        {
            System.out.println("You already have this game!\n");
            System.out.println("\nTransaction failed...\n");
            return;
        }

        if (user.getCredits() >= gameList.get(indexGame).getPrice())
        {
            int confirmation = -1;
            System.out.println("\nDo you really wanna buy it?\n[1] YES   [2] NO\n");
            confirmation = in.nextInt();
            if (confirmation == 1)
            {
                System.out.println("Wich OS are downloading the game for?\n[1] WINDOWS\n[2] LINUX\n[3] MACOS\n");
                in.nextInt();
                user.getOwnedGames().getGameList().add(gameList.get(indexGame));
                user.setCredits(user.getCredits() - gameList.get(indexGame).getPrice());
                System.out.println("\nTransaction completed successfully!!!\n");
                user.setMoneySpent(user.getMoneySpent() + (int) gameList.get(indexGame).getPrice());
            }
            else
            {
                System.out.println("\nTransaction failed...\n");
            }
        }
        else
        {
            System.out.println("\nTransaction failed...\n");
            System.out.println("\nYou have don't have enoughth money yet...\nDeposit credits on your account to buy games!\n\n");
        }
    }

    public void inGamePurchases(User user)
    {
        int indexGame = -1;
        Scanner in = new Scanner(System.in);
        System.out.println("You have R$" + user.getCredits());
        System.out.println("\nType the number of the game wich you wanna buy skins or gamepass: ");
        indexGame = in.nextInt() - 1;

        System.out.println("The game you chose was:\n" + user.getOwnedGames().getGameList().get(indexGame));

        if (user.getCredits() >= 25.50)
        {
            int confirmation = -1;
            System.out.println("\nPRICE: R$25,50\nDo you really wanna buy it?\n[1] YES   [2] NO\n");
            confirmation = in.nextInt();
            if (confirmation == 1)
            {
                if (user.getAge() < 18)
                {
                    int parentConfirmation = -1;
                    System.out.println("You must have your parents permission to do that!\n\nParents, do you allow to this purchase?\n[1] YES   [2] NO\n");
                    parentConfirmation = in.nextInt();
                    if (parentConfirmation == 2)
                    {
                        System.out.println("\nTransaction failed...\nYou don't have your parents permission!\n");
                        return;
                    }
                }
                user.setCredits(user.getCredits() - 25.50);
                System.out.println("\nTransaction completed successfully!!!\n");
                user.setMoneySpent(user.getMoneySpent() + 25);
            }
            else
            {
                System.out.println("\nTransaction failed...\n");
            }
        }
        else
        {
            System.out.println("\nTransaction failed...\n");
            System.out.println("\nYou have don't have enoughth money yet...\nDeposit credits on your account to buy skins and gamepass!\n\n");
        }
    }

    public void updatesAndPatches()
    {
        int indexGame = -1;
        Random random = new Random();
        Scanner in = new Scanner(System.in);

        System.out.println("\nType the number of the game wich you wanna check out about new patches or updates: ");
        indexGame = in.nextInt() - 1;

        System.out.println("The game you chose was:\n" + gameList.get(indexGame));

        String patches[] = {"This game have a new update avaliable to download, check out!!!\n","This game have a new patch correcting bugs, check out!\n","This game don't have any new updates or patches... We will notice you when there are.\n"};
        int index = random.nextInt(3);
        System.out.println(patches[index]);
    }

    @Override
    public String toString() 
    {
        StringBuilder gameString = new StringBuilder();

        for (Game game : gameList) {
            gameString.append("\t").append(gameList.indexOf(game)+1).append(" >>").append(game);
        }

        return gameString.toString();
    }
}
