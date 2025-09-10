package com.ds.java.linkedlist;

public class _06_Insert_At_the_Head {

	public static void main(String[] args) {
		ListNode linkedList = SinglyLinkedListMain.createLinkedList();
		System.out.println("Before Insert X Element");
		SinglyLinkedListMain.display(linkedList);
		System.out.println("After Insert X Element");
		SinglyLinkedListMain.display(insertAtHead(linkedList, 5));
	}
	
	
	 public static ListNode insertAtHead(ListNode head, int X) {
	        // Creating a new node 
	        ListNode newnode = new ListNode(X);
	        
	        /* Making next of newly created node to 
	        point to the head of the LinkedList */
	        newnode.next = head;
	        
	        // Making newly created node as head
	        head = newnode;
	        
	        // Return the head of modified list
	        return head;
	    }

}
