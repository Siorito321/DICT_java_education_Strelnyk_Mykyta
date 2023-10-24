package TicTacToe;
import java.lang.reflect.Array;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args){
        char[] players = {'0', 'x'};
        int iter = 0;
        char[][] playGrid = {{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}};
        System.out.println("Welcome to TicTacToe kids!");
        System.out.println("The game starts right now");
        while (true) {
            iter++;
            iter = iter % 2;
            System.out.println("It's a " + players[iter] + " move now!");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your coordinate: ");
            String answer = scanner.nextLine();
            char[] coord = answer.toCharArray();
            Parser parser = new Parser();
            Grid grid = new Grid();
            WinnerChooser winnerChooser = new WinnerChooser();
            char[][] formAnswer = parser.turnCoordToElement(playGrid, coord, players[iter]);
            if (formAnswer[1].length == 4) {
                iter--;
                continue;
            }
            playGrid = formAnswer;
            grid.printGrid(playGrid);
            char helpVar = winnerChooser.winnerIs(playGrid);
            if (helpVar == 'n') {
                System.out.println("Now next player should enter his coordinates!");
                continue;
            } else if (helpVar == 'd') {
                System.out.println("It`s a draw!");
                break;
            }
            System.out.println("The winner is " + helpVar);
            System.exit(0);
        }
    }
}
