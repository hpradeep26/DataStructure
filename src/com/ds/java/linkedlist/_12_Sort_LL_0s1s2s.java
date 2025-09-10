package com.ds.java.linkedlist;

public class _12_Sort_LL_0s1s2s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public ListNode sortList(ListNode head) {
	        // Initialize counts
	        int c0 = 0, c1 = 0, c2 = 0;
	        ListNode temp = head;

	        /* Count the number of 0s, 
	           1s, and 2s in the list */
	        while (temp != null) {
	            if (temp.val == 0)
	                c0++;
	            else if (temp.val == 1)
	                c1++;
	            else if (temp.val == 2)
	                c2++;
	            temp = temp.next;
	        }

	        temp = head;

	        /* Reassign values to 
	           the nodes based on 
	           the counts */
	        while (temp != null) {
	            if (c0 > 0) {
	                temp.val = 0;
	                c0--;
	            } else if (c1 > 0) {
	                temp.val = 1;
	                c1--;
	            } else if (c2 > 0) {
	                temp.val = 2;
	                c2--;
	            }
	            temp = temp.next;
	        }

	        return head;
	    }
	 
	 public ListNode sortListOptimal(ListNode head) {
		 if(head==null && head.next == null) {
			 return head;
		 }
		 
		 ListNode zeroHead = new ListNode(-1);
		 ListNode oneHead = new ListNode(-1);
		 ListNode secondHead = new ListNode(-1);
		 
		 ListNode temp = head;
		 
		 ListNode zero = zeroHead;
		 ListNode one = oneHead;
		 ListNode second = secondHead;
		 
		 
		 
		 while(temp!=null) {
			 if(temp.val==0) {
				 zero.next = temp;
				 zero = temp;
			 }else if (temp.val== 1) {
				 one.next = temp;
				 one = temp;
			 }else {
				 second.next = temp;
				 second = temp;
			 }
			 temp = temp.next;
		 }
		 zero.next = (oneHead.next != null) ? oneHead.next : secondHead.next;
		 one.next = second.next;
		 second.next = null;
		 
		 // New head of the sorted list
	     ListNode newHead = zeroHead.next;
	        
		 return newHead;
	 }


}
