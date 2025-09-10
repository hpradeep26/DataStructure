package com.ds.java.linkedlist;

public class L_83_Remove_Duplicates_from_SortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        ListNode cur = head;
        ListNode next = cur;
        while(next !=null){
            if(cur.val==next.val){
                cur.next = next.next;
            }else{
             cur = next;
            }
            next = next.next;
        }
        return temp;
    }

}
