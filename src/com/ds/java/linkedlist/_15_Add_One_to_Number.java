package com.ds.java.linkedlist;

public class _15_Add_One_to_Number {

	public static void main(String[] args) {
		ListNode linkedList = SinglyLinkedListMain.createLinkedList();
		System.out.println("Before lement");
		SinglyLinkedListMain.display(linkedList);
		System.out.println("After Element");
		SinglyLinkedListMain.display(addOneRecursive(linkedList));

	}
	
	public static ListNode addOneIterative(ListNode head) {
		  // Reverse the linked list
        head = reverseList(head);
        
        // Create a dummy node
        ListNode current = head;
        // Initialize carry with 1
        int carry = 1;  
        
        while (current != null) {
            /* Sum the current node's value 
            and the carry */
            int sum = current.val + carry;
            // Update carry
            carry = sum / 10;
            // Update the node's value
            current.val = sum % 10;
            
            /* If no carry left
            break the loop */
            if (carry == 0) {
                break;
            }
            
            /* If we've reached the end of the list
            and there's still a carry,
            add a new node with the carry value */
            if (current.next == null && carry != 0) {
                current.next = new ListNode(carry);
                break;
            }
            
            // Move to the next node
            current = current.next;
        }
        
        // Reverse the list 
        head = reverseList(head);
        
        // New head
        return head;
	}
	
	public static ListNode addOneRecursive(ListNode head) {
		int carry = addHelper(head);
		if(carry==1) {
			ListNode newNode = new ListNode(carry);
			newNode.next = head;
			return newNode;
		}
		return head;
	}
	
	public static int addHelper(ListNode temp) {
		if(temp==null) {
			return 1;
		}
		
		int carry = addHelper(temp.next);
		
		int sum = temp.val + carry;
		if(sum<10) {
			return 0;
		}
		  /* If the current node's value is 10 or more
        set it to 0 and return a carry of 1 */
        temp.val = 0; 
        return 1;
	}
	

	private static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode current = head;
		
		while(current!=null) {
			ListNode nextNode = current.next;
			current.next = prev;
			prev = current;
			current = nextNode;
		}
		return prev;
	}

}
