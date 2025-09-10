package com.ds.java.slidingwindow;

public class _01_Maximum_points_from_the_card {

	public static void main(String[] args) {
		int[] cardScore = {9, 10, 1, 2, 3, 5}; int k = 5;
		System.out.println(maxScore(cardScore, k));

	}
	
	 public static int maxScore(int[] cardScore, int k) {
	    int max = 0;
	    int lsum = 0;
	    int rsum = 0;
	    for(int i=0;i<k;i++) {
	    	lsum += cardScore[i];
	    }
	    max = lsum;
	    int rightIndex = cardScore.length - 1;
	    for(int i = k-1;i>=0;i--) {
	    	lsum = lsum - cardScore[i];
	    	
	    	rsum = rsum + cardScore[rightIndex];
	    	int sum = lsum + rsum;
	    	rightIndex--;
	    	
	    	max = Math.max(max, sum);
	    	
	    }
	    
	    return max;
	  }

}
