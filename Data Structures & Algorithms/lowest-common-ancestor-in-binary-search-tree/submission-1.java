/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //2 cases
        //1. both p and q are greater than root
        //2. both p and q are smaller than root
        // If both cases are not true, this is the lowest common ancestor

        TreeNode curr = root;
        while(curr != null){
            if(p.val < curr.val && q.val < curr.val){
                curr = curr.left;
            } else if(p.val > curr.val && q.val > curr.val){
                curr = curr.right;
            } else{
                return curr;
            }
        }

        return curr;
    }
}
