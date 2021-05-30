import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public int[] solve(Tree root) {
        Queue<Tree> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        int i=0;
        while(!queue.isEmpty()){
            Tree node = (Tree) queue.remove();
            list.add(node.val);
            if(node.left!=null)
            queue.add(node.left);
            if(node.right!=null)
            queue.add(node.right);
        }
        int[] result = new int[list.size()];
        for(int var : list){
            result[i++] = var;
        }
        return result;
    } 
}