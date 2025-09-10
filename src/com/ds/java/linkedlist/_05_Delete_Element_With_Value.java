package com.ds.java.linkedlist;

public class _05_Delete_Element_With_Value {

	public static void main(String[] args) {
		ListNode linkedList = SinglyLinkedListMain.createLinkedList();
		System.out.println("Before Delete X Element");
		SinglyLinkedListMain.display(linkedList);
		System.out.println("After Delete X Element");
		SinglyLinkedListMain.display(deleteNodeWithValueX(linkedList,50));
	}
	
	public static ListNode deleteNodeWithValueX(ListNode head, int X) {
		
		 // Check if list is empty
		if(head==null) {
			return null;
		}
		  // If first node has target value, delete
		if(head.val == X) {
			return head.next;
		}
		ListNode temp = head;
		ListNode prev =null;
		 /* Traverse the list to find 
        the node with the target value */
		while(temp!=null) {
			if(temp.val==X) {
				prev.next = temp.next;
				return head;
			}
			prev = temp;
			temp = temp.next;
		}
		return head;
	}

}
