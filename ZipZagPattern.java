/*Given a singly linked list node, convert it to a binary tree path using these rules:

    The head of the linked list is the root.
    Each subsequent node is the left child of the parent if its value is smaller, otherwise it's the right child.

Constraints

    n ≤ 100,000 where n is the number of nodes in node


*/

class Solution {
    public Tree solve(LLNode node) {
        if(node==null)return null;
        Tree tree = new Tree(node.val);
        Tree trav = tree;
        node = node.next;
        while(node!=null){
            if(node.val<trav.val){
                trav.left = new Tree(node.val);
                trav = trav.left;
            }
            else{
                 trav.right = new Tree(node.val);
                trav = trav.right;
            }
          node = node.next;  
          }
    return tree;
    }
}