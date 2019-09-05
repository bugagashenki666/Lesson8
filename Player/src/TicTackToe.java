import java.util.Scanner;

public class TicTackToe {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true)
        {
            Controller controller = new Controller();
            controller.play();
            System.out.println("Хотите сыграть еще раз [y] or [n]: ");
            if(sc.next().trim().toLowerCase().equals("n")) return;
        }
    }
}
