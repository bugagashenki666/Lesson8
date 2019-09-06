import java.util.Scanner;

public class Player {
    private char symbol;
    private String name;
    Scanner scanner;

    public Player()
    {

    }

    public Player(char symbol, String name) {
        this.symbol = symbol;
        this.name = name;
        this.scanner = new Scanner(System.in);
    }

    public int[]makeTurn()
    {
        try{
        System.out.println(this.getName()+ " введите координаты: ");
        return new int[]{Integer.parseInt(scanner.next()),Integer.parseInt(scanner.next())};}
        catch(Exception e)
        {
            System.out.println("Введите 2 целых числа");
        }
        return null;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
