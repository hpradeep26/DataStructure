package com.ds.java.dp;

public class _L_1137_Nth_Tribonacci_Number {

	public static void main(String[] args) {
		//Input: n = 4 Output: 4
		//Input: n = 25 Output: 1389537
		int n = 25;
		System.out.println(tribonacci(n));
	}
	
	public static int tribonacci(int n) {
		if(n==0) {
			return 0;
		}
		
		if(n==1||n==2) {
			return 0;
		}
		
		int[] dp = new int[n+1];
		dp[1]= 1;
		dp[2]= 1;
		
		for(int i = 3 ; i <= n ; i++) {
			dp[i] = dp[i-1]+ dp[i-2] + dp[i-3];
		}
		
		return dp[n];
	}

}
