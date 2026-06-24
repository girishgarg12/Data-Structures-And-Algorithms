class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int l = 0, h = n*m-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            int ele = matrix[mid/m][mid%m];
            if(ele == target) return true;
            else if(ele < target){
                l = mid + 1;
            }
            else h = mid - 1;
        }
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna