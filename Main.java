package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        GameLibrary gameLibrary = new GameLibrary();
        String file = "src/application/gamelist.txt";
        
        try 
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();

            while (line != null)
            {
                gameLibrary.addGame(line);
                //System.out.println(line + "\n");

                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        gameLibrary.showGames();
    }
}

