// class Solution {
//     public boolean carPooling(int[][] trips, int capacity) {
//         // Arrays.sort(trips,(a,b)->a[1]-b[1]);
//         int currCap=0;
//         for(int d=0;d<=1000;d++){
//             for(int i=0;i<trips.length;i++){
//                 if(trips[i][1]==d) currCap+=trips[i][0];
//                 if(trips[i][2]==d) currCap-=trips[i][0];
//             }
//             if(currCap>capacity) return false;
//         }
//         return true;
//     }
// }

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int max=0;
        for(int[] a:trips) max=Math.max(max,a[2]);
        int[] pre=new int[max+1];
        for(int[] a:trips){
            pre[a[1]]+=a[0];
            pre[a[2]]-=a[0];
        }
        int currCap=0;
        for(int i=0;i<max+1;i++){
            currCap+=pre[i];
            if(currCap>capacity) return false;
        }
        return true;
    }
}