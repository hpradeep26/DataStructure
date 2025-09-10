package com.ds.java.binarysearch;

public class _15_Minimum_Number_of_Days_to_Make_m_Bouquets {
	//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
	public static void main(String[] args) {
		int[] arr = {7, 7, 7, 7, 13, 11, 12, 7}; 
		System.out.println(minDays(arr, 2, 3));
	}
	
	private static int minDays(int[] bloomDay, int m, int k) {
		int noOfflower = bloomDay.length;
        /* Calculate the minimum 
        number of flowers required*/
        long totalFlowerRequired = m*k;
        /* Impossible case: not enough 
        flowers to make m bouquets*/
        if(totalFlowerRequired > noOfflower) {
        	return -1;
        }
        
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int i = 0; i < noOfflower; i++) {
        	low = Math.min(low, bloomDay[i]); 
        	high = Math.max(high, bloomDay[i]); 
        }
        int ans = -1;
        while(low<=high) {
        	int mid = low + (high - low)/2;
        	if(possibleBouque(bloomDay,mid,m,k)) {
        		ans = mid;
        		high = mid - 1;
        	}else {
        		low = mid + 1;
        	}
        }
        
		return ans;
	}
	
	public static boolean possibleBouque(int[] nums,int day,int m,int k){
		int count = 0;
		int bouqets = 0;
		for (int i = 0; i < nums.length; i++) {
			 if (nums[i] <= day) {
				 count++;
			 }else {
				 bouqets += (count / k);
				 count=0;
			 }
		}
		 bouqets += (count / k);
		// System.out.println(bouqets);
		 return bouqets >= m; 
	}

	public static int minDaysLinaearSearch(int[] bloomDay, int m, int k) {
        int noOfflower = bloomDay.length;
        /* Calculate the minimum 
        number of flowers required*/
        long totalFlowerRequired = m*k;
        /* Impossible case: not enough 
        flowers to make m bouquets*/
        if(totalFlowerRequired > noOfflower) {
        	return -1;
        }
        /* Find maximum and minimum
        bloom days in the array */
     int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
     for (int i = 0; i < noOfflower; i++) {
         mini = Math.min(mini, bloomDay[i]); 
         maxi = Math.max(maxi, bloomDay[i]); 
     }
        
     for (int i = mini; i <= maxi; i++) {
         if (possible(bloomDay, i, m, k))
             return i;
     }
     
     return -1;
    }

	 /* Function to check if it's possible to make
    m bouquets with k flowers each on day*/
    private static boolean possible(int[] nums, int day, int m, int k) {
        int n = nums.length; 
        
        // Count of flowers bloomed
        int cnt = 0; 
        
        // Count of bouquets formed
        int noOfB = 0; 

        // Count number of bouquets that can be formed
        for (int i = 0; i < n; i++) {
            if (nums[i] <= day) {
                // Increment flower count
                cnt++; 
            } else {
                /* Calculate number of bouquets
                formed with flowers <= day */
                noOfB += (cnt / k);
                
                // Reset flower count
                cnt = 0; 
            }
        }
        // Add remaining flowers as a bouquet
        noOfB += (cnt / k); 

        /* Return true if enough 
        bouquets can be formed */
        return noOfB >= m; 
    }

}
