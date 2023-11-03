package MatrixProcessing;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Parser parser = new Parser();
        Operations operations = new Operations();
        int[][] matrix1 = parser.basicParser();
        int[][] matrix2 = parser.basicParser();
        int[][] result = Operations.matrixSum(matrix1, matrix2);
        System.out.println("Here is your sum of those two matrices!");
        for (int i = 0; i < matrix1.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}

