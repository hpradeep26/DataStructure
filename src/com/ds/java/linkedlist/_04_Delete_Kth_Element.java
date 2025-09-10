package com.ds.java.linkedlist;

public class _04_Delete_Kth_Element {

	public static void main(String[] args) {
		ListNode linkedList = SinglyLinkedListMain.createLinkedList();
		System.out.println("Before Delete kth Element");
		SinglyLinkedListMain.display(linkedList);
		System.out.println("After Delete kth Element");
		SinglyLinkedListMain.display(deleteKthNode(linkedList,5));

	}
	
	public static ListNode deleteKthNode(ListNode head, int k) {
		int count = 0;
		ListNode temp = head;
		ListNode prev= null;
		if(k==1) {
			head = temp.next;
			return head;
		}
		while(temp.next!=null) {
			count++;
			prev = temp;
			temp = temp.next;
			if(count==k-1) {
				prev.next = temp.next;
				return head;
			}
		}
		return head;
    }
	
	 // Function to delete the k-th node of a linked list
    public ListNode deleteKthNode1(ListNode head, int k) {
        // If the list is empty, return null
        if (head == null)
            return null;

        // If k is 1, delete the head node
        if (k == 1) {
            ListNode temp = head;
            head = head.next;
            return head;
        }

        // Initialize a temporary pointer
        ListNode temp = head;

        // Traverse to the (k-1)th node
        for (int i = 0; temp != null && i < k - 2; i++) {
            temp = temp.next;
        }

        /* If k is greater than the number of nodes, 
        return the unchanged list */
        if (temp == null || temp.next == null)
            return head;

        // Delete the k-th node
        ListNode next = temp.next.next;
        temp.next = next;

        // Return head
        return head;
    }

}
