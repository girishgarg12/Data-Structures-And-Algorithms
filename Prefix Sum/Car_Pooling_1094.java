class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // Arrays.sort(trips,(a,b)->a[1]-b[1]);
        int currCap=0;
        for(int d=0;d<=1000;d++){
            for(int i=0;i<trips.length;i++){
                if(trips[i][1]==d) currCap+=trips[i][0];
                if(trips[i][2]==d) currCap-=trips[i][0];
            }
            if(currCap>capacity) return false;
        }
        return true;
    }
}