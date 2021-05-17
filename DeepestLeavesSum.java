/**
 Given the root of a binary tree, return the sum of values of its deepest leaves.
 
 
 Problem Url : https://leetcode.com/problems/deepest-leaves-sum/
 */
class Solution {
    int maxLevel = 0;
    int sum = 0;
    
    public void dfs(TreeNode root,int level){
        if(root==null)
            return;
        if(level==maxLevel){
            sum += root.val;
        } else if(level>maxLevel){
            sum = 0;
            maxLevel = level;
            sum += root.val;
        }
         dfs(root.left,level+1);
         dfs(root.right,level+1);
    }
    
    public int deepestLeavesSum(TreeNode root) {
        dfs(root,0);
        return sum;
    }
}