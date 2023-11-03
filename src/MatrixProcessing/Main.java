package MatrixProcessing;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Parser parser = new Parser();
        Operations operations = new Operations();
        Scanner scanner = new Scanner(System.in);
        int[][] matrix1 = parser.basicParser();
        char operation;
        System.out.println("Choose the operation you want to perform");
        System.out.println("1 - Sum of two matrices, 2 - Multiply matrix by constant");
        operation = scanner.nextLine().charAt(0);

        switch (operation) {
            case '1':
                int[][] matrix2 = parser.basicParser();
                int[][] result = Operations.matrixSum(matrix1, matrix2);
                System.out.println("Here is the sum of those two matrices:");
                for (int i = 0; i < matrix1.length; i++) {
                    System.out.println(Arrays.toString(result[i]));
                }
                break;
            case '2':
                System.out.print("Enter your constant: ");
                int constanta = scanner.nextInt();
                int[][] result1 = Operations.matrixOnConstant(matrix1, constanta);
                System.out.println("Here is the result of multiplying the matrix by the constant:");
                for (int i = 0; i < matrix1.length; i++) {
                    System.out.println(Arrays.toString(result1[i]));
                }
                break;
            default:
                System.out.println("Invalid operation choice");
        }
    }
}
