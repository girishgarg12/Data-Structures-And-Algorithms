class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][3];
        for(int i = 0; i < n; i++){
            int x = nums[i], s = 0;
            arr[i][0] = x;
            while(x > 0){
                s += x%10;
                x /= 10;
            }
            arr[i][1] = s;
            arr[i][2] = i;
        }
        Arrays.sort(arr, (a,b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int res = 0;
        boolean vis[] = new boolean[n];
        for(int i = 0; i < n; i++){
            if(vis[i] || nums[i] == arr[i][0]) continue;
            
            int noOfElemInCycle = 0;
            int j = i;
            while (!vis[j]) {
                vis[j] = true;
                j = arr[j][2];
                noOfElemInCycle++;
            }

            res += noOfElemInCycle - 1;
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna