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

    public double calculateDeterminant(int[][] matrix) {
        try {
            if (matrix[0].length != matrix.length) {
                throw new Exception("For this  operation you need to use square matrix only!");
            }
        } catch (Exception ex) {
            ifException(ex);
        }
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        } else if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            double det = 0;
            for (int j = 0; j < n; j++) {
                int sign = (int) Math.pow(-1, j);
                double minor = calculateMinor(matrix, 0, j);
                det += (double)sign * (double)matrix[0][j] * minor;
            }
            return det;
        }
    }

    private double calculateMinor(int[][] matrix, int i, int j) {
        int[][] minor = new int[matrix.length - 1][matrix[0].length - 1];
        int minorRow = 0;
        for (int row_idx = 0; row_idx < matrix.length; row_idx++) {
            if (row_idx == i) {
                continue;
            }
            int minorCol = 0;
            for (int col_idx = 0; col_idx < matrix[row_idx].length; col_idx++) {
                if (col_idx == j) {
                    continue;
                }
                minor[minorRow][minorCol] = matrix[row_idx][col_idx];
                minorCol++;
            }
            minorRow++;
        }
        return calculateDeterminant(minor);
    }

    private void ifException(Exception ex) {
        System.out.println(ex.getMessage()); System.exit(1);
    }
}
