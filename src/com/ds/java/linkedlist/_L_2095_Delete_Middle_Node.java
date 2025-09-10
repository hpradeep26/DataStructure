package com.ds.java.linkedlist;


public class _L_2095_Delete_Middle_Node {

	public static void main(String[] args) {
		 ListNode head = new ListNode(1);
	        ListNode second = new ListNode(2);
	        ListNode third = new ListNode(3);
	        ListNode fourth = new ListNode(4);
	        //ListNode fifth = new ListNode(5);

	        // Create a loop from fifth to second
	        head.next = second;
	        second.next = third;
	        third.next = fourth;
	        //fourth.next = fifth;

	}
	
	 public static ListNode deleteMiddle(ListNode head) {
		 if(head==null||head.next==null) {
			 return null;
		 }
		 ListNode slow = head;
		ListNode fast = head;
		ListNode prev = null;
			// Until the fast pointer reaches NULL or the last node
			while(fast!=null && fast.next!=null) {
				prev = slow;
				slow = slow.next;
				fast = fast.next.next;
			}
			prev.next = slow.next;
			slow.next = null;
			return head;
	 }



}
