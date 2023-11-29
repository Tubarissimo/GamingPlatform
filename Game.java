package application;

public class Game {
    protected String name;
    Game next;

    public Game (String name)
    {
        this.name = name;
        this.next = null;
    }

    // getters
    public String getName() {
        return name;
    }
    public Game getNext() {
        return next;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }
    public void setNext(Game next) {
        this.next = next;
    }
}
