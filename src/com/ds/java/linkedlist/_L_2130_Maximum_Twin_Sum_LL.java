package com.ds.java.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class _L_2130_Maximum_Twin_Sum_LL {

	public static void main(String[] args) {
		ListNode1 l1 = new ListNode1(5);
		ListNode1 l2 = new ListNode1(4);
		ListNode1 l3 = new ListNode1(2);
		ListNode1 l4 = new ListNode1(6);
		//
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		pairSumLL(l1);

	}
	
	public static int pairSum(ListNode1 head) {
        List<Integer> list = new ArrayList<>();
        int max = 0;
        ListNode1 temp = head;
        while(temp!=null) {
        	list.add(temp.val);
        	temp = temp.next;
        }
        int n = list.size();
        for(int i = 0;i<n/2;i++) {
        	int sum = list.get(i) + list.get(n-1-i);
        	max = Math.max(max, sum);
        }
        return max;
    }
	
	public static int pairSumLL(ListNode1 head) {
		ListNode1 slow = head;
		ListNode1 fast = head;
        int maxVal = 0;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode1 nextNode, prev = null;
        while (slow != null) {
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        while (prev != null) {
            maxVal = Math.max(maxVal, head.val + prev.val);
            prev = prev.next;
            head = head.next;
        }

        return maxVal;
    }

}

class ListNode1 {
	
    int val; 
    ListNode1 next;
    
    public ListNode1(int data1) {
        this.val = data1;
        this.next = null;
    }

    ListNode1(int data1,ListNode1 next1) {
        this.val = data1;
        this.next = next1;
}
}
    
   
    

