/**
 * Inorder Successor
Question 482 of 999

Given a binary search tree root containing unique values, and an integer t, return the value of the inorder successor of t. That is, return the smallest value greater than t in the tree.

Note: you can assume that the inorder successor exists.

Bonus: solve it in O(h)\mathcal{O}(h)O(h) space where h is the height of the tree.

Constraints

    n ≤ 100,000 where n is the number of nodes in root


 */
import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    int ans = 0;
    public int solve(Tree root, int t) {
        inOrder(root,t);
        return ans;
    }
    
    public void inOrder(Tree root,int t){
        if(root==null)
            return;
       
        inOrder(root.left,t);
            if(ans==0 && root.val>t)
                ans = root.val;
        inOrder(root.right,t);
    }
}