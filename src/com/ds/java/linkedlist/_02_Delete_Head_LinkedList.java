package com.ds.java.linkedlist;

public class _02_Delete_Head_LinkedList {

	public static void main(String[] args) {
		ListNode linkedList = SinglyLinkedListMain.createLinkedList();
		System.out.println("Before Delete At Head");
		SinglyLinkedListMain.display(linkedList);
		System.out.println("After Delete At Head");
		SinglyLinkedListMain.display(deleteHead(linkedList));

	}
	
	public static ListNode deleteHead(ListNode head) {
        // If list is empty, nothing to delete
        if (head == null) 
            return null;

        // Set temporary pointer
        ListNode temp = head;

        // Update head to the next node 
        head = head.next;

        // Delete original head    
        temp = null;

        // Return new head          
        return head;
    }

}
