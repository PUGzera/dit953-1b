package com.company;

import static java.lang.Math.*;

/**
 * Class for vectors and common vector operations
 * @author pugzera
 * @version 1.0
 */
public class Vector {
    /**
     * a list with this instance's x, y, z coordinates
     */
    private double[][] currentVector;
    /**
     * amount of rotation in radians
     */
    private double rotationFactor = PI / 6;

    public Vector(double x, double y, double z) {
        this.currentVector = new double[][]{{x}, {y}, {z}};
    }

    public double[][] getCurrentVector() {
        return currentVector;
    }

    public void setCurrentVector(double[][] currentVector) {
        this.currentVector = currentVector;
    }

    public double getRotationFactor() {
        return rotationFactor;
    }

    public void setRotationFactor(double rotationFactor) {
        this.rotationFactor = rotationFactor;
    }

    public double[][] getTransformationMatrix(){
        return matrixMul(identityMatrix, currentVector);
    }

    /**
     * rotation matrix for rotation around Z-axis
     * @param radian rotation amount in radians
     * @return rotated matrix
     */
    public static double[][] getRotationMatrix(double radian) {
        return new double[][]{
                {cos(radian), -sin(radian), 0},
                {sin(radian), cos(radian), 0},
                {0, 0, 1}
        };
    }

    /**
     * The 3x3 identity or unit matrix
     * @see <a href="https://en.wikipedia.org/wiki/Identity_matrix" >The wikipedia entry for unit matrices</a>
     */
    private final static double[][] identityMatrix = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
    };

    /**
     * performs scalar multiplication with a matrix and a scalar
     * @param matrix an arbitrary matrix
     * @param scalar an arbitrary scalar
     * @return the scalar multiplied vector
     */
    public static double[][] multiplicationWithScalar(double[][] matrix, double scalar) {
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                matrix[i][j] *= scalar;
            }
        }
        return matrix;
    }

    /**
     * note: a[x].length must equal b.length (the number of columns in a must equal the number of rows in b)
     * @param a an arbitrary matrix
     * @param b an arbitrary matrix
     * @return the result of matrix a multiplied with matrix b
     */
    // based on https://stackoverflow.com/a/17624210/9044310
    public static double[][] matrixMul(double[][] a, double[][] b) {

        int aRows = a.length;
        int aColumns = a[0].length;
        int bRows = b.length;
        int bColumns = b[0].length;

        if (aColumns != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        }

        double[][] c = new double[aRows][bColumns];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                c[i][j] = 0.00000;
            }
        }

        for (int i = 0; i < aRows; i++) { // aRow
            for (int j = 0; j < bColumns; j++) { // bColumn
                for (int k = 0; k < aColumns; k++) { // aColumn
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return c;
    }

    /**
     * Transposes matrix
     * @param a an arbitrary matrix
     * @return transposed form of matrix a
     */
    public static double[][] transpose(double[][] a){
        int rows = a.length;
        int cols = a[0].length;
        double[][] temp = new double[cols][rows];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                temp[j][i] = a[i][j];
            }
        }
        return temp;
    }
}
