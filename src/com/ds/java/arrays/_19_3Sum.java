package com.ds.java.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _19_3Sum {

	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		List<List<Integer>> threeSum = threeSumOptimal(nums);
		for (List<Integer> list : threeSum) {
			System.out.println(list);
		}

	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> resSet = new HashSet<List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				for (int k = j+1; k < nums.length; k++) {
					if(nums[i]+nums[j]+nums[k]==0) {
						List<Integer> list = new ArrayList<>(); 
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						 /* Sort the triplet to ensure 
                        uniqueness when storing in set*/
						Collections.sort(list);
	                    resSet.add(list);
					}
				}
			}
		}
		return new ArrayList<>(resSet);
	}
	
	public static List<List<Integer>> threeSumBetter(int[] nums) {
		Set<List<Integer>> resSet = new HashSet<List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			Set<Integer> set = new HashSet<>();
			for (int j = i+1; j < nums.length; j++) {
				int third = -(nums[i]+nums[j]);
				if(set.contains(third)) {
					 List<Integer> temp = new ArrayList<>();
	                    temp.add(nums[i]);
	                    temp.add(nums[j]);
	                    temp.add(third);

	                    /* Sort the triplet to ensure
	                    uniqueness when storing in set*/
	                    Collections.sort(temp);
	                    resSet.add(temp);
				}
				set.add(nums[j]);
			}
		}
		return new ArrayList<>(resSet);
	}
	
	public static List<List<Integer>> threeSumOptimal(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		int n = nums.length;
		//sort Array
		Arrays.sort(nums);
		
		for(int i = 0; i<n ;i++) {
			//skip duplicates for i pointer
			if(i>0 && nums[i]==nums[i-1]) {
				continue;
			}
			int j = i + 1;
			int k = n - 1;
			
			while(j < k) {
				int sum = nums[i]+nums[j]+nums[k];
				
				if(sum < 0) {
					j++;
				}else if (sum > 0) {
					k--;
				}else {
					 List<Integer> temp = new ArrayList<>();
	                    temp.add(nums[i]);
	                    temp.add(nums[j]);
	                    temp.add(nums[k]);
	                    ans.add(temp);
	                    j++;
	                    k--;
	                    //skip duplicate for j pointer
	                    while(j<k && nums[j]==nums[j-1]) { 
	                    	j++;
	                    }
	                    
	                  //skip duplicate for j pointer
	                    while(j<k && nums[k]==nums[k+1]) { 
	                    	k--;
	                    }
				}
			}
		}
		return ans;
	}

}
