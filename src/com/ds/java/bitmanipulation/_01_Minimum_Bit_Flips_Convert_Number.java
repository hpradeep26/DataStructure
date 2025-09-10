package com.ds.java.bitmanipulation;

public class _01_Minimum_Bit_Flips_Convert_Number {

	public static void main(String[] args) {
		System.out.println(minBitsFlip(10, 7));

	}
	
	
	 // i % 2 == i & 1
	 // num>>1 = num / 2
	 public static int minBitsFlip(int start, int goal) {
		 /* Variable to store bits that
	        are different in both numbers */
		 int num = start ^ goal;
		 /* Variable to count 
	        number of set bits */
		 int count = 0;
		 
		 //32 bit due to integer
		 for(int i =0;i<32;i++ ) {
			  /* Update count if the 
	            rightmost bit is set */
			 count += (num & 1); 
			 /* Shift the number every 
	            time by 1 place */
			 num = num>>1;
		 }
		 
		 return count;
		 
	 }
	 
	 
	 public static int minBitsFlipOptimal(int start, int goal) {
		 /* Variable to store bits that
	        are different in both numbers */
		 int num = start ^ goal;
		 /* Variable to count 
	        number of set bits */
		 int count = 0;

		 while(num != 0) {
			 if(num % 2 == 1) 
				 count++;
			 num = num / 2;
		 }
		 return count;

	 }

}
