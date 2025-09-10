package com.ds.java.arrays;

public class _33_CheckIfArraySortedAndRotated {

	public static void main(String[] args) {
		//nums = [3,4,5,1,2] output = true
		//Explanation: [1,2,3,4,5] is the original sorted array.
		//You can rotate the array by x = 3 positions to begin on the element of value 3: [3,4,5,1,2].
		//[2,1,3,4] o/p false
		// There is no sorted array once rotated that can make 
	}
	
	public boolean check(int[] nums) {
        int count =0;
        for(int i=0;i< nums.length-1;i++){
             if(nums[i]>nums[i+1]){
                count++;
            }
         }
        if (count>1){ // if array is rotated only one number will be greater
            return false;
        } if(nums[nums.length-1]>nums[0] && count!=0){
            return false;
        }
        return true;
    }

}
