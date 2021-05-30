/**
 Url : https://binarysearch.com/problems/Count-BST-Nodes-in-a-Range
 */

class Solution {
  int leafLevel = -1;

  public boolean check(Tree root,int level){
      if(root == null)
        return true;
    
     if(root.left == null && root.right == null){
         if(leafLevel == -1){
             leafLevel = level;
         }

         return leafLevel == level;
     }

     return check(root.left,level+1) && check (root.right,level+1);
  }

    public boolean solve(Tree root) {
        return check(root,0);
    }
}
