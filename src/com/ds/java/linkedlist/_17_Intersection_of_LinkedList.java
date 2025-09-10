package com.ds.java.linkedlist;

import java.util.HashSet;

public class _17_Intersection_of_LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Function to find the intersection node of two linked lists
	public ListNode getIntersectionNodeOptimal(ListNode headA, ListNode headB) {
		// Edge case
		if(headA==null||headA.next==null) {
			return null;
		}
		 // Initialize two pointers to traverse the lists
		ListNode temp1 = headA;
		ListNode temp2 = headB;
		
		// Traverse both lists until the pointers meet
		while(temp1!=temp2) {
			// Move both the pointers by one place
			temp1 = temp1.next;
			temp2 = temp2.next;
			// If intersection is found
			if(temp1==temp2) return temp1;
			// If either of the two pointers reaches end, place at the front of next linked list 
			if(temp1==null) {
				temp1= headB;
			}
			
			if(temp2==null) {
				temp2= headA;
			}
		}
		  // Return the intersection node
		return temp1;
		
	}
	
	public ListNode getIntersectionNodeBrute(ListNode headA, ListNode headB) {
		// Create a hash set to store the nodes
		// Of the first list
		HashSet<ListNode> nodes_set = new HashSet<>();

		// Traverse the first linked list
		// And add all its nodes to the set
		while (headA != null) {
			nodes_set.add(headA);
			headA = headA.next;
		}

		// Traverse the second linked list
		// And check for intersection
		while (headB != null) {
			// If a node from the second list is found in the set,
			// It means there is an intersection
			if (nodes_set.contains(headB)) {
				return headB;
			}
			headB = headB.next;
		}

		// No intersection found, return null
		return null;
	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int n1 = 0, n2 = 0;

        // Get the length of first linked list
        while (temp1 != null) {
            n1++;
            temp1 = temp1.next;
        }

        // Get the length of second linked list
        while (temp2 != null) {
            n2++;
            temp2 = temp2.next;
        }

        // Traverse the longer list and bring the pointers to same level
        if (n1 < n2) return collisionPoint(headA, headB, n2 - n1);

        return collisionPoint(headB, headA, n1 - n2);
    }

    private ListNode collisionPoint(ListNode smallerListHead, ListNode longerListHead, int len) {
        ListNode temp1 = smallerListHead;
        ListNode temp2 = longerListHead;

        // Adjust the pointers to same level
        for (int i = 0; i < len; i++) temp2 = temp2.next;

        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return temp1;
    }

}
