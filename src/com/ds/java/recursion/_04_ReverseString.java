package com.ds.java.recursion;

import java.util.Vector;

public class _04_ReverseString {

	public static void main(String[] args) {
		Vector<Character> vector = new Vector<>();
		vector.add('a');
		vector.add('x');
		vector.add('e');
		System.out.println(reverseString(vector));
		

	}
	 public static Vector<Character> reverseString(Vector<Character> s) {
		 int left = 0;
		 int right = s.size() - 1;
		 reverse(left,right,s);
		 return s;
	 }

	private static void reverse(int left, int right, Vector<Character> s) {
		
		if(left>right) return;
		
		Character temp = s.get(left);
		s.set(left, s.get(right));
		s.set(right, temp);
		
		reverse(left+1, right-1, s);
	}


}
