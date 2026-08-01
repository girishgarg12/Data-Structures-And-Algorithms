class Solution {
    public boolean rec(int[] nums, int i, int j, int p1, int p2, int t){
        if(i > j){
            if(p1 >= p2) return true;
            return false;
        }
        if(t == 1){
            return rec(nums, i+1 , j, p1 + nums[i], p2, 0) || rec(nums, i, j-1, p1+nums[j], p2, 0);
        }
        else return rec(nums, i+1 , j, p1, p2 + nums[i], 1) && rec(nums, i, j-1, p1, p2 + nums[j], 1);

    }
    public boolean predictTheWinner(int[] nums) {
        return rec(nums, 0, nums.length-1, 0, 0 ,1);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna