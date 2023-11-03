package MatrixProcessing;

public class Operations {
    public static int[][] matrixSum(int[][] matrix1, int[][] matrix2) {
        try {
            if ((matrix1.length != matrix2.length) || (matrix1[1].length != matrix2[1].length)) {
                throw new Exception("Dimensions are not the same!");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage()); System.exit(1);
        }
        int[][] finalMatrix = new int[matrix1.length][matrix1[0].length];
        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[0].length; col++) {
                finalMatrix[row][col] = matrix1[row][col] + matrix2[row][col];
            }
        }
        return finalMatrix;
    }
}
