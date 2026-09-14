class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0], x2 = rec1[2];
        int y1 = rec1[1], y2 = rec1[3];
        if((rec2[0] >= x2) || (rec2[2] <= x1)) return false;
        if((rec2[1] >= y2) || (rec2[3] <= y1)) return false;
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna