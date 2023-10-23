package TicTacToe;
import java.lang.reflect.Array;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter cells: ");
            String answer = scanner.nextLine();
            Parser parser = new Parser();
            Grid grid = new Grid();
            WinnerChooser winnerChooser = new WinnerChooser();
            char[][] formAnswer = parser.turnStringToArr(answer);
            if (formAnswer[1].length == 4) {
                continue;
            }
            grid.printGrid(formAnswer);
            char helpVar = winnerChooser.winnerIs(formAnswer);
            if (helpVar == 'i') {
                System.out.println("Impossible");
                continue;
            }
            if (helpVar == 'n') {
                System.out.println("Game is incomplete!");
                break;
            } else if (helpVar == 'd') {
                System.out.println("It`s a draw!");
                break;
            }
            System.out.println("The winner is " + helpVar);
        }
    }
}
