package com.ds.java.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class _01_Traversal_LinkedList {

	public static void main(String[] args) {
		ListNode linkedList = SinglyLinkedListMain.createLinkedList();
		System.out.println("Traversal Linked List");
		System.out.println(LLTraversal(linkedList));
		
	}
	
	public static List<Integer> LLTraversal(ListNode head) {
		List<Integer> list = new ArrayList<>();
		ListNode temp = head;
		while(temp!=null) {
			list.add(temp.val);
			temp = temp.next;
		}
		return list;
	}
}



