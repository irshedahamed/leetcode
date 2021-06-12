/**
Url : https://leetcode.com/problems/average-of-levels-in-binary-tree/

Input: root = [3,9,20,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return resultList;
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelLength = queue.size();
            Double levelSum = 0.0;
            for(int i = 0;i< levelLength;i++){
             TreeNode node  = queue.poll();
    
                levelSum += node.val;
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            Double levelAvg = levelSum / levelLength;
            resultList.add(levelAvg);
        }
        return resultList;
    }
}