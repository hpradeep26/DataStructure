package com.ds.java.linkedlist;

public class _08_Insert_At_the_Kth_Position {

	public static void main(String[] args) {
		ListNode linkedList = SinglyLinkedListMain.createLinkedList();
		System.out.println("Before Insert X Element");
		SinglyLinkedListMain.display(linkedList);
		System.out.println("After Insert X Element");
		SinglyLinkedListMain.display(insertAtKthPosition(linkedList, 70,6));
	}
	
	
	public static ListNode insertAtKthPosition(ListNode head, int X, int K) {
		ListNode newNode = new ListNode(X);
		// insert to handle first position
		if(K==1) {
			newNode.next = head;
			head = newNode;
			return head;
		}
		int count = 0;
		ListNode temp = head;
		ListNode prev = null;
		
		while(temp!=null) {
			count++;
			if(count==K) {
				prev.next = newNode;
				newNode.next = temp;
				return head;
			}
			prev = temp;
			temp = temp.next;
		}
		// handle to insert last position
		if(count+1==K) {
			prev.next = newNode;
			return head;
		}
        return head;
    }

}
