/*
Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

As a reminder, a binary search tree is a tree that satisfies these constraints:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Url : https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
*/

class Solution {
    int currentSum = 0;
    public void dfs(TreeNode root){
        if(root == null)
            return;
        dfs(root.right);
        root.val += currentSum;
        currentSum = root.val;
        dfs(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }
}