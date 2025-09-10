package com.ds.java.linkedlist;

public class _11_Segragate_Even_Odd_LL {

	public static void main(String[] args) {
		ListNode linkedList = SinglyLinkedListMain.createLinkedList();
		System.out.println("Before Insert X Element");
		SinglyLinkedListMain.display(linkedList);
		SinglyLinkedListMain.display(oddEvenList(linkedList));

	}
	
	 public static ListNode oddEvenList(ListNode head) {
		 
		 if(head==null||head.next==null) {
			 return head;
		 }
		 
		 ListNode odd = head;
		 ListNode even = head.next;
		 ListNode evenHead = head.next;
		 
		 while(even!=null && even.next!=null) {
			 odd.next = odd.next.next;
			 even.next = even.next.next;
			 odd = odd.next;
			 even = even.next;
		 }
		 odd.next = evenHead;
		 return head;
	 }

}
