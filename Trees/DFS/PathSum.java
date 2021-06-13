/**
 
 Url : https://leetcode.com/problems/path-sum/submissions/
 
 */
class Solution {

    public boolean dfs(TreeNode root,int currentSum,int targetSum){
        if(root == null)
            return false;
        
        currentSum += root.val;
        if(currentSum == targetSum && (root.left == null && root.right == null))
            return true;
        
        return dfs(root.left,currentSum,targetSum) || dfs(root.right,currentSum,targetSum);
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
         return dfs(root,0,targetSum);
    }
}