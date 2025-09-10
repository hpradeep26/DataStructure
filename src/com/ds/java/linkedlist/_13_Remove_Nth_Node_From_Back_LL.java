package com.ds.java.linkedlist;

public class _13_Remove_Nth_Node_From_Back_LL {

	public static void main(String[] args) {
		ListNode linkedList = SinglyLinkedListMain.createLinkedList();
		System.out.println("Before Insert X Element");
		SinglyLinkedListMain.display(linkedList);
		System.out.println("After Insert X Element");
		SinglyLinkedListMain.display(removeNthFromEndOptimal(linkedList, 1));

	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode temp = head;
		int length = 0;
		while(temp!=null) {
			length++;
			temp = temp.next;
		}
		temp = head;
		if(length==n) {
			head = temp.next;
			return head;
		}
		int k = length - n;
		int count = 0;
		ListNode prev= null;
		
		while(temp.next!=null) {
			count++;
			prev = temp;
			temp = temp.next;
			if(count==k) {
				prev.next = temp.next;
				return head;
			}
		}
		return head;
		
    }
	
	
	public static ListNode removeNthFromEndOptimal(ListNode head, int n) {
        // Creating pointers
        ListNode fastp = head;
        ListNode slowp = head;

        /* Move the fastp pointer 
        N nodes ahead */
        for (int i = 0; i < n; i++) {
            fastp = fastp.next;
        }

        /* If fastp becomes NULL
        the Nth node from the 
        end is the head */
        if (fastp == null) {
            return head.next;
        }

        /* Move both pointers 
        Until fastp reaches the end */
        while (fastp.next != null) {
            fastp = fastp.next;
            slowp = slowp.next;
        }

        // Delete the Nth node from the end
        ListNode delNode = slowp.next;
        slowp.next = slowp.next.next;
        return head;
    }
	
	 public ListNode removeNthFromEnd1(ListNode head, int n) {
	        if (head == null) {
	            return null;
	        }
	        int cnt = 0;
	        ListNode temp = head;

	        // Count the number of nodes
	        while (temp != null) {
	            cnt++;
	            temp = temp.next;
	        }

	        /* If N equals 
	        the total number of nodes
	        delete the head */
	        if (cnt == n) {
	            ListNode newHead = head.next;
	            return newHead;
	        }

	        /* Calculate the position 
	        of the node to delete (res) */
	        int res = cnt - n;
	        temp = head;

	        /* Traverse to the node 
	        just before the one to delete */
	        while (temp != null) {
	            res--;
	            if (res == 0) {
	                break;
	            }
	            temp = temp.next;
	        }

	        // Delete the Nth node from the end
	        ListNode delNode = temp.next;
	        temp.next = temp.next.next;
	        return head;
	    }

}
