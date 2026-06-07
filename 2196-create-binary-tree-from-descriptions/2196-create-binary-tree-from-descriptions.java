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
    class pair {
        int left;
        int right;
        pair(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode buildTree(int rootVal, HashMap<Integer,pair> map){
        TreeNode root = new TreeNode(rootVal);
        if(!map.containsKey(rootVal)) return root;
        if(map.get(rootVal).left != -1){
            root.left = buildTree(map.get(rootVal).left, map);
        }
        else root.left = null;
        if(map.get(rootVal).right != -1){
            root.right = buildTree(map.get(rootVal).right, map);
        }
        else root.right = null;
        return root;
    }
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,pair> map = new HashMap<>();
        HashMap<Integer,Boolean> isRoot = new HashMap<>();
        int n = descriptions.length;
        for(int i=0;i<n;i++){
            int p = descriptions[i][0], c = descriptions[i][1];
            if(descriptions[i][2] == 1){
                if(!map.containsKey(p)) map.put(p,new pair(c,-1));
                else map.put(p,new pair(c,map.get(p).right));
            }
            else{
                if(!map.containsKey(p)) map.put(p,new pair(-1,c));
                else map.put(p,new pair(map.get(p).left,c));
            }
            isRoot.put(c,false);
        }
        int r = -1;
        for(int i=0;i<n;i++){
            if(!isRoot.containsKey(descriptions[i][0])){
                r = descriptions[i][0];
                break;
            }
        }
        return buildTree(r,map);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna