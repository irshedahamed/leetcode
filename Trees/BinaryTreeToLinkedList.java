import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    LLNode head = new LLNode();
    LLNode trav = head;
    public LLNode solve(Tree root) {
        inOrder(root);
        return head.next;
    }

    public void inOrder(Tree root){
        if(root==null)
            return;
        inOrder(root.left);
        appendLNode(root.val);
        inOrder(root.right);
    }

    public void appendLNode(int val){
        LLNode node = new LLNode(val);
        trav.next = node;
        trav = trav.next;
    }
}