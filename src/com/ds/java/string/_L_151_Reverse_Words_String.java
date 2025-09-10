package com.ds.java.string;

public class _L_151_Reverse_Words_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public String reverseWords(String s) {
	       String[] str = s.trim().split("\\s+");
	        StringBuilder builder = new StringBuilder();
	        for(int i=str.length-1;i>0;i--){
	              builder.append(str[i]);
	              builder.append(" ");
	            }
	           builder.append(str[0]); 
	        return builder.toString();
	    }

}
