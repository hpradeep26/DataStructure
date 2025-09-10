package com.ds.java.linkedlist;

public class _03_Delete_Tail {

	public static void main(String[] args) {
		ListNode linkedList = SinglyLinkedListMain.createLinkedList();
		System.out.println("Before Delete At Tail");
		SinglyLinkedListMain.display(linkedList);
		System.out.println("After Delete At Tail");
		SinglyLinkedListMain.display(deleteTail(linkedList));
		

	}
	
	 public static ListNode deleteTail(ListNode head) {
         if (head == null || head.next == null) {
            return null; // Return null
        }
        ListNode temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        temp.next = null;
        return head;   
    }

}
