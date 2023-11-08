package MatrixProcessing;
import java.util.Scanner;

public class Parser {

    public double[][] basicParser() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of dimensions (example: \"1 3\")");
        String[] dimensionsBuffer = scanner.nextLine().split(" ");

        try {if (dimensionsBuffer.length != 2) {throw new Exception("Enter two numbers of dimensions!");} }
        catch (Exception ex) {ifException(ex);}

        int[] dimensions = new int[2];
        for (int i = 0; i < dimensions.length; i++) {
            try{dimensions[i] = Integer.parseInt(dimensionsBuffer[i]);}
            catch (java.lang.NumberFormatException e) {System.out.println("You should enter two numbers!");
                System.exit(1);}
        }
        double[][] matrix = new double[dimensions[0]][dimensions[1]];
        String[] matrixString = new String[dimensions[0]];
        for (int i = 0; i < matrixString.length; i++) {
            System.out.printf("Enter the %d row: %n", i + 1);
            String row = scanner.nextLine();
            try {matrix[i] = stringToArray(row, dimensions[1]);}
            catch (Exception ex) {ifException(ex);}
        }
        try {
            for (int i = 0; i < dimensions[0]; i++) {
                if (matrix[i].length != dimensions[1]) {
                    throw new Exception(String.format("Incorrect number of elements in a row %d", i+1));
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }
        return matrix;
    }
    private static double[] stringToArray(String str, int dim) throws Exception {
        String[] numbersArray = str.split(" ");
        if (numbersArray.length != dim) {throw new Exception("Incorrect number of numbers");}
        double[] finalRow = new double[numbersArray.length];
        for (int i = 0; i < numbersArray.length; i++) {
            try {
                if (!numbersArray[i].matches("[0-9]+")) {
                    throw new Exception("You should enter only numbers!");
                }  else {
                    finalRow[i] = Double.parseDouble(numbersArray[i]);
                }
            } catch (Exception ex) {
                ifException(ex);
            }
        }
        return finalRow;
    }

    private static void ifException(Exception ex) {
        System.out.println(ex.getMessage()); System.exit(1);
    }

}
