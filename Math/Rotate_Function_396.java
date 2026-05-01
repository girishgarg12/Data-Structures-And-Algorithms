class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum=0,temp=0,n=nums.length;
        for(int i=0;i<nums.length;i++){
            temp+=(i*nums[i]);
            sum+=nums[i];
        }
        int res=temp,t=0;
        for(int i=n-1;i>=0;i--){
            t=temp-(nums[i]*(n-1))+(sum-nums[i]);
            temp=t;
            res=Math.max(res,t);
        }
        return res;
    }
}