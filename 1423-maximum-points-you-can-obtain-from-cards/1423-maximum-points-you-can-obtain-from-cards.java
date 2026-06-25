class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0, n = cardPoints.length;
        for(int i = 0; i < k; i++) leftSum += cardPoints[i];
        int rightSum = 0, r = n-1;
        int res = leftSum;
        for(int i = k-1; i>=0 ; i--){
            leftSum -= cardPoints[i];
            rightSum += cardPoints[r--];
            res = Math.max(res, leftSum + rightSum);
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna