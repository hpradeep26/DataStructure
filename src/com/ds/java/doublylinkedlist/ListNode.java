package com.ds.java.doublylinkedlist;

public class ListNode {
	int val;
	ListNode prev;
	ListNode next;
	
	public ListNode(int val) {
		this.val = val;
		next = null;
        prev = null;
	}
	
	 ListNode(int data1, ListNode next1, ListNode prev1) {
	        val = data1;
	        next = next1;
	        prev = prev1;
	    }
}
