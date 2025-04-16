/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { val = val; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null or root is p or q
        if (root == null || root == p || root == q) {
            return root;
        }
        
        // Recursively find LCA in left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If both left and right are non-null, root is the LCA
        if (left != null && right != null) {
            return root;
        }
        
        // If one of the subtrees is null, return the non-null child (left or right)
        return left != null ? left : right;
    }
}
