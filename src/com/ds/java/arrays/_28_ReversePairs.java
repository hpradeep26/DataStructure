package com.ds.java.arrays;

import java.util.ArrayList;
import java.util.List;

public class _28_ReversePairs {
	//https://takeuforward.org/plus/dsa/arrays/faqs-hard/reverse-pairs
	
	//Input: nums = [6, 4, 1, 2, 7]
	//Output: 3
	//Explanation: The reverse pairs are:
	//(0, 2) : nums[0] = 6, nums[2] = 1, 6 > 2 * 1
	//(0, 3) : nums[0] = 6, nums[3] = 2, 6 > 2 * 2
	//(1, 2) : nums[1] = 4, nums[2] = 1, 4 > 2 * 1
	public static void main(String[] args) {
		
	}
	
public static int reversePairs(int[] nums) {
	 int cnt = 0;
     int n = nums.length;
     /* Nested loops to check each
     pair (i, j) where i < j*/
     for (int i = 0; i < n; i++) {
         for (int j = i + 1; j < n; j++) {
              /* Check if the condition 
             a[i] > 2 * a[j] holds*/
             if (nums[i] > 2 * nums[j]) {
                 
                 /* Increment count if
                 condition is satisfied*/
                 cnt++; 
                 
             }
         }
     }
     // Return the total count of reverse pairs
     return cnt; 
    }


    /* Function to count reverse
    pairs where a[i] > 2 * a[j]*/
    public int reversePairs1(int[] nums) {
        int n = nums.length;
        return team(nums, n);
    }

    /* Merge function to merge two 
    sorted halves and count reverse pairs*/
    private void merge(int[] arr, int low, int mid, int high) {
        // temporary array
        List<Integer> temp = new ArrayList<>();
        
        // starting index of left half of arr
        int left = low;  
        
        // starting index of right half of arr
        int right = mid + 1; 

        // Merge and count reverse pairs
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // Copy remaining elements from left half
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // Copy remaining elements from right half
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Transfer sorted elements from temp to arr
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    // Function to count reverse pairs
    private int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        
        for (int i = low; i <= mid; i++) {
            
            /*while right is less than equal to high and arr[i]
            is greater than 2 * arr[right] then increment right by 1*/
            while (right <= high && arr[i] > 2 * arr[right]) right++;
            
            cnt += (right - (mid + 1));
        }
        //Return the count
        return cnt;
    }

    /* Merge sort function to sort the
    array and count reverse pairs*/
    private int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        
        if (low >= high) {
            return cnt;
        }
        
        int mid = low + (high - low) / 2;
        
        // Sort left half
        cnt += mergeSort(arr, low, mid);
        
        // Sort right half
        cnt += mergeSort(arr, mid + 1, high);
        
        // Merge and count pairs
        cnt += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        
        //Return the count of reverse pairs
        return cnt;
    }

    private int team(int[] skill, int n) {
        return mergeSort(skill, 0, n - 1);
    }



}
