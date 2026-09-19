class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int disx = Math.max(x1, Math.min(xCenter,x2));
        int disy = Math.max(y1 , Math.min(yCenter, y2));
        int x = disx - xCenter;
        int y = disy - yCenter; 

        return x*x + y*y <= radius*radius;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna