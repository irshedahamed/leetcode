/**
 Url : https://leetcode.com/problems/binary-tree-level-order-traversal-ii/submissions/
 
 
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
          List<List<Integer>> resultList = new ArrayList<>();
        if(root==null)
                return resultList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int length = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i = 0;i < length;i++){
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            resultList.add(0,levelList);
        }
        return resultList;
    }
}