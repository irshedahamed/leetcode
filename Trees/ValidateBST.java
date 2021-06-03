/*
Validate Binary Search Tree 

Url : https://leetcode.com/problems/validate-binary-search-tree/submissions/
*/

class Solution {
    Integer high = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        
        if(!isValidBST(root.left))
            return false;
        
        if(high!=null && root.val <= high)
            return false;
        
        high = root.val;
        return isValidBST(root.right);
    }
}