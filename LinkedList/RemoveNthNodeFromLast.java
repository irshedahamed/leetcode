/**
URL : https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/

 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
		//Use sentinel to avoid edge Cases
        ListNode slow = new ListNode();
        slow.next = head;
        
        ListNode sentinel = slow;
        ListNode fast = head;
        for(int i = 0; i < n; i++){
            if(fast!=null)
                fast = fast.next;
        }
        
        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return sentinel.next;
            
    }
}