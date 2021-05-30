/*
Reverese Linked List II

Url : https://leetcode.com/problems/reverse-linked-list-ii/submissions/

*/


class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right)
            return head;
        
        ListNode previous = null;
        ListNode current = head;
        for(int i=0; i < left-1; i++){
            previous = current;
            current = current.next;
        }
        
        ListNode lastNodeOfList = previous;
        ListNode lastNodeOfSubList = current;
        
        ListNode sentinel = null;
        for(int i = left; i<= right ; i++){
            ListNode temp = current.next;
            current.next = sentinel;
            sentinel = current;
            current = temp;
        }
        if(lastNodeOfList!=null)
            lastNodeOfList.next = sentinel;
        lastNodeOfSubList.next = current;
        
        if(left==1)
            return sentinel;
        
        return head;
    }
}