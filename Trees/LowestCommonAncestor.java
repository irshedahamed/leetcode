/**

Url : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    int flag = 0;
    TreeNode result; 
    
    public int dfs(TreeNode root,TreeNode p,TreeNode q){
        if(root == null)
            return 0;
        
        int count = 0;
        if(root == p || root == q)
            count++;
            
       int left =  dfs(root.left,p,q);
       int right = dfs(root.right,p,q);
        
        
        if(left+right+count  = 2 && flag == 0){
            flag = 1;
            result = root;
        }
        return left+right+count;
            
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        dfs(root,p,q);
        return result;
    }
}