package TicTacToe;
import java.util.Arrays;
import java.lang.reflect.Array;
import java.util.Arrays;

public class WinnerChooser {
    public char winnerIs(char[][] arr) {
        /*n - next move, d - draw, i-impossible*/

        System.out.println(Arrays.deepToString(arr));
        int[] helpVar = new int[2];
        /*allows to understand if there are double winners or other similar impossible scenarios*/
        char[] players = {'x', '0'};
        int iterator = 0;
            for (char player : players) {
                if (ifRow(arr, player)) {
                    helpVar[iterator]++;
                }
                if (ifColumn(arr, player)) {
                    helpVar[iterator]++;
                }
                if (ifDiagonal(arr, player)) {
                    helpVar[iterator]++;
                }
                iterator++;
            }
            if (!(helpVar[0] > 0 && helpVar[1] > 0)) {
                for (char player1 : players) {
                    if (ifSpaceLeft(arr)) {
                        return 'n';
                    }
                    if (ifRow(arr, player1)) {
                        return player1;
                    } else if (ifColumn(arr, player1)) {
                        return player1;
                    } else if (ifDiagonal(arr, player1)) {
                        return player1;
                    }
                }
            } else {
                return 'i';
        }
        return 'n';
    }

    private boolean ifRow(char[][] arr, char ch) {
        for (int i = 0; i < 3; i++) {
            int answer = 0;
            for (int i1 = 0; i1 < 3; i1++) {
                if (arr[i][i1] != '_') {
                    if (arr[i][i1] == ch) {
                        answer ++;
                    }
                }
                if (answer == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean ifColumn(char[][] arr, char ch) {
        int answer = 0;
        for (int i = 0; i < 3; i++) {
            for (int i1 = 0; i1 < 3; i1++) {
                if (arr[i1][i] != '_') {
                    if (arr[i1][i] == ch) {
                        answer ++;
                    }
                }
                if (answer == 3) {
                    return true;
                }
            }
            answer = 0;
        }
        return false;
    }

    private boolean ifDiagonal(char[][] arr, char ch) {
        int mainDiagonal = 0;
        int secondaryDiagonal = 0;
        for (int i = 0; i < 3; i++) {
            if (arr[i][i] != '_') {
                if (arr[i][i] == ch) {
                    mainDiagonal++;
                }
            }
            if (arr[i][2 - i] != '_') {
                if (arr[i][2 - i] == ch) {
                    secondaryDiagonal++;
                }
            }
        }
        return mainDiagonal == 3 || secondaryDiagonal == 3;
    }

    private boolean ifSpaceLeft(char[][] arr) {
        for (int i = 0; i < 3; i++) {
            for (int i1 = 0; i1 < 3; i1++) {
                if (arr[i][i1] == '_') {
                    return true;
                }
            }
        }
        return false;
    }
}
