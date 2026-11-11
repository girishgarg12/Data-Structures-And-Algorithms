class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long both = Math.min(need1, need2);
        long max = Math.max(need1, need2);
        long costa = (long) need1 * cost1 + (long) need2 * cost2;
        long costb = costBoth * both + (need1 - both) * (long)cost1 + (need2 - both) * (long)cost2;
        long costc = costBoth * max;
        return Math.min(costa, Math.min(costb, costc));
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna