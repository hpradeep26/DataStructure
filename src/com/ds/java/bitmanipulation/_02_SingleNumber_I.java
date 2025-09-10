package com.ds.java.bitmanipulation;

public class _02_SingleNumber_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i=0;i< nums.length ; i++){
            ans = ans ^ nums[i];
        }
        return ans;
    }

}
