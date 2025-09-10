package com.ds.java.doublylinkedlist;

public class DoublyLinkedList {

	public static ListNode createDoublyLinkedListFromArray(int[] nums) {
		ListNode head = new ListNode(nums[0]);
		ListNode prev = head;
		for (int i = 1; i < nums.length; i++) {
			 ListNode temp = new ListNode(nums[i], null, prev);
			 prev.next = temp;
			 prev = temp;
		}
		return head;
	}
	
	 public static void printLL(ListNode head) {
	        while (head != null) {
	            System.out.print(head.val + "->");
	            head = head.next;
	        }
	        System.out.println();
	    }

}
