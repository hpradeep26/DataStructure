package com.ds.java.linkedlist;

import java.util.Stack;

public class _16_LL_Is_Palindrome {

	public static void main(String[] args) {
		 /*Create a linked list with values 1, 5, 2, 5, and 1 (15251, a palindrome)*/
        ListNode head = new ListNode(1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(1);
        System.out.println(isPalindromeOptimal(head));

	}
	
	public static boolean isPalindromeOptimal(ListNode head) {
		
		if(head==null && head.next==null) {
			return true;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode reverseNode = reverseList(slow.next);
		ListNode temp = head;
		while(reverseNode!=null) {
			if(temp.val != reverseNode.val) {
				return false;
			}
			temp = temp.next;
			reverseNode = reverseNode.next;
		}
		
		return true;
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
	
	public static boolean isPalindrome(ListNode head) {
        /*Create an empty stack 
        to store values*/
        Stack<Integer> stack = new Stack<>();
        
        /*Initialize temporary pointer 
        to the head of the linked list*/
        ListNode temp = head;
        
        /*Traverse the linked list 
        and push values onto the stack*/
        while (temp != null) {
            /*Push the data from 
            the current node onto the stack*/
            stack.push(temp.val);
            
            // Move to the next node
            temp = temp.next;
        }
        
        /*Reset temporary pointer 
        back to the head of 
        the linked list*/
        temp = head;
        
        /*Compare values by popping 
        from the stack and checking 
        against linked list nodes*/
        while (temp != null) {
            if (temp.val != stack.pop()) {
                /*If values don't match, 
                it's not a palindrome*/
                return false;
            }
            
            /*Move to the next node 
            in the linked list*/
            temp = temp.next;
        }
        
        /*If all values match, 
        it's a palindrome*/
        return true;
    }

}
