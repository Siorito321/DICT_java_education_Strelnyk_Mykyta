package TicTacToe;

import java.lang.reflect.Array;
import java.util.Objects;

public class Parser {
    public char[][] turnCoordToElement(char[][] input, char[] coord, char player) {
        String possibleError = Correctness(input, coord);
        if (!Objects.equals(possibleError, "ok")) {
            System.out.println(possibleError);
        } else {
            input[Integer.parseInt(String.valueOf(coord[0])) - 1][Integer.parseInt(String.valueOf(coord[1])) - 1] = player;
            return input;
        }
        return new char[3][4];
    }

    private String Correctness(char[][] arr, char[] input) {
        if (input.length > 2 | input.length < 2) {
            return "Incorrect coordinates";
        }
        Integer[] inputInt = new Integer[2];
        for (int i = 0; i < 2; i++) {
            if (!(Character.isDigit(input[i]))) {
                return "You should enter numbers!";
            }
            inputInt[i] = Integer.parseInt(String.valueOf(input[i])) - 1;
            if (inputInt[i] > 2 | inputInt[i] < 0) {
                return "You should enter coordinates from 1 to 3!";
            }
        }

        if (arr[inputInt[0]][inputInt[1]] != '_') {
            return "This cell is occupied";
        }
        return "ok";
    }
}
