class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> res=new ArrayList<>();
        int idx=0;
        for(int n:nums){
            int temp=n;
            int len=0;
            while(temp>0){
                res.add(idx,temp%10);
                temp/=10;
                len++;
            }
            idx+=len;
        }
        int[] ans=new int[res.size()];
        int i=0;
        for(int n:res) ans[i++]=n;
        return ans;
    }
}