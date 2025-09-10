package com.ds.java.doublylinkedlist;

public class _02_Insert_Before_Tail {

	public static void main(String[] args) {
		int[] nums = {4};
		ListNode doublyLinkedList = DoublyLinkedList.createDoublyLinkedListFromArray(nums);
		System.out.println("Original List");
		DoublyLinkedList.printLL(doublyLinkedList);
		System.out.println("After insert List");
		DoublyLinkedList.printLL(insertBeforeTail(doublyLinkedList,2));
	}
	
	public static ListNode insertBeforeTail(ListNode head, int X) {
		ListNode newNode = new ListNode(X);
		if(head==null) {
			return newNode;
		}
		if(head.next==null) {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
			return head;
		}
		ListNode temp = head;
		while(temp.next.next!=null) {
			temp = temp.next;
		}
		ListNode nextNode = temp.next;
		temp.next = newNode;
		newNode.prev = temp;
		newNode.next = nextNode;
		nextNode.prev = newNode;
		return head;
    }
	
	

}
