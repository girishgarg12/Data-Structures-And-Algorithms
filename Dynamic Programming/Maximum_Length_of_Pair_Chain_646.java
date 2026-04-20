class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        int res=1,n=pairs.length;
        int[] lis=new int[n];
        lis[0]=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(pairs[j][1]<pairs[i][0]){
                    res=Math.max(res,lis[j]+1);
                }
            }
            lis[i]=res;
        }
        return res;
    }
}