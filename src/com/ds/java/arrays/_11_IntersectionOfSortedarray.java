package com.ds.java.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _11_IntersectionOfSortedarray {

	public static void main(String[] args) {
		int[] num1 = {-45, -45, 0, 0, 2};
		int[] num2 = {-50, -45, 0, 0, 5, 7};
		int[] unionArray = intersectionArray(num1, num2);
		System.out.println(Arrays.toString(unionArray));

	}
	
	public static int[] intersectionArray(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int m = nums1.length;
        int n = nums2.length;
        
        while(i < m && j < n) {
        	if(nums1[i]==nums2[j]) {
        		list.add(nums1[i]);
        		i++;j++;
        	}else if(nums1[i]<nums2[j]) {
        		i++;
            }else {
            	j++;
            }
        }
		
        int[] res = new int[list.size()];
        		int index = 0;
        for (Integer num : list) {
			res[index++] = num;
		}
		return res;
    }

}
