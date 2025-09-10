package com.ds.java.doublylinkedlist;

public class _08_Delete_Before_kth_Node {

	public static void main(String[] args) {
		int[] nums = {1,3,5};
		ListNode doublyLinkedList = DoublyLinkedList.createDoublyLinkedListFromArray(nums);
		System.out.println("Original List");
		DoublyLinkedList.printLL(doublyLinkedList);
		System.out.println("After delete Doubly List");
		DoublyLinkedList.printLL(deleteKthElement(doublyLinkedList,3));

	}
	
	 public static ListNode deleteKthElement(ListNode head, int k) {
		 if(head == null) {
			 return null;
		 }
		 
		 if(k==1) {
			 ListNode prev = head;
			 head = head.next;
			 prev.next = null;
			 if(head!=null) { //special case if only one node is present
			  head.prev = null;
			 }
			 return head;
		 }
		 
		 int count = 0;
		 ListNode temp = head;
		 while(temp.next!=null) {
			 count++;
			 if(count==k-1) {
				 ListNode toBeDeleted = temp.next;
				 ListNode nextNode = temp.next.next;
				 
				 temp.next = nextNode;
				 if(nextNode !=null) {// if node is last Node
				   nextNode.prev = temp;
				 }
				 toBeDeleted.prev = null;
				 toBeDeleted.next = null;
				 return head;
			 }
			 temp = temp.next;
			 
		 }
		 return head;
	 }

}
