/**

Url : https://leetcode.com/problems/rotate-list/submissions/
 
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
 */

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
       
        if(k==0 || head==null)
            return head;
        
        int length = 0;
        ListNode tail = new ListNode(); 
        for(ListNode itr = head;itr!=null;tail= itr,itr = itr.next,length++);
        k = k % length;
        
        if(k==0)
            return head;
            
        ListNode prev = null;
        ListNode trav = head;
        for(int i = 0;i<length-k;i++){
            prev = trav;
            trav = trav.next;
        }
        
        tail.next = head;
        if(prev!=null)
         prev.next = null;
        
        return trav;
    }
}