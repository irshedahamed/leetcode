import java.util.*;

/**
Counting Maximal Value Roots in Binary Tree
Easy

Given a binary tree root, count and return the number of nodes where its value is greater than or equal to the values of all of its descendants.

Constraints

n ≤ 100,000 where n is the number of nodes in root
 */
 
class Solution {
    int count = 0;

    public int dfs(Tree root){
        if(root == null)
            return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);

        if(root.val >= Math.max(left,right))
            count++;
        
        return Math.max(Math.max(left,right),root.val);

    }

    public int solve(Tree root) {
        dfs(root);
        return count;
    }
}