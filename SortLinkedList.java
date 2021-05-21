 /*
 Url : https://binarysearch.com/problems/Sort-a-Linked-List
            slow and fast should not be kept seperate
            s f
            1 2 3 4
              s   f
            1 2 3 4

            sf
            1  2  3  4
               s  f   
            1  2  3  4
                  s     f   
            1  2  3  4

*/

class Solution {

    public LLNode getMiddle(LLNode node){
        if(node == null || node.next == null)
            return node;       
        LLNode slow = node;
        LLNode fast = node.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

   public LLNode mergeSort(LLNode node){
       if(node == null || node.next == null){
           return node;
        }
        LLNode midNode = getMiddle(node);
        LLNode temp = midNode.next;
        midNode.next = null;
        LLNode left = mergeSort(node);
        LLNode right = mergeSort(temp);
        return merge(left,right);
   }

    public LLNode merge(LLNode left, LLNode right){
        LLNode sentinel = new LLNode();
        LLNode prev = sentinel;
        while(left!=null && right!=null){
            if(left.val<right.val){
                prev.next = left;
                left = left.next;
            } else {
                prev.next = right;
                right = right.next;
            }
            prev = prev.next;
        }
        prev.next = (left!=null)?left:right;
        return sentinel.next;
    }

    public LLNode solve(LLNode node) {
     return mergeSort(node);
    }
}