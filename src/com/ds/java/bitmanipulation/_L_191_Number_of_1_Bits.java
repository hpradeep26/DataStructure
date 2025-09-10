package com.ds.java.bitmanipulation;

public class _L_191_Number_of_1_Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int hammingWeight(int num) {
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
	
	public int hammingWeightOptimal(int num) {
        int count = 0;
       while(num != 0) {
			 if(num % 2 == 1) 
				 count++;
			 num = num / 2;
		 }
        return count;
   }

}
