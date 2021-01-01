class Solution {
    public Tree solve(Tree node0, Tree node1) {
        Tree n = new Tree();
        return dfs(node0,node1);
        
    }
    
    public Tree dfs(Tree a ,Tree b){
        if(a==null && b==null)
            return null;
        if(a==null)
            return b;
        else if(b==null)
            return a;
        Tree res = new Tree();
        res.val = dfsUtil(a) + dfsUtil(b);
        res.left = dfs(a.left,b.left);
        res.right = dfs(a.right,b.right);
        return res;
    }
    
    public int dfsUtil(Tree root){
        if(root==null)
            return 0;
        return root.val;        
    }
}