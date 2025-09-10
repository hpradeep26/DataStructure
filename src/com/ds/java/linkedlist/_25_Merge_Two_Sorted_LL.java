package com.ds.java.linkedlist;

public class _25_Merge_Two_Sorted_LL {

	public static void main(String[] args) {
		 ListNode list1 = new ListNode(1);
		    list1.next = new ListNode(3);
		    list1.next.next = new ListNode(5);

		    ListNode list2 = new ListNode(2);
		    list2.next = new ListNode(4);
		    list2.next.next = new ListNode(6);
		    mergeTwoLists(list1, list2);
		    

	}
	
	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		  // the head of the merged list
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        
        // Traverse both lists simultaneously
        while (list1 != null && list2 != null) {
            /*Compare elements of both lists 
            and link the smaller node 
            to the merged list*/
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            // Move the temporary pointer 
            // to the next node
            temp = temp.next;
    }
        
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        // Return merged list 
        return dummyNode.next;
	}
}
