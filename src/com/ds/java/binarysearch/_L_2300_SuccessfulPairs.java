package com.ds.java.binarysearch;

import java.util.Arrays;

public class _L_2300_SuccessfulPairs {

	public static void main(String[] args) {
		int[] spells = {3,1,2};
		int[] potions = {8,5,8};
		long sucess = 16;
		System.out.println(Arrays.toString(successfulPairs(spells, potions, sucess)));
	}
	
	
	public static int[] successfulPairs(int[] spells, int[] potions, long success) {
		 Arrays.sort(potions);
	        int[] res = new int[spells.length];
	        for (int i = 0; i < spells.length; i++) {
	            res[i] = potions.length - valid_pos(potions, success, spells[i]);
	        }
	        return res;
    }
	
	 public static int valid_pos(int[] potions, long success, int spell) {
	        long potion_needed = (success + spell - 1) / spell;
	        int l = 0, r = potions.length;
	        while (l < r) {
	            int mid = l + (r - l) / 2;
	            if (potions[mid] >= potion_needed)
	                r = mid;
	            else
	                l = mid + 1;
	        }
	        return l;
	    }
	

}
