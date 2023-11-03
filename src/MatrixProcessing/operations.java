package MatrixProcessing;

public class operations {
    public int[][] matrixSum(int[][] matrix1, int[][] matrix2) {
        try {
            if ((matrix1.length != matrix2.length) || (matrix1[1].length != matrix2[1].length)) {
                throw new Exception("Dimensions are not the same!");
            }
        } catch (Exception ex) {
            ifException(ex);
        }
        int[][] finalMatrix = new int[matrix1.length][matrix1[0].length];
        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[0].length; col++) {
                finalMatrix[row][col] = matrix1[row][col] + matrix2[row][col];
            }
        }
        return finalMatrix;
    }

    public int[][] matrixOnConstant(int[][] matrix, int constanta) {
        int[][] finalMatrix = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                finalMatrix[row][col] = matrix[row][col] * constanta;
            }
        }
        return finalMatrix;
    }

    public int[][] matrixOnMatrix(int[][] matrix1, int[][] matrix2) {
        try {
            if (matrix2.length != matrix1[0].length) {
                throw new IllegalArgumentException("These matrices cannot be multiplied!");
            }
        } catch (Exception ex) {
            ifException(ex);
        }

        int[][] finalMatrix = new int[matrix1.length][matrix2[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix2.length; k++) {
                    finalMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return finalMatrix;
    }


    public int[][] transposeByMain(int[][] matrix) {
        int[][] finalMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int b = 0; b < matrix[0].length; b++) {
                finalMatrix[b][i] = matrix[i][b];
            }
        }
        return finalMatrix;
    }

    public int[][] transposeBySecondary(int[][] matrix) {
        try {
            if (matrix[0].length != matrix.length) {
                throw new Exception("For this  operation you need to use square matrix only!");
            }
        } catch (Exception ex) {
            ifException(ex);
        }
        int[][] finalMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int b = 0; b < matrix.length; b++) {
                finalMatrix[matrix.length-i-1][matrix.length-1-b] = matrix[i][b];
            }
        }
        return finalMatrix;
    }

    public int[][] transposeByVertical(int[][] matrix) {
        try {
            if (matrix[0].length != matrix.length) {
                throw new Exception("For this  operation you need to use square matrix only!");
            }
        } catch (Exception ex) {
            ifException(ex);
        }
        int[][] finalMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int b = 0; b < matrix.length; b++) {
                finalMatrix[i][matrix.length-1-b] = matrix[i][b];
            }
        }
        return finalMatrix;
    }

    public int[][] transposeByHorizontal(int[][] matrix) {
        try {
            if (matrix[0].length != matrix.length) {
                throw new Exception("For this  operation you need to use square matrix only!");
            }
        } catch (Exception ex) {
            ifException(ex);
        }
        int[][] finalMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                finalMatrix[i][j] = matrix[i][matrix.length - j - 1];
            }
        }
        return finalMatrix;
    }
    private void ifException(Exception ex) {
        System.out.println(ex.getMessage()); System.exit(1);
    }
}
