package com.ds.java.recursion;

public class _11_PowerOfN {

	public static void main(String[] args) {
		System.out.println(myPow(2.00000, -2));

	}
	
	public static double myPow(double x, int n) {
        // If 'n' is negative
        if (n < 0) {
            // Calculate the power of -n and take reciprocal
            return 1.0 / power(x, -n);
        }
        
        // If 'n' is non-negative
        return power(x, n);
    }

	private static double power(double x, long n) {
        // Base case: anything raised to 0 is 1
        if (n == 0) return 1.0;
        
        // Base case: anything raised to 1 is itself
        if (n == 1) return x;
        
        // If 'n' is even
        if (n % 2 == 0) {
            // Recursive call: x * x, n / 2
            return power(x * x, n / 2);
        }
        
        // If 'n' is odd
        // Recursive call: x * power(x, n - 1)
        return x * power(x, n - 1);
    }
}
