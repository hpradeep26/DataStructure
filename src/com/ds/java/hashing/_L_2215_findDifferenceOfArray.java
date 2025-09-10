package com.ds.java.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _L_2215_findDifferenceOfArray {

	public static void main(String[] args) {
		int[] nums1 = {1,2,3}; int[] nums2 = {2,4,6};
		findDifference(nums1, nums2);

	}
	
	public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();

		for(int i = 0;i < nums1.length;i++){
			set1.add(nums1[i]);
		}

		for(int i = 0;i < nums2.length;i++){
			set2.add(nums2[i]);
		}


		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		for(int i = 0;i < nums1.length;i++){

			if(!set2.contains(nums1[i])&&!list1.contains(nums1[i])){
				list1.add(nums1[i]);
			}
		}

		for(int i = 0;i < nums2.length;i++){

			if(!set1.contains(nums2[i])&&!list2.contains(nums2[i])){
				list2.add(nums2[i]);
			}
		}

		List<List<Integer>> resList = new ArrayList<>();
		resList.add(list1);
		resList.add(list2);
		return resList;
	}

}
