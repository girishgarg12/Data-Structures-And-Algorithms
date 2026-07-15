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
    public int SumAtRoot(TreeNode root, long target){
        if(root == null) return 0;
        if(target - root.val == 0) return 1 + SumAtRoot(root.left, target - root.val) + SumAtRoot(root.right, target - root.val);
        return SumAtRoot(root.left, target - root.val) + SumAtRoot(root.right, target - root.val);
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        int curr = 0;
        curr = SumAtRoot(root, targetSum);
        int l = pathSum(root.left, targetSum);
        int r = pathSum(root.right, targetSum);
        return curr + l + r;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna