package com.ds.java.doublylinkedlist;

public class _06_Delete_Head_DLL {

	public static void main(String[] args) {
		int[] nums = {4};
		ListNode doublyLinkedList = DoublyLinkedList.createDoublyLinkedListFromArray(nums);
		System.out.println("Original List");
		DoublyLinkedList.printLL(doublyLinkedList);
		System.out.println("After insert List");
		DoublyLinkedList.printLL(deleteHead(doublyLinkedList));

	}
	
	public static ListNode deleteHead(ListNode head) {
		// Function to delete the head of the doubly linked list
		if(head==null||head.next==null) {
			return null;
		}
		  // Store current head as 'prev'
        ListNode prev = head;
        // Move 'head' to next node
        head = head.next;
        head.prev = null;
        prev.next = null;
		return head;
	}

}
