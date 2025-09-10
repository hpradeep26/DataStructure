package com.ds.java.doublylinkedlist;

public class _09_Remove_Given_Node {

	public static void main(String[] args) {
		int[] nums = {1,3,5};
		ListNode doublyLinkedList = DoublyLinkedList.createDoublyLinkedListFromArray(nums);
		System.out.println("Original List");
		DoublyLinkedList.printLL(doublyLinkedList);
		deleteGivenNode(doublyLinkedList);
		System.out.println("After delete Doubly List");
		DoublyLinkedList.printLL(doublyLinkedList);
	}
	
	public static void deleteGivenNode(ListNode node) {
		if(node!=null) {
			ListNode prev = node.prev;
			ListNode next = node.next;

			if(prev!=null) {
				prev.next = next;
			}
			if(next!=null) {
				next.prev = prev;
			}
			
			node.next = null;
			node.prev = null;
		}

	}
	
	

}
