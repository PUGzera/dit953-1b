package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VectorTest {

    private Vector unitVector;

    @Before
    public void vectorInstance() {
        unitVector = new Vector(1,0,0);
    }

    // ---------------
    // Vector Rotation
    // ---------------
    @Test
    public void rotationVector1Radian() {
        double rotAm = 1;
        double[][] actual = Vector.getRotationMatrix(rotAm);
        double[][] expected = {
                {Math.cos(rotAm), -Math.sin(rotAm), 0},
                {Math.sin(rotAm), Math.cos(rotAm), 0},
                {0, 0, 1}};
        Assert.assertArrayEquals(actual, expected);
    }

    @Test
    public void rotationVector0Radian() {
        double rotAm = 0;
        double[][] actual = Vector.getRotationMatrix(rotAm);
        double[][] expected = {
                {Math.cos(rotAm), -Math.sin(rotAm), 0},
                {Math.sin(rotAm), Math.cos(rotAm), 0},
                {0, 0, 1}};
        Assert.assertArrayEquals(actual, expected);
    }

    @Test
    public void rotationVectorNegative1Radian() {
        double rotAm = -1;
        double[][] actual = Vector.getRotationMatrix(rotAm);
        double[][] expected = {
                {Math.cos(rotAm), -Math.sin(rotAm), 0},
                {Math.sin(rotAm), Math.cos(rotAm), 0},
                {0, 0, 1}};
        Assert.assertArrayEquals(actual, expected);
    }

    @Test
    public void rotationVectorNegativeHalfARadian() {
        double rotAm = 0.5;
        double[][] actual = Vector.getRotationMatrix(rotAm);
        double[][] expected = {
                {Math.cos(rotAm), -Math.sin(rotAm), 0},
                {Math.sin(rotAm), Math.cos(rotAm), 0},
                {0, 0, 1}};
        Assert.assertArrayEquals(actual, expected);
    }

    // ---------------------
    // Matrix Multiplication
    // ---------------------
    @Test
    public void vectorMultipliedWithRotationMatrix() {
        double[][] rotationMatrix = Vector.getRotationMatrix(Math.PI/6);
        double[][] actual = Vector.matrixMul(rotationMatrix, unitVector.getCurrentVector());
        double[][] expected = new double[][]{{Math.sqrt(3)/2}, {0.5}, {0}};
        for(int i = 0; i < actual.length; i++) {
            Assert.assertArrayEquals(expected[i], actual[i], 0.002);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void vectorMultipliedWithVectorOfInvalidShape() {
        double[][] vectorMatrix = new Vector(1,1,0).getCurrentVector();
        Vector.matrixMul(vectorMatrix, unitVector.getCurrentVector()); // Should throw
    }

    @Test
    public void vectorMultipliedWithMatrix() {
        double[][] matrix = new double[][] {{3,5,7}};
        double[][] actual = Vector.matrixMul(unitVector.getCurrentVector(), matrix);
        double[][] expected = {{3,5,7},{0,0,0},{0,0,0}};
        for(int i = 0; i < actual.length; i++) {
            Assert.assertArrayEquals(expected[i], actual[i], 0.002);
        }
    }

    @Test
    public void matrixMultipliedWithMatrix() {
        double[][] firstMatrix = new double[][] {{1,2,3},{1,0,1},{0,0,1}};
        double[][] secondMatrix = new double[][] {{3,1,6},{0,0,-1},{-5,2,1}};
        double[][] actual = Vector.matrixMul(firstMatrix, secondMatrix);
        double[][] expected = new double[][] {{-12,7,7},{-2,3,7},{-5,2,1}};
        for(int i = 0; i < actual.length; i++) {
            Assert.assertArrayEquals(expected[i], actual[i], 0.002);
        }
    }

    // ---------------------
    // Scalar Multiplication
    // ---------------------
    @Test
    public void scalarMulBy0() {
        double scalar = 0;
        double[][] actual = Vector.multiplicationWithScalar(unitVector.getCurrentVector(), scalar);
        double[][] expected = new double[][]{{0}, {0}, {0}};
        for(int i = 0; i < actual.length; i++) {
            Assert.assertArrayEquals(expected[i], actual[i],0.02);
        }
    }

    @Test
    public void scalarMulBy1() {
        double scalar = 1;
        double[][] actual = Vector.multiplicationWithScalar(unitVector.getCurrentVector(), scalar);
        double[][] expected = new double[][]{{1}, {0}, {0}};
        for(int i = 0; i < actual.length; i++) {
            Assert.assertArrayEquals(expected[i], actual[i],0.02);
        }
    }

    @Test
    public void scalarMulByNegative1() {
        double scalar = -1;
        double[][] actual = Vector.multiplicationWithScalar(unitVector.getCurrentVector(), scalar);
        double[][] expected = new double[][]{{-1}, {0}, {0}};
        for(int i = 0; i < actual.length; i++) {
            Assert.assertArrayEquals(expected[i], actual[i],0.02);
        }
    }

    @Test
    public void scalarMulBy23() {
        double scalar = 23;
        double[][] actual = Vector.multiplicationWithScalar(unitVector.getCurrentVector(), scalar);
        double[][] expected = new double[][]{{23}, {0}, {0}};
        for(int i = 0; i < actual.length; i++) {
            Assert.assertArrayEquals(expected[i], actual[i],0.02);
        }
    }

    @Test
    public void scalarMulByNegative12() {
        double scalar = -12;
        double[][] actual = Vector.multiplicationWithScalar(unitVector.getCurrentVector(), scalar);
        double[][] expected = new double[][]{{-12}, {0}, {0}};
        for(int i = 0; i < actual.length; i++) {
            Assert.assertArrayEquals(expected[i], actual[i],0.02);
        }
    }

    // ---------
    // Transpose
    // ---------
    @Test
    public void transpose3x4Matrix(){
        double[][] actual = Vector.transpose(new double[][]{
                {5, 11, 2},
                {1, -2, 4},
                {22, 6, 9},
                {44, 0, 0}
        });
        double[][] expected = new double[][]{
                {5, 1, 22, 44},
                {11, -2, 6, 0},
                {2, 4, 9, 0}
        };
        for(int i = 0; i < actual.length; i++) {
            Assert.assertArrayEquals(expected[i], actual[i],0);
        }
    }

    @Test
    public void transposeVector() {
        double[][] actual = Vector.transpose(unitVector.getCurrentVector());
        double[][] expected = new double[][] {
                {1,0,0}
        };
        for(int i = 0; i < actual.length; i++) {
            Assert.assertArrayEquals(expected[i], actual[i],0);
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void transposeNonSquareMatrix() {
        double[][] matrix = {
                {1,2,3},
                {1,2}
        };
        Vector.transpose(matrix);
    }

    @Test
    public void transpose3x1Matrix() {
        double[][] matrix = {
                {1,2,3}
        };
        double[][] actual = Vector.transpose(matrix);
        double[][] expected = {
                {1},
                {2},
                {3}
        };
        for(int i = 0; i < actual.length; i++) {
            Assert.assertArrayEquals(expected[i], actual[i],0);
        }
    }

    //
    //
    //

}
