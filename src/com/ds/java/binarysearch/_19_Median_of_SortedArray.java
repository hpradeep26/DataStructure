package com.ds.java.binarysearch;

public class _19_Median_of_SortedArray {

	public static void main(String[] args) {
		 int[] arr1 = {2, 4, 6}; int[] arr2 = {1, 3, 5};
		 findMedianSortedArrays(arr1, arr2);
	}
	
	 public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	  int [] merged = mergeArray(nums1,nums2);
	  int n = merged.length;
	  //System.out.println(Arrays.toString(merged));
      if (n % 2 == 1) {
          return (double) merged[n / 2];
      }
      double median = ((double) merged[n / 2] + (double) merged[(n / 2) - 1]) / 2.0;
      return median;
	 }

	private static int[] mergeArray(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int[] temp = new int[m+n];
		int i = 0;
		int j = 0;
		int index = 0;
		while(i<m && j<n) {
			if(nums1[i]<nums2[j]) {
				temp[index++] = nums1[i++];
			}else {
				temp[index++] = nums2[j++];
			}
		}
		
		while(i<m) {
			temp[index++] = nums1[i++];
		}
		
		while(j<n) {
			temp[index++] = nums2[j++];
		}
		return temp;
		
	}
	 // Optimal
	 public double medianOptimal(int[] arr1, int[] arr2) {
	        // Size of two given arrays
	        int n1 = arr1.length, n2 = arr2.length;

	        /* Ensure arr1 is not larger than 
	        arr2 to simplify implementation*/
	        if (n1 > n2) return median(arr2, arr1);

	        int n = n1 + n2;
	        
	        // Length of left half
	        int left = (n1 + n2 + 1) / 2; 

	        // Apply binary search
	        int low = 0, high = n1;
	        while (low <= high) {
	            
	            // Calculate mid index for arr1
	            int mid1 = (low + high) >>> 1; 
	            
	            // Calculate mid index for arr2
	            int mid2 = left - mid1; 

	            // Calculate l1, l2, r1, and r2
	            int l1 = (mid1 > 0) ? arr1[mid1 - 1] : Integer.MIN_VALUE;
	            int r1 = (mid1 < n1) ? arr1[mid1] : Integer.MAX_VALUE;
	            int l2 = (mid2 > 0) ? arr2[mid2 - 1] : Integer.MIN_VALUE;
	            int r2 = (mid2 < n2) ? arr2[mid2] : Integer.MAX_VALUE;

	            if (l1 <= r2 && l2 <= r1) {
	                // If condition for finding median
	                if (n % 2 == 1) return Math.max(l1, l2);
	                else return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
	            } 
	            else if (l1 > r2) {
	                // Eliminate the right half of arr1
	                high = mid1 - 1;
	            } else {
	                // Eliminate the left half of arr1
	                low = mid1 + 1;
	            }
	        }
	        // Dummy statement
	        return 0; 
	    }
	
	//better
	
	 public double median(int[] arr1, int[] arr2) {
	        // Size of two given arrays
	        int n1 = arr1.length, n2 = arr2.length;
	        int n = n1 + n2; // Total size

	        // Required indices for median calculation
	        int ind2 = n / 2;
	        int ind1 = ind2 - 1;
	        int cnt = 0;
	        int ind1el = -1, ind2el = -1;

	        // Apply the merge step
	        int i = 0, j = 0;
	        while (i < n1 && j < n2) {
	            if (arr1[i] < arr2[j]) {
	                if (cnt == ind1) ind1el = arr1[i];
	                if (cnt == ind2) ind2el = arr1[i];
	                cnt++;
	                i++;
	            } else {
	                if (cnt == ind1) ind1el = arr2[j];
	                if (cnt == ind2) ind2el = arr2[j];
	                cnt++;
	                j++;
	            }
	        }

	        // Copy the remaining elements
	        while (i < n1) {
	            if (cnt == ind1) ind1el = arr1[i];
	            if (cnt == ind2) ind2el = arr1[i];
	            cnt++;
	            i++;
	        }
	        while (j < n2) {
	            if (cnt == ind1) ind1el = arr2[j];
	            if (cnt == ind2) ind2el = arr2[j];
	            cnt++;
	            j++;
	        }

	        // Find the median
	        if (n % 2 == 1) {
	            return (double) ind2el;
	        }

	        return (double) ((double) (ind1el + ind2el)) / 2.0;
	    }

}
