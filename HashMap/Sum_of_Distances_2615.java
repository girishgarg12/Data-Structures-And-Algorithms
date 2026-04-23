class Solution {
    public long[] distance(int[] nums) {
        int n=nums.length;
        long[] res1=new long[n];
        long[] res2=new long[n];
        HashMap<Integer,Integer> freq=new HashMap<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(freq.containsKey(nums[i])){
                res1[i]+=(freq.get(nums[i])*(i-map.get(nums[i])))+res1[map.get(nums[i])];
            }
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
            map.put(nums[i],i);
        }
        
        freq=new HashMap<>();
        map=new HashMap<>();
        for(int i=n-1;i>=0;i--){
            if(freq.containsKey(nums[i])){
                res2[i]+=(freq.get(nums[i])*(map.get(nums[i])-i))+res2[map.get(nums[i])];
            }
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
            map.put(nums[i],i);
        }
        for(int i=0;i<n;i++){
            res1[i]+=res2[i];
        }
        return res1;
    }
}