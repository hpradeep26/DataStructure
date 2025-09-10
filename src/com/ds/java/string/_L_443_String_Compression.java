package com.ds.java.string;

public class _L_443_String_Compression {

	public static void main(String[] args) {
		char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		System.out.println(compress(chars));

	}
	
	public static int compress(char[] chars) {
		 int i = 0;
	        int len = chars.length;
	        int j = 0;
	        StringBuilder sb = new StringBuilder();
	        if(len == 1) return 1;
	        while(i < len){
	            int count = 1;
	            char c = chars[i];
	            while(i < len - 1 && chars[i] == chars[i+1]){
	                count++;
	                i++;
	            }
	            chars[j++] = c;
	            if(count > 1){
	                sb.append(count);
	                while(sb.length() > 0){
	                    chars[j++] = sb.charAt(0);
	                    sb.deleteCharAt(0);
	                }
	            }
	            i++;
	        }
	        return j;
	    }

}
