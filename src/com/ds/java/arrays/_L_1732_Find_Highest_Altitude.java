package co.ds.java.leetcode75.prefixsum;

public class _L_1732_Find_Highest_Altitude {

	public static void main(String[] args) {
		/*
		 * Input: gain = [-5,1,5,0,-7] 
		 * Output: 1 Explanation: The altitudes are  [0,-5,-4,1,1,-6]. The highest is 1
		 * 
		 * Input: gain = [-4,-3,-2,-1,4,3,2] Output: 0
		 *  Explanation: The altitudes are  [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
		 */
	}
	
	public int largestAltitude(int[] gain) {
        int length = gain.length;
        int max = 0;
        int[] prefix = new int[length+1];
        for(int i = 1;i<=length;i++){
            prefix[i] = prefix[i-1] + gain[i-1];
            max = Math.max(prefix[i],max);
        }
        return max;
    }

}
