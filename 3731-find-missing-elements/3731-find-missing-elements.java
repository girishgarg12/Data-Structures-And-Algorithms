class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int st = nums[0] + 1;
        int i = 1;
        while(i < n){
            if(st == nums[i]){
                i++;
                st++;
                continue;
            }
            res.add(st);
            st++;
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna