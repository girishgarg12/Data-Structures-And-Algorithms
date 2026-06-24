class Solution {
    public int findMax(int[][] mat, int c){
        int maxRow = 0;
        for(int i=1;i<mat.length;i++){
            if(mat[i][c] > mat[maxRow][c]){
                maxRow = i;
            }
        }
        return maxRow;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int l = 0, h = m-1;
        while(l <= h){
            int mid = l + (h-l)/2;
            int maxRow = findMax(mat,mid);
            int left = (mid == 0) ? -1 : mat[maxRow][mid-1];
            int right = (mid == m-1) ? -1 : mat[maxRow][mid+1];
            if(mat[maxRow][mid] > left && mat[maxRow][mid] > right) return new int[]{maxRow,mid};
            if(mat[maxRow][mid] > left) l = mid+1;
            else h = mid-1;
        }
        return new int[]{-1,-1};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna