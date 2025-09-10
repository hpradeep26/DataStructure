package com.ds.java.linkedlist;


public class SinglyLinkedListMain {
	
	public static ListNode createLinkedList(){
    	ListNode l1 = new ListNode(3);
		ListNode l2 = new ListNode(7);
		ListNode l3 = new ListNode(5);
		ListNode l4 = new ListNode(7);
		ListNode l5 = new ListNode(3);
		//
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		return l1;
    }
	
	public static void display(ListNode head) {
		ListNode temp = head;
		while(temp!=null) {
			System.out.print(temp.val);
			if(temp.next!=null) {
				System.out.print("->");
			}
			temp = temp.next;
		}
		System.out.println();
	}
	
}
