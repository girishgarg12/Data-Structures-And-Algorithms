class Solution {
    public int numTeams(int[] rating) {
        int res=0,n=rating.length;
        for(int i=0;i<n;i++){
            int leftSm=0,leftGr=0;
            int rightSm=0,rightGr=0;
            for(int j=0;j<i;j++){
                if(rating[j]<rating[i]) leftSm++;
                else leftGr++;
            }
            for(int j=i+1;j<n;j++){
                if(rating[j]<rating[i]) rightSm++;
                else rightGr++;
            }
            res+=leftSm*rightGr;
            res+=leftGr*rightSm;
        }
        return res;
    }
}