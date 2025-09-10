package com.ds.java.binarysearch;

public class _10_SingleElementInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int singleNonDuplicate(int[] nums) {
		int ans = 0;
		// XOR all the elements:
		for (int i = 0; i < nums.length; i++) {
			ans = ans ^ nums[i];
		}
		return ans;
	}
	
	
	public static int singleNonDuplicateBS(int[] nums) {
		int n = nums.length;
		//edge cases
		if(nums.length==1) return nums[0];
		if(nums[0]!=nums[1]) return nums[0];
		if (nums[n - 1] != nums[n - 2]) return nums[n - 1];
		
		int low = 1;int high = n - 2;
		
		while(low <= high) {
			int mid = low + (high - low)/2;
			// If nums[mid] is the single element:
			if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1]) {
				return nums[mid];
			}
			
			 // We are in the left part:
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1])
                || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                // Eliminate the left half:
                low = mid + 1;
            }
            // We are in the right part:
            else {
                // Eliminate the right half:
                high = mid - 1;
            }
		}
		return -1;
	}
	
	public int singleNonDuplicate1(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = (left + right)/2;
            if( (mid % 2 == 0 && nums[mid] == nums[mid +1]) || (mid %2 == 1 && nums[mid] == nums[mid - 1]) )
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }   

}
