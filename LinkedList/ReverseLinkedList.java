/*
Reverse the Linked List
	Url : https://leetcode.com/problems/reverse-linked-list/
 */


class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null){
           ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}