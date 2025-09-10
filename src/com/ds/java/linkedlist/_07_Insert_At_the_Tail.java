package com.ds.java.linkedlist;

public class _07_Insert_At_the_Tail {

	public static void main(String[] args) {
		ListNode linkedList = SinglyLinkedListMain.createLinkedList();
		System.out.println("Before Insert X Element");
		SinglyLinkedListMain.display(linkedList);
		System.out.println("After Insert X Element");
		SinglyLinkedListMain.display(insertAtTail(linkedList, 70));
	}
	
	
	 public static ListNode insertAtTail(ListNode head, int X) {
	        // Creating a new node 
	        ListNode newnode = new ListNode(X);
	        
	        if(head==null) {
	        	head = newnode;
	        	return head;
	        }
	        ListNode temp = head;
	        while(temp.next!=null) {
	        	temp = temp.next;
	        }
	        temp.next = newnode;
	        return head;
	    }

}
