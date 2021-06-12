/*


Url : https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
       
        Node leftMost = root;
        int level = 0;
        
        //Process Next Level using Previous Level
        while(leftMost.left != null){
            int length = (int) Math.pow(2,level);
            Node head = leftMost;
            
            while(head != null){
                //First Connection Between To Childern of the Common Parent
                head.left.next = head.right;
                if(head.next != null){
                    //Second Connection between right and left of different parent using previously established next pointer
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            
            leftMost = leftMost.left;
            level++;
        }
        return root;
    }
}