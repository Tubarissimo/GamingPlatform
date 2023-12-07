package application;

public class Game {
    private String name;
    private double price;

    public Game (String name,double price)
    {
        this.name = name;
        this.price = price;
    }

    // getters
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "\t" + this.name + "\n\tPRICE:\tR$" + this.price + "\n\n";
    }
}
