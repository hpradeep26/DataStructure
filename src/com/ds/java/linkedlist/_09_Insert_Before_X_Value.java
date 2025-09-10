package com.ds.java.linkedlist;

public class _09_Insert_Before_X_Value {

	public static void main(String[] args) {
		ListNode linkedList = SinglyLinkedListMain.createLinkedList();
		System.out.println("Before Insert X Element");
		SinglyLinkedListMain.display(linkedList);
		System.out.println("After Insert X Element");
		SinglyLinkedListMain.display(insertBeforeX(linkedList, 50, 45));
	}
	
	
	public static ListNode insertBeforeX(ListNode head, int X, int K) {
		ListNode newNode = new ListNode(K);
		if(head==null) {
			return head;
		}
		if(head.val==X) {
			newNode.next = head;
			head = newNode;
			return head;
		}
		ListNode temp = head;
		ListNode prev = null;
	
		while(temp!=null) {
			if(temp.val==X) {
				prev.next = newNode;
				newNode.next = temp;
				return head;
			}
			prev = temp;
			temp = temp.next;
		}
		
		return head;
	}

}
