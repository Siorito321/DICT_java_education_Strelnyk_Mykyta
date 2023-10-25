package TicTacToe;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Grid {
    private String row(char[] arr) {
        StringBuilder answer = new StringBuilder();
        answer.append("|");
        for (int i = 0; i != 3; i++) {
            answer.append(arr[i]);
        }
        answer.append("|");
        return answer.toString();
    }

    String[] grid(char[][] arr) {
        String[] answer = new String[5];
        StringBuilder decorRow = new StringBuilder();
        for (int i = 0; i != 6; i++) {
            decorRow.append("_");
        }
        String horizontalLine = decorRow.toString();
        answer[0] = horizontalLine;
        for (int i = 1; i < 4; i++) {
            StringBuilder currentRow = new StringBuilder();
            currentRow.append(row(arr[i - 1]));
            answer[i] = currentRow.toString(); // Change this line to use the correct index
        }
        answer[4] = horizontalLine;
        return answer;
    }

    public void printGrid(char[][] arr) {
        String[] answer = grid(arr);
        for (int i = 0; i != 5; i++) {
            System.out.println(answer[i]);
        }
    }
}
