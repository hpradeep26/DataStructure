package com.ds.java.doublylinkedlist;

public class _07_Delete_Tail_DLL {

	public static void main(String[] args) {
		int[] nums = {3,4};
		ListNode doublyLinkedList = DoublyLinkedList.createDoublyLinkedListFromArray(nums);
		System.out.println("Original List");
		DoublyLinkedList.printLL(doublyLinkedList);
		System.out.println("After insert List");
		DoublyLinkedList.printLL(deleteTail(doublyLinkedList));

	}
	
	public static ListNode deleteTail(ListNode head) {
		// Function to delete the head of the doubly linked list
		if(head==null||head.next==null) {
			return null;
		}
        ListNode temp = head;
        while(temp.next!=null) {
        	temp = temp.next;
        }
        ListNode prev = temp.prev;
        prev.next = null;
        temp.prev = null;
		return head;
	}

}
