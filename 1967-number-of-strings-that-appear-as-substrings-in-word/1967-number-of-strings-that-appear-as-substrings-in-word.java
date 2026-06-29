class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for(String s : patterns) if(word.contains(s)) res++;
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna