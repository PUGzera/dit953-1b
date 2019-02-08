package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	    Vector v = new Vector(0, 0, 0);
	    double[][] yeet = Vector.matrixMul(new double[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}, {1, 2, 3}},
				new double[][]{{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}});
    }
    JFrame jFrame = new JFrame();


	public void printMatrix(double[][] matrix) {
		for (double[]a:matrix){
			for(double b:a) {
				System.out.print(b + " ");
			}
			System.out.println();

		}
	}
}
