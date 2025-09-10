package com.ds.java.doublylinkedlist;

public class _04_Insert_Before_Given_Node {

	public static void main(String[] args) {
		int[] nums = {52,79,86,48,1,73,61,3};
		ListNode doublyLinkedList = DoublyLinkedList.createDoublyLinkedListFromArray(nums);
		System.out.println("Original List");
		DoublyLinkedList.printLL(doublyLinkedList);
		System.out.println("After insert List");
		insertBeforeGivenNode(doublyLinkedList,5);
	}
	
	public static void insertBeforeGivenNode(ListNode node, int X) {
		// Get node before the given node
		 ListNode prev = node.prev;
		 ListNode newNode = new ListNode(X, node, prev);
		 prev.next = newNode;
		 node.prev = newNode;
    }

}
