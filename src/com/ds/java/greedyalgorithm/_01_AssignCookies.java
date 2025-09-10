package com.ds.java.greedyalgorithm;

import java.util.Arrays;

public class _01_AssignCookies {

	public static void main(String[] args) {
	    int[] Student = {2,4};
        int[] Cookie = {1, 2, 3};
        System.out.println(findContentChildren(Student, Cookie));

	}

	public static int findContentChildren(int[] student, int[] cookies) {
		Arrays.sort(student);
		Arrays.sort(cookies);
		int l = 0 , r =0,content = 0;
		int greedSize = student.length;
		int cookieSize = cookies.length;
		while(l<greedSize && r< cookieSize) {
			if(cookies[r]>=student[l]) {
				content++;
				r++;
				l++;
			}else{
				r++;
			}
		}
		return content;
	}

}
