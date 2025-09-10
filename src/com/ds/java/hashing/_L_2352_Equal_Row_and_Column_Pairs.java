package com.ds.java.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _L_2352_Equal_Row_and_Column_Pairs {

	public static void main(String[] args) {
		int[][] arr = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
		//Output: 3
		//Explanation: There are 3 equal row and column pairs:
		//- (Row 0, Column 0): [3,1,2,2]
		//- (Row 2, Column 2): [2,4,2,2]
		//- (Row 3, Column 2): [2,4,2,2]
		equalPairs(arr);
	}
	
    public static int equalPairs(int[][] grid) {
        int count = 0;
        HashMap<List<Integer>,Integer> map = new HashMap<>();
        //row wise
        for(int i = 0; i < grid.length ; i++) {
        	List<Integer> list = new ArrayList<>();
        	for(int j = 0; j < grid.length ; j++) {
        		list.add(grid[i][j]);
        	}
        	map.put(list, map.getOrDefault(list, 0)+1);
        }
        
        //column wise
        for(int i = 0; i < grid.length ; i++) {
        	List<Integer> list = new ArrayList<>();
        	for(int j = 0; j < grid.length ; j++) {
        		list.add(grid[j][i]);
        	}
        	
        	if(map.containsKey(list)) {
        		count += map.get(list);
        	}
        }
        
        return count;
    }

}
