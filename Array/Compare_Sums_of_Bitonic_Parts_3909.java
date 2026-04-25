class Solution {
    public int compareBitonicSums(int[] nums) {
        int n=nums.length,m=0;
        for(int i=0;i<n;i++) if(nums[i]>nums[m]) m=i;
        long asc=0,desc=0;
        for(int i=0;i<m;i++){
            asc+=nums[i];
        }
        for(int i=m+1;i<n;i++){
            desc+=nums[i];
        }
        if(asc>desc) return 0;
        else if(asc<desc) return 1;
        return -1;
    }
}