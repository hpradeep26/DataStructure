package com.ds.java.doublylinkedlist;

public class _05_Convert_Array_TO_DLL {

	public static void main(String[] args) {
		 int[] nums = {1, 2, 3, 4, 5};
		 arrayToLinkedList(nums);

	}
	
	 public static ListNode arrayToLinkedList(int[] nums) {
	        // If array is empty, return null
	        if (nums.length == 0) return null;

	        // Create head node with first element of the array
	        ListNode head = new ListNode(nums[0]);
	        // Initialize 'prev' to the head node
	        ListNode prev = head;

	        for (int i = 1; i < nums.length; i++) {
	            // Create a new node
	            ListNode temp = new ListNode(nums[i], null, prev);
	            // Update 'next' pointer
	            prev.next = temp;
	            // Move 'prev' to newly created node
	            prev = temp;
	        }

	        // Return head
	        return head;
	    }

}
