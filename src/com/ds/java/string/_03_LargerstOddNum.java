package com.ds.java.string;

public class _03_LargerstOddNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String largeOddNum(String s) {
        int ind = -1;
        
        // Iterate through the string from the end to beginning
        int i;
        for (i = s.length() - 1; i >= 0; i--) {
            // Break if an odd digit is found
            if ((s.charAt(i) - '0') % 2 == 1) {
                ind = i;
                break;
            }
        }
        
        // If no odd number was found, return an empty string
        if (ind == -1) return "";
        
        // Skipping any leading zeroes
        i = 0;
        while(i <= ind && s.charAt(i) == '0') i++;
        
        // Return the largest odd number substring
        return s.substring(i, ind + 1);
    }

}
