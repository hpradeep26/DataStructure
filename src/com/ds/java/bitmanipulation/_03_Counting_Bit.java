package com.ds.java.bitmanipulation;

import java.util.Arrays;

public class _03_Counting_Bit {

	public static void main(String[] args) {
		//Input: n = 2
		//Output: [0,1,1]
		// i/p n = 5
		//o/p [0,1,1,2,1,2] 
		//0 --> 0
		//1 --> 1
		//2 --> 10
		//3 --> 11
		//4 --> 100
		//5 --> 101
		System.out.println(Arrays.toString(countBits(5)));

	}
	
	 public static int[] countBits(int n) {
         int[] f = new int[n + 1];
          for (int i=1; i<=n; i++){
            f[i] = f[i / 2] + i % 2;
            //f[i] = f[i >> 1] + (i & 1);
          }
       return f;
   }

}
