package com.ds.java.leetcode75.twopointer;

public class _L_11_Container_With_Most_Water {
	//https://leetcode.com/problems/container-with-most-water/solutions/5139915/video-simple-two-pointer-solution-by-nii-9y0n/
	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		//width * height
		//width = right - left = 8 - 0 = 8
		//height = min(height[left], height[right]) = min(1, 7) = 1
		//max area = 8 * 1 = 8
		//output - current_area = 7 * 7 = 49
	}
	
	
	public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while(left<right){
            maxArea = Math.max(maxArea,(right - left) * Math.min(height[left],height[right]));
             if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;        
        }

}
