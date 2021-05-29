/**
 
 Url : https://leetcode.com/problems/add-two-numbers/submissions/

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



/*
---------------------------------------------------------------- 
 1ms Soln :
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        int carry = 0;
        ListNode head = l1;
        ListNode prev= l1;
       
        while(l1 != null && l2!=null){
             int sum = l1.val + l2.val + carry;
            l1.val = sum % 10;
            carry = sum / 10;
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            int sum = l1.val + carry;
            l1.val = sum % 10;
            carry = sum / 10;
            prev = l1;
            l1 = l1.next;
        }
        
        while(l2!=null){
            if(flag == 0){
                flag = 1;
                prev.next = l2;
            }
            int sum = l2.val + carry;
            l2.val = sum % 10;
            carry = sum / 10;
            prev = l2;
            l2 = l2.next;
        }
        
        if(carry!=0){
            ListNode newNode = new ListNode(carry);
            prev.next = newNode;
        }
        
        return head;
    }
}
*/