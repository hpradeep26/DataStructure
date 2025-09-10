package com.ds.java.arrays;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class _10_UnionSortedArray {

	public static void main(String[] args) {
		int[] num1 = {3, 4, 6, 7, 9, 9};
		int[] num2 = {1, 5, 7, 8, 8};
		int[] unionArray = unionArrayOptimal(num1, num2);
		System.out.println(Arrays.toString(unionArray));

	}
	
	public static int[] unionArray(int[] nums1, int[] nums2) {
		Set<Integer> set = new TreeSet<>();
		for (int num : nums1) {
			set.add(num);
		}
		for (int num : nums2) {
			set.add(num);
		}
		int[] res = new int[set.size()];
		int index =0;
		for (Integer i : set) {
			res[index++] = i;
		}
		return res;
        
    }
	
	public static int[] unionArrayOptimal(int[] nums1, int[] nums2) {
		Set<Integer> set = new LinkedHashSet<>();
		int i = 0;
		int j = 0;
		int m = nums1.length;
		int n = nums2.length;
		
		while(i < m && j < n) {
			if(nums1[i]<=nums2[j]) {
				set.add(nums1[i++]);
			}else {
				set.add(nums2[j++]);
			}
		}
		
		while(i < m) {
			set.add(nums1[i++]);
		}
		while(j < n) {
			set.add(nums2[j++]);
		}
		int[] res = new int[set.size()];
		int index = 0;
		for (Integer integer : set) {
			res[index++] = integer; 
		}
		
		return res;
        
    }

}
