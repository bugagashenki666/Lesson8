import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Controller {
    Scanner scanner;
    Player players[];
    Field field;

    public Controller()
    {
        this.scanner = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Введите имя первого пользователя:");
        Player p1 = new Player(r.nextBoolean()?'X':'O', this.scanner.next());
        System.out.println("Введите имя второго пользователя:");
        this.players = new Player[]{p1, new Player(p1.getSymbol()=='X'?'O':'X', this.scanner.next())};
        System.out.println(this.players[0].getName() + " играет " + this.players[0].getSymbol());
        System.out.println(this.players[1].getName() + " играет " + this.players[1].getSymbol());
        this.field = new Field();
    }
    public void play()
    {
        Player currentPlayer = this.getPlayer();
        do {
            int point[];
            do {
                point = this.getPoint(currentPlayer);
            } while (!this.field.setValue(point[0], point[1], currentPlayer.getSymbol()));
            field.printField();
            char winner = field.checkWinner();
            if (winner == Field.O || winner == Field.X) {
                System.out.println("Победил игрок играющий " + currentPlayer.getSymbol() + " " + currentPlayer.getName());
                return;
            }
            currentPlayer = this.nextPlayer(currentPlayer);
        } while (!this.field.isFull());
        System.out.println("Ничья");
    }

    private Player nextPlayer(Player currentPlayer)
    {
        if(currentPlayer.equals(this.players[0])) return this.players[1];
        return this.players[0];
    }

    public Player chooseFirstPlayer()
    {
        try {
            System.out.println("Введите кто ходит первым : [1]" + this.players[0].getName() +
                                  " или [2]" + this.players[1].getName());
            return this.scanner.nextInt() == 1 ? this.players[0] : this.players[1];
        } catch (Exception e) {
            System.out.println("Введите цифру 1 или 2");
        }
        return null;
    }
    private Player getPlayer()
    {
        Player currentPlayer = null;
        while(currentPlayer == null){
            currentPlayer = this.chooseFirstPlayer();
        }
        return currentPlayer;
    }
    private int[] getPoint(Player currentPlayer)
    {
        int point[];
        do {
            point = currentPlayer.makeTurn();
        } while (point == null);
        return point;
    }
}
