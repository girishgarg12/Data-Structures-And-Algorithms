class Solution {
    public int[][] generateMatrix(int n) {
        int c=1;
        int top=0,bottom=n-1,left=0,right=n-1;
        int[][] mat=new int[n][n];
        while(c<=n*n){
            for(int i=left;i<=right;i++){
                mat[top][i]=c;
                c++;
            }
            top++;
            for(int i=top;i<=bottom;i++){
                mat[i][right]=c;
                c++;
            }
            right--;
            for(int i=right;i>=left;i--){
                mat[bottom][i]=c;
                c++;
            }
            bottom--;
            for(int i=bottom;i>=top;i--){
                mat[i][left]=c;
                c++;
            }
            left++;
        }
        return mat;
    }
}