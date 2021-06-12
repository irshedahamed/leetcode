/**
Url : https://leetcode.com/problems/minimum-depth-of-binary-tree/submissions/


 */
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        int minLevel = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelLength = queue.size();
            minLevel++;
            for(int i=0;i<levelLength;i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null)
                    return minLevel;
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
        }
        return minLevel;
    }
}