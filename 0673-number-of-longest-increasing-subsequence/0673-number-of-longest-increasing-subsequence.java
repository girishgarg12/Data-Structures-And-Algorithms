class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] lis=new int[n];
        int[] count=new int[n];
        int maxLis=1,res=0;
        for(int i=0;i<n;i++){
            lis[i]=1;
            count[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(lis[j]+1 > lis[i]) {
                        lis[i] = lis[j] + 1;
                        count[i] = count[j];
                    }
                    else if(lis[j] + 1 == lis[i]) {
                        count[i] += count[j];
                    }
                }
            }
            maxLis=Math.max(maxLis,lis[i]);
        }
        for(int i=0;i<n;i++){
            if(lis[i]==maxLis) res+=count[i];
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna