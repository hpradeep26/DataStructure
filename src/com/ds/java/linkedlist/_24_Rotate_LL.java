package com.ds.java.linkedlist;

public class _24_Rotate_LL {

	public static void main(String[] args) {
		 ListNode head = new ListNode(1);
	        ListNode second = new ListNode(2);
	        ListNode third = new ListNode(3);
	        ListNode fourth = new ListNode(4);
	        ListNode fifth = new ListNode(5);

	        // Create a loop from fifth to second
	        head.next = second;
	        second.next = third;
	        third.next = fourth;
	        fourth.next = fifth;
	        SinglyLinkedListMain.display(head);
	        SinglyLinkedListMain.display(rotateRightOptimal(head,2));


	}
	
	public static ListNode rotateRightOptimal(ListNode head, int k) {
		if (head == null || head.next == null || k == 0) 
            return head;

        // Calculating length
        ListNode temp = head;
        int length = 1;
        while (temp.next != null) {
            ++length;
            temp = temp.next;
        }
        
        temp.next = head;
        k = k % length; 
        // To get end of the list
        int end = length - k; 
        while (end-- > 0) 
            temp = temp.next;

        head = temp.next;
        temp.next = null;

        return head; 
	}
	
	public static ListNode rotateRightBrute(ListNode head, int k) {
        // Base case: if list is empty or has only one node
        if (head == null || head.next == null)
            return head;

        // Perform rotation k times
        for (int i = 0; i < k; i++) {
            ListNode temp = head;
            // Find the second last node
            while (temp.next.next != null) temp = temp.next;
            // Get the last node
            ListNode end = temp.next;
            // Break the link between 
            // second last and last node
            temp.next = null;
            // Make the last node
            // as new head
            end.next = head;
            head = end;
        }
        return head;
    }
	 

}
