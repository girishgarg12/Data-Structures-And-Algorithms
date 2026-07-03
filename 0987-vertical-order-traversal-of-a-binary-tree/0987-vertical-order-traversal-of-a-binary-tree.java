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
    class truple {
        TreeNode node;
        int h, v;
        truple(TreeNode node, int h, int v){
            this.node = node;
            this.h = h;
            this.v = v;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<truple> q =new ArrayDeque<>();
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        q.add(new truple(root, 0, 0));
        while(!q.isEmpty()){
            truple t = q.remove();
            TreeNode node = t.node;
            int h = t.h;
            int v = t.v;
            min = Math.min(min, h);
            max = Math.max(max, h);
            map.putIfAbsent(h, new ArrayList<>());
            map.get(h).add(new int[]{v,node.val});
            if(node.left != null) q.add(new truple(node.left, h-1, v+1));
            if(node.right != null) q.add(new truple(node.right, h+1, v+1));
        }
        for(int i = min; i <= max; i++){
            List<int[]> list = map.get(i);
            Collections.sort(list, (a,b) -> {
                if(a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            });
            List<Integer> temp = new ArrayList<>();
            for(int[] x : list) temp.add(x[1]);
            res.add(new ArrayList<>(temp));
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna