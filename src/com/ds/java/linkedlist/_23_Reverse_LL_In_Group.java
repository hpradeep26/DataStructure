package com.ds.java.linkedlist;

public class _23_Reverse_LL_In_Group {

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
	        SinglyLinkedListMain.display(reverseKGroup(head,2));

	}
	
	public static ListNode reverseKGroup(ListNode head, int k) {
        /* Initialize a temporary 
         * node to traverse the list */
        ListNode temp = head;

        /* Initialize a pointer to track 
         * the last node of the previous group */
        ListNode prevLast = null;
        
        // Traverse through the linked list
        while (temp != null) {
            // Get the Kth node of the current group
            ListNode kThNode = getKthNode(temp, k);

            /* If the Kth node is NULL 
             * (not a complete group) */
            if (kThNode == null) {
                /* If there was a previous group, 
                 * link the last node to the current node */
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                
                // Exit the loop
                break;
            }
            
            /* Store the next node 
             * after the Kth node */
            ListNode nextNode = kThNode.next;

            /* Disconnect the Kth node 
             * to prepare for reversal */
            kThNode.next = null;

            // Reverse the nodes from temp to the Kth node
            reverseList(temp);
            
            /* Adjust the head if the reversal 
             * starts from the head */
            if (temp == head) {
                head = kThNode;
            } else {
                /* Link the last node of the previous 
                 * group to the reversed group */
                prevLast.next = kThNode;
            }

            /* Update the pointer to the 
             * last node of the previous group */
            prevLast = temp;

            // Move to the next group
            temp = nextNode;
        }
        
        // Return the head of the modified linked list
        return head;
    }  

	private static ListNode getKthNode(ListNode temp, int k) {
		k--;
		while(temp!=null && k > 0) {
			k--;
			temp = temp.next;
		}
		return temp;
	}
	
	 public static  ListNode reverseList(ListNode head) {
		  /*Initialize 'temp' at
	        head of linked list*/
		 ListNode temp = head;
		   /*Initialize pointer 'prev' to NULL,
	        representing the previous node*/
		 ListNode prev = null;
		 /*Traverse the list, continue till
	        'temp' reaches the end (NULL)*/
		 while(temp!=null) {
			 /* Store the next node in
	            'front' to preserve the reference*/
			 ListNode next = temp.next;
			 /*Reverse the direction of the
	            current node's 'next' pointer
	            to point to 'prev'*/
			 temp.next = prev;
			 /*Move 'prev' to the current
	            node for the next iteration*/
			 prev = temp;
			  /*Move 'temp' to the 'front' node
	            advancing the traversal*/
			 temp = next;
		 }
		 return prev;
	  }

}
