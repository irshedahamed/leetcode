/*
	Url - Binary Search : https://binarysearch.com/problems/Count-Nodes-in-Complete-Binary-Tree
	Url - LeetCode : https://leetcode.com/problems/count-complete-tree-nodes/submissions/
 */
class Solution {
    public int countNodes(TreeNode root) {
        int left = 0;
        int right = 0;
        for(TreeNode curr = root;curr!=null;curr=curr.left,left++);
        for(TreeNode curr = root;curr!=null;curr=curr.right,right++);
        if(left == right){
            return ((int)Math.pow(2,left) - 1);
        }else{
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}