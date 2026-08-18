class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n - k + 1; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = i; j < i + k; j++){
                if(!set.contains(nums[j])){
                    map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                    set.add(nums[j]);
                }
            }
        }
        int res = -1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1) res = Math.max(res, entry.getKey());
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna