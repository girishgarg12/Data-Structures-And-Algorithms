class Solution {
    public int minOperations(int[][] grid, int x) {
        int n=grid.length,m=grid[0].length;
        int[] arr=new int[n*m];
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[c++]=grid[i][j];
            }
        }
        Arrays.sort(arr);
        int median=arr.length/2;
        int res=0;
        for(int i:arr){
            int diff=Math.abs(i-arr[median]);
            if(diff%x!=0) return -1;
            res+=diff/x;
        }
        return res;
    }
}