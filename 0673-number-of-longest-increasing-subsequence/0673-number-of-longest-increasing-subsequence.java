class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] lis=new int[n];
        lis[0]=1;
        int max=1;
        for(int i=1;i<n;i++){
            lis[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    lis[i]=Math.max(lis[j]+1,lis[i]);
                }
            }
            max=Math.max(max,lis[i]);
        }
        if(max==1) return n;
        int[] count=new int[n];
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(lis[j]+1==lis[i])    count[i]+=Math.max(1,count[j]);
                }
            }
            if(lis[i]==max) res+=count[i];
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna