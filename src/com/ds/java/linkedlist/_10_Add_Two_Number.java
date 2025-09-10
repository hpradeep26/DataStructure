package com.ds.java.linkedlist;


public class _10_Add_Two_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        /* Dummy node to act as the
	        starting point of the result list */
	        ListNode dummy = new ListNode(0);
	        /* Temp pointer to build
	        the result list */
	        ListNode temp = dummy;
	        // Initialize carry
	        int carry = 0;

	        /* Iterate while there are nodes in l1 or l2,
	        or there's a carry to process */
	        while (l1 != null || l2 != null || carry != 0) {
	            int sum = 0;

	            /* Add the value from l1
	            if available */
	            if (l1 != null) {
	                sum += l1.val;
	                l1 = l1.next;
	            }

	            /* Add the value from l2
	            if available */
	            if (l2 != null) {
	                sum += l2.val;
	                l2 = l2.next;
	            }

	            // Add the carry
	            sum += carry;
	            // Update the carry
	            carry = sum / 10;

	            /* Create a new node with the digit value
	            and attach it to the result list */
	            ListNode node = new ListNode(sum % 10);
	            temp.next = node;
	            /* Move to the
	            next position in the result list */
	            temp = temp.next;
	        }
	        /* Return the result list
	        skipping the dummy node */
	        return dummy.next;
	    }

}
