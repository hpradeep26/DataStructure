package com.ds.java.binarysearch;

public class _12_FindNthRootOfNumber {

	public static void main(String[] args) {
		System.out.println(NthRoot1(3, 27));
	}
	
	 public static int NthRoot(int N, int M) {
	        
		 int ans = -1;
		 int low = 1,high = M;
		 while(low<=high) {
			 int mid = (low + high)/2;
			 double pow = Math.pow(mid, N);
			 if(pow==M) {
				 return mid;
			 }else if (pow>M) {
				 high = mid - 1;
			 }else {
				 low = mid + 1;
			 }
		 }
		 
		 return ans;
	 }
	 
	 // Helper function to check mid^N compared to M
	    private static int helperFunc(int mid, int n, int m) {
	        long ans = 1, base = mid;
	        
	        while (n > 0) {
	            if (n % 2 == 1) {
	                ans *= base;
	                if (ans > m) return 2;  // Early exit
	                n--;
	            } else {
	                n /= 2;
	                base *= base;
	                if (base > m) return 2;
	            }
	        }
	        if (ans == m) return 1;
	        return 0;
	    }
	    
	    public static int NthRoot1(int N, int M) {
	        int low = 1, high = M;
	        
	        while (low <= high) {
	            int mid = (low + high) / 2;
	            int midN = helperFunc(mid, N, M);
	            
	            if (midN == 1) return mid; // Found exact root
	            else if (midN == 0) low = mid + 1; // Move right
	            else high = mid - 1; // Move left
	        }
	        return -1; // No integer root found
	    }

}
