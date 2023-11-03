package MatrixProcessing;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Parser parser = new Parser();
        int[][] matrix = parser.basicParser();
        System.out.println("Matrix processed successfully!");
        for (int i=0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}

