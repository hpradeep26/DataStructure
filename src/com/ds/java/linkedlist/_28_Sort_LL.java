package com.ds.java.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _28_Sort_LL {
	
	public static void main(String[] args) {
		
	}
	
	 public ListNode sortList(ListNode head) {
	        // ArrayList to store node values
	        List<Integer> arr = new ArrayList<>();

	        // Temporary pointer to traverse the linked list
	        ListNode temp = head;

	        /*Traverse linked list and
	        store node values in the ArrayList*/
	        while (temp != null) {
	            arr.add(temp.val);
	            temp = temp.next;
	        }

	        // Sort ArrayList containing node values
	        Collections.sort(arr);

	        /*Reassign sorted values
	        to linked list nodes*/
	        temp = head;
	        for (int val : arr) {
	            // Update the node's data
	            temp.val = val;
	            // Move to the next node
	            temp = temp.next;
	        }

	        // Return the head
	        return head;
	    }
	 
	 public ListNode sortListOptimal(ListNode head) {
	        /*Base case: if the list is empty or has only one node, 
	        it is already sorted, so return the head*/
	        if (head == null || head.next == null) {
	            return head;
	        }
	        
	        // Find middle of list using findMiddle function
	        ListNode middle = findMiddle(head);
	        
	        // Divide the list into two halves
	        ListNode right = middle.next;
	        middle.next = null;
	        ListNode left = head;
	        
	        // Recursively sort left and right halves
	        left = sortListOptimal(left);
	        right = sortListOptimal(right);
	        
	        // Merge the sorted halves using the 
	        // mergeTwoSortedLinkedLists function
	        return mergeTwoSortedLinkedLists(left, right);
	    }
	 
	 // Function to find the middle of a linked list
	    public ListNode findMiddle(ListNode head) {
	        // If the list is empty or has only one node, 
	        // the middle is the head itself
	        if (head == null || head.next == null) {
	            return head;
	        }

	        // Initializing slow and fast pointers
	        ListNode slow = head;
	        ListNode fast = head.next;

	       /* Move the fast pointer twice as fast as the slow pointer
	        When the fast pointer reaches the end, the slow pointer 
	        will be at the middle*/
	        while (fast != null && fast.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }

	        return slow;
	    }
	    
	    public ListNode mergeTwoSortedLinkedLists(ListNode list1, ListNode list2) {
	        // Create dummy node to serve as head of merged list
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
	            // Move the temporary pointer to the next node
	            temp = temp.next; 
	        }

	        /*If any list still has 
	        remaining elements append 
	        them to the merged list*/
	        if (list1 != null) {
	            temp.next = list1;
	        } else {
	            temp.next = list2;
	        }
	        // Return the merged list starting 
	        // from the next of the dummy node
	        return dummyNode.next;
	    }
	 
	 
	 
}
