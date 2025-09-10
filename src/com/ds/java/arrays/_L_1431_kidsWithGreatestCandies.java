package com.ds.java.arrays;

import java.util.ArrayList;
import java.util.List;

public class _L_1431_kidsWithGreatestCandies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int maxCandie = Integer.MIN_VALUE;
        for(int i = 0 ;i < n;i++){
            maxCandie = Math.max(maxCandie,candies[i]);
        }
        List<Boolean> resList = new ArrayList<>();
        for(int i = 0; i<n ; i++){
            int total = extraCandies + candies[i];
            if(total>=maxCandie){
                resList.add(true);
            }else{
                resList.add(false);
            }
        }
        return resList;
    }

}
