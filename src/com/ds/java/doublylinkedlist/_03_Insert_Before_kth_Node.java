package com.ds.java.doublylinkedlist;

public class _03_Insert_Before_kth_Node {

	public static void main(String[] args) {
		int[] nums = {52,79,86,48,1,73,61,3};
		ListNode doublyLinkedList = DoublyLinkedList.createDoublyLinkedListFromArray(nums);
		System.out.println("Original List");
		DoublyLinkedList.printLL(doublyLinkedList);
		System.out.println("After insert List");
		DoublyLinkedList.printLL(insertBeforeKthPosition(doublyLinkedList,43,7));
	}
	
	public static ListNode insertBeforeKthPosition(ListNode head, int X, int K) {
		ListNode newNode = new ListNode(X);
		if(head==null) {
			return newNode;
		}
		if(K==1) {
			newNode.next = head;
			head.prev = newNode;
			return newNode;
		}
		ListNode temp = head;
		int count = 0;
		while(temp!=null) {
			count++;
			if(count==K-1) {
				ListNode nextNode = temp.next;
				temp.next = newNode;
				newNode.prev = temp;
				newNode.next = nextNode;
				nextNode.prev = newNode;
				return head;
			}
			temp = temp.next;
		}
		return head;
    }

}
