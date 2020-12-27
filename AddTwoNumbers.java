/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode head = null;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        while(l1!=null || l2!=null){
            int[] arr = getNum(l1,l2);
            l1 = (l1!=null)?l1.next:l1; 
            l2 = (l2!=null)?l2.next:l2;
            if(l1==null && l2==null){
                int x = temp+arr[0]+arr[1];
                if(x==0){
                    ListNode newNode = new ListNode(x);
                    appendNode(newNode);
                }
                while(x!=0){
                    ListNode newNode = new ListNode(x%10);
                    appendNode(newNode);
                    x/=10;
                }
            }else{
                int x = temp + arr[0] + arr[1];
                ListNode newNode = new ListNode(x%10);
                appendNode(newNode);
                temp = x/10;      
            }
        }
        return head;
        
    }
    
    public void appendNode(ListNode node){
        if(head==null){
            head = node;
            return;
        }
        ListNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = node;
        
    }
    
    public int[] getNum(ListNode l1, ListNode l2){
        int n1 = 0; int n2 = 0;
        if(l1!=null){
            n1=l1.val;
        }
        if(l2!=null){
            n2 = l2.val;
        }
        return new int[] {n1,n2};
    }
}