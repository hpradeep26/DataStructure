package com.ds.java.arrays;

public class _L_605_Can_Place_flower {

	public static void main(String[] args) {
		int[] nums = {1,0,0,0,1};
		canPlaceFlowers(nums, 1);

	}
	
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
           boolean left = i == 0 || flowerbed[i - 1] == 0;
           boolean right = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
           
           if (left && right && flowerbed[i] == 0) {
               flowerbed[i] = 1;
               n--;
           }
       }
       return n <= 0;     
   }

}
