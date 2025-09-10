package com.ds.java.binarysearch;

public class _17_BookAllocationProblem {

	public static void main(String[] args) {
		int[] nums = {12, 34, 67, 90}; int m=2;
				//Output: 113
		//Input: nums = [25, 46, 28, 49, 24], m=4
			//Output: 71
		System.out.println(findPagesBinarySearch(nums, m));
	}
	
	public static int findPages(int[] nums, int m) {
		   int ans = -1;
		   int n = nums.length;
		   if(m>n) {
			   return -1;
		   }
		   
		   // Calculate the range for search
	        int low = Integer.MIN_VALUE;
	        int totalSum = 0;
	        for(int i = 0; i < n; i++){
	            low = Math.max(low, nums[i]);
	            totalSum = totalSum + nums[i];
	        }
	        for (int pages = low; pages <= totalSum; pages++) {
	            if (countStudents(nums, pages) == m) {
	                return pages;
	            }
	        }
		   return low;
    }
	
	public static int findPagesBinarySearch(int[] nums, int m) {
		   int n = nums.length;
		   if(m>n) {
			   return -1;
		   }
		   
		   // Calculate the range for search
	        int low = Integer.MIN_VALUE;
	        int high = 0;
	        for(int i = 0; i < n; i++){
	            low = Math.max(low, nums[i]);
	            high = high + nums[i];
	        }
	        while(low <=high ) {
	        	int mid = low + (high - low)/2;
	        	 int students = countStudents(nums, mid);
	             if (students > m) {
	                 low = mid + 1;
	             }else {
	                 high = mid - 1;
	             }
	        }
		   return low;
 }

	private static int countStudents(int[] nums, int pages) {
		// Size of array
        int n = nums.length;
        
        int students = 1;
        int pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if (pagesStudent + nums[i] <= pages) {
                // Add pages to current student
                pagesStudent += nums[i];
            } else {
                // Add pages to next student
                students++;
                pagesStudent = nums[i];
            }
        }
        return students;
	}

}
