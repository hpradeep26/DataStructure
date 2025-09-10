package com.ds.java.linkedlist;

import java.util.HashSet;

public class _18_Detect_Loop_LL {

	public static void main(String[] args) {
		 ListNode head = new ListNode(1);
	        ListNode second = new ListNode(2);
	        ListNode third = new ListNode(3);
	        ListNode fourth = new ListNode(4);
	        ListNode fifth = new ListNode(5);

	        head.next = second;
	        second.next = third;
	        third.next = fourth;
	        fourth.next = fifth;
	        // Create a loop
	       // fifth.next = third; 
	        
	        System.out.println(hasCycle(head));

	}
	
	//using hashing
	public static boolean hasCycle(ListNode head) {
		
		HashSet<ListNode> set = new HashSet<>();
		while(head!=null){
			if(set.contains(head)) {
				return true;
			}
		 set.add(head);	
		 head = head.next;
		}
		return false;
    }
	
	//using slow & fast pointer 
	public static boolean hasCycleOptimal(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast!=null && fast.next !=null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow==fast)
				return true;
		}
		
		return false;
    }

}
