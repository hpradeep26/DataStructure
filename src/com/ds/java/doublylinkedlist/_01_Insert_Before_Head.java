package com.ds.java.doublylinkedlist;

public class _01_Insert_Before_Head {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode insertBeforeHead(ListNode head, int X) {
		ListNode newNode = new ListNode(X);
		if(head==null) {
			return newNode;
		}
		head.prev = newNode;
		newNode.next = head;
		head = newNode;
		return head;
    }

}
