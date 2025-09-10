package com.ds.java.sorting;

import java.util.Arrays;

public class _05_QuickSort {

	public static void main(String[] args) {
		int[] arr = {20, 2, 9, 7,12,15,1,6,8};
		quicksort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));

	}
	
	public static void quicksort(int[] arr,int start,int end) {
		
		if(start>=end)
			return;
		
		int pivot = partition(arr,start,end);
		quicksort(arr, start, pivot-1);
		quicksort(arr, pivot+1, end);
	}

	private static int partition(int[] arr, int start, int end) {
		int pos = start-1;
		for (int i = start; i <= end; i++) {
			if(arr[i]<=arr[end]) {
				pos++;
				int temp = arr[i];
				arr[i] = arr[pos];
				arr[pos] = temp;
				
			}
			
		}
		return pos;
	}

}
