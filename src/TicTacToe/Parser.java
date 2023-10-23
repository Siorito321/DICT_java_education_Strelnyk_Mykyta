package TicTacToe;

import java.lang.reflect.Array;
import java.util.Objects;

public class Parser {
    public char[][] turnStringToArr(String input) {
        String possibleError = Correctness(input);
        if (!Objects.equals(possibleError, "ok")) {
            System.out.println(possibleError);
        } else {
            int iterator = 0;
            char[][] answer = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int i1 = 0; i1 < 3; i1++) {
                    answer[i][i1] = input.charAt(iterator);
                    iterator++;
                }
            }
            return answer;
        }
        return new char[3][4];
    }

    public String Correctness(String input) {
        if (input.length() != 9) {
            return "Incorrect length";
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != 'x' && input.charAt(i) != '0' && input.charAt(i) != '_') {
                return "Incorrect symbols";
            }
        }
        int[] numberOfOccurrences = new int[2];
        char[] variants = {'x', '0'};
        for (int i = 0; i < 2; i++) {
            int count = 0;
            for (char c : input.toCharArray()) {
                if (c == variants[i]) {
                    count++;
                }
            }
            numberOfOccurrences[i] = count;
        }
        for (int i = 0; i < 2; i++) {
            if ((numberOfOccurrences[i] > 5) || (numberOfOccurrences[i] - numberOfOccurrences[(i + 1) % 2] > 1)) {
                return String.format("Unreal number of %s", variants[i]);
            }
        }
        return "ok";
    }
}
