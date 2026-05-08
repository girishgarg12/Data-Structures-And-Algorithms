class Solution {
    public int res=0;
    public void subs(int[] nums,int i,int or,int maxOr){
        if(or==maxOr) res++;
        for(int j=i;j<nums.length;j++){
            int prev=or;
            or|=nums[j];
            subs(nums,j+1,or,maxOr);
            or=prev;
        }
    }
    public int countMaxOrSubsets(int[] nums) {
        int maxOr=0;
        for(int n:nums) maxOr|=n;
        subs(nums,0,0,maxOr);
        return res;
    }
}