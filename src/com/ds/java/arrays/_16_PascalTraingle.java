package com.ds.java.arrays;

import java.util.ArrayList;
import java.util.List;

public class _16_PascalTraingle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> pascalTriangle(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        // Fill the triangle with Pascal's Triangle values
        for (int i = 0; i < numRows; i++) {
            
            /* Create a new row list and
            resize it to i + 1 elements*/
            List<Integer> row = new ArrayList<>();
            
            for (int j = 0; j <= i; j++) {
                //Compute and store value at position (i, j)
                row.add(nCr(i, j));
            }
            triangle.add(row);
        }

        // Return completed Pascal's Triangle
        return triangle;
    }

    private int nCr(int n, int r) {
        
        /* Choosing the smaller value
           of r to optimize computation */
        if (r > n - r) {
            r = n - r;
        }
        
        long res = 1;
        /* Calculate nCr using iterative
           method to avoid overflow */
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return (int)res;
    }
    
    private long nCr1(int n, int r) {
        long res = 1;

        // Calculate nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }
    
    
    private List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        // Inserting the 1st element
        ansRow.add(1);

        // Calculate the rest of the elements
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int) ans);
        }
        return ansRow;
    }

    /* Function to generate Pascal's
    Triangle up to n rows*/
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        // Store the entire Pascal's Triangle
        for (int row = 1; row <= n; row++) {
            pascalTriangle.add(generateRow(row));
        }

        // Return the Pascal's Triangle
        return pascalTriangle;
    }

}
