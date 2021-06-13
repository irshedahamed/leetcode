/**
Url :  https://leetcode.com/problems/sum-root-to-leaf-numbers/submissions/
 
 */
class Solution {
    int totalSum = 0;
    
    public void dfs(int sum, TreeNode root){
        if(root == null)
            return;
        
        sum = sum*10 + root.val;
        
        if(root.left == null && root.right == null){
           totalSum += sum;
        }
        
        dfs(sum,root.left);
        dfs(sum,root.right);
    }
    
    public int sumNumbers(TreeNode root) {
        dfs(0,root);
        return totalSum;
    }
}