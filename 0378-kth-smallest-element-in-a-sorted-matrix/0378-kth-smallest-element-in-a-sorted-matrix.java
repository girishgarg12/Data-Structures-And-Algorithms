class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        int l = matrix[0][0], h = matrix[n-1][m-1];
        while(l <= h){
            int mid = l + (h-l)/2;
            int count = 0;
            int max = l;
            for(int row = 0;row < n;row++){
                int col = m-1;
                while(col >= 0 && matrix[row][col] > mid){
                    col--;
                }
                if(col >= 0){
                    count += col+1;
                    max = Math.max(max,matrix[row][col]);
                }
            }
            if(count < k) l = mid+1;
            else h = mid-1;
        }
        return l;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna