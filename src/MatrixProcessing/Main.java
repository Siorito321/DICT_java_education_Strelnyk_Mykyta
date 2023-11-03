package MatrixProcessing;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Parser parser = new Parser();
        operations operations = new operations();
        Scanner scanner = new Scanner(System.in);
        int[][] matrix1 = parser.basicParser();
        char operation;
        System.out.println("Choose the operation you want to perform");
        System.out.println("1 - Sum of two matrices, 2 - Multiply matrix by constant, 3 - Multiply matrix by matrix");
        System.out.println("4 - Transpose the matrix");
        operation = scanner.nextLine().charAt(0);

        switch (operation) {
            case '1':
                int[][] matrix2 = parser.basicParser();
                int[][] result = operations.matrixSum(matrix1, matrix2);
                System.out.println("Here is the sum of those two matrices:");
                for (int i = 0; i < matrix1.length; i++) {
                    System.out.println(Arrays.toString(result[i]));
                }
                break;
            case '2':
                System.out.print("Enter your constant: ");
                int constanta = scanner.nextInt();
                int[][] result1 = operations.matrixOnConstant(matrix1, constanta);
                System.out.println("Here is the result of multiplying the matrix by the constant:");
                for (int i = 0; i < matrix1.length; i++) {
                    System.out.println(Arrays.toString(result1[i]));
                }
                break;
            case '3':
                int[][] matrix3 = parser.basicParser();
                int[][] result2 = operations.matrixOnMatrix(matrix1, matrix3);
                System.out.println("Here is the result of multiplication of those two matrices:");
                for (int i = 0; i < matrix1.length; i++) {
                    System.out.println(Arrays.toString(result2[i]));
                }
                break;
            case '4':
                System.out.println("Choose what kind of transposition you would like to perform:");
                System.out.println("1-By main diagonal, 2-By secondary diagonal, 3-By vertical, 4-By horizontal");
                char transpositionType = scanner.nextLine().charAt(0);
                switch (transpositionType) {
                    case '1':
                        System.out.println("Here is the result of transposing matrix by main diagonal");
                        int[][] result4 = operations.transposeByMain(matrix1);
                        for (int[] value : result4) {
                            System.out.println(Arrays.toString(value));
                        }
                        break;
                    case '2':
                        System.out.println("Here is the result of transposing matrix by Secondary diagonal");
                        int[][] result5 = operations.transposeBySecondary(matrix1);
                        for (int[] ints : result5) {
                            System.out.println(Arrays.toString(ints));
                        }
                        break;
                    case '3':
                        System.out.println("Here is the result of transposing matrix by vertical");
                        int[][] result6 = operations.transposeByVertical(matrix1);
                        for (int[] ints : result6) {
                            System.out.println(Arrays.toString(ints));
                        }
                        break;
                    case '4':
                        System.out.println("Here is the result of transposing matrix by horizontal:");
                        int[][] result7 = operations.transposeByHorizontal(matrix1);
                        for (int[] ints : result7) {
                            System.out.println(Arrays.toString(ints));
                        }
                        break;
                    default:
                        System.out.println("Invalid operation choice");
                        break;
                }
                break;
        }
    }
}
