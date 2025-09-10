package com.ds.java.linkedlist;

public class _20_Find_Middle_LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Function to get the middle node of linked list
	public ListNode middleOfLinkedList(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		// Until the fast pointer reaches NULL or the last node
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
    }

}
