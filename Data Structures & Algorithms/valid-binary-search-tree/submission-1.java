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
    public boolean isValidBST(TreeNode root) {

       return valid(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean valid(TreeNode node, int greater, int smaller){
        if(node == null) return true;

        if(node.val <= greater || node.val >= smaller){
            return false;
        }

        return valid(node.left, greater, node.val) && valid(node.right, node.val, smaller);
    }
}
