package application;

public class GameLibrary {
    protected Game elementGame;

    public GameLibrary()
    {
        this.elementGame = null;
    }

    public void addGame(String name)
    {
        Game newGame = new Game(name);

        if (elementGame == null)
        {
            elementGame = newGame;
        }
        else
        {
            Game aux = elementGame;
            while(aux.next != null)
            {
                aux = aux.next;
            }
            aux.next = newGame;
        }
    }

    public void showGames()
    {
        int i = 1;
        Game aux = elementGame;
        while(aux != null)
        {
            System.out.println(i + ". " + aux.name);
            aux = aux.next;
            ++i;
        }
    }


}