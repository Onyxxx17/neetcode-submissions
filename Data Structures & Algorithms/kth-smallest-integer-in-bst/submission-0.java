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
    public int kthSmallest(TreeNode root, int k) {
        //Use inorder traversal
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res.get(k-1);
    }

    public void inorder(TreeNode node, List<Integer> res){
        if(node == null){
            return;
        }
        inorder(node.left,res);
        res.add(node.val);
        inorder(node.right,res);
    }
}
