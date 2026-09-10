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
    int res = 0;
    public int[] rec(TreeNode root) {
        if(root == null) return new int[]{0,0};
        int[] l = rec(root.left);
        int[] r = rec(root.right);
        int sum = root.val + l[0] + r[0];
        int c = 1 + l[1] + r[1];
        if(root.val == (sum/c)) res++;
        return new int[]{sum, c};
    }
    public int averageOfSubtree(TreeNode root) {
        rec(root);
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna