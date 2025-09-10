package com.ds.java.arrays;

import java.util.Arrays;

public class _30_MergeTwoSortedArray {

	public static void main(String[] args) {
		int[] nums1 = {1,2,3,0,0,0};
		int m = 3;
		int[] nums2 = {2,5,6}; int n = 3;
		mergeOptimal(nums1, m, nums2, n);
				

	}
	/*We know that nums1 and nums2 are sorted in non-decreasing order. 
	 All we have to do is to compare the last numbers in both arrays.*/
	public static void mergeOptimal(int[] nums1, int m, int[] nums2, int n) {
        int mLastIndex = m - 1;
        int nLastIndex = n - 1;
        int lastIndex = m + n - 1;

        while (nLastIndex >= 0) {
            if (mLastIndex >= 0 && nums1[mLastIndex] > nums2[nLastIndex]) {
                nums1[lastIndex] = nums1[mLastIndex];
                mLastIndex--;
            } else {
                nums1[lastIndex] = nums2[nLastIndex];
                nLastIndex--;
            }
            lastIndex--;
        }        
    }
	
	// we can simply put all numbers in nums2 into nums1.
	//After that, we just sort [1,2,3,2,5,6], so we can create [1,2,2,3,5,6].
	public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
	
	// Function to merge two sorted arrays nums1 and nums2
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // Declare a 3rd array and 2 pointers:
        int[] merged = new int[m + n];
        int left = 0;
        int right = 0;
        int index = 0;

        /* Insert elements from nums1 and nums2 into
        merged array using left and right pointers */
        while (left < m && right < n) {
            if (nums1[left] <= nums2[right]) {
                merged[index++] = nums1[left++];
            } else {
                merged[index++] = nums2[right++];
            }
        }

        // If right pointer reaches the end of nums2:
        while (left < m) {
            merged[index++] = nums1[left++];
        }

        // If left pointer reaches the end of nums1:
        while (right < n) {
            merged[index++] = nums2[right++];
        }

        /* Copy elements from merged array
        array back to nums1 */
        for (int i = 0; i < m + n; i++) {
            nums1[i] = merged[i];
        }
    }

}
