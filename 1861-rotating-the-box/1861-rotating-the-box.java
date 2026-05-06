class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n=boxGrid.length,m=boxGrid[0].length;
        char[][] mat=new char[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[j][n-i-1]=boxGrid[i][j];
            }
        }
        for(int j=0;j<n;j++){
            int low=m;
            for(int i=m-1;i>=0;i--){
                if(mat[i][j]=='#'){
                    low--;
                    if(low!=i){
                        mat[low][j]='#';
                        mat[i][j]='.';
                    }
                }
                else if(mat[i][j]=='*'){
                    low=i;
                }
            }
        }
        return mat;
    }
}