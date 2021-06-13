/**
 Url : https://leetcode.com/problems/path-sum-ii/
 */
class Solution {
    List<List<Integer>> result;
    Integer resultSum;
    
    public void find(TreeNode root,int sum,List<Integer> currentPath){
        if(root == null)
            return;
        
        currentPath.add(root.val);
        sum += root.val;
        
        if(sum == resultSum && (root.left == null && root.right == null)){
            result.add(new ArrayList<>(currentPath));
        }
        
        find(root.left,sum,currentPath);
        find(root.right,sum,currentPath);
        
        currentPath.remove(currentPath.size()-1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        resultSum = targetSum;
        
        List<Integer> currentPath = new ArrayList<>();
        find(root,0,currentPath);
        return result;
    }
}