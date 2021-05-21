/*
Url : https://leetcode.com/problems/merge-two-sorted-lists/submissions/
Sentinel is used to escape null checks in the code.
           
    l1 1 - 2  - 4
    
    l2 1 - 3 - 4

*/   

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode();
        ListNode prev = sentinel;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
           prev = prev.next; 
        }
        
        prev.next = (l1!=null)?l1:l2;
        return sentinel.next;
    }
}