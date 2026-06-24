class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int stRow = 0, stCol = m-1;
        while(stRow < n && stCol >= 0){
            int ele = matrix[stRow][stCol];
            if(ele == target) return true;
            else if(ele > target) stCol--;
            else stRow++;
        }
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna