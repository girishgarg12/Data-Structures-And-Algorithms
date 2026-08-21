class Solution {
    public String replaceDigits(String s) {
        char[] res = s.toCharArray();
        for(int i = 1; i < s.length(); i += 2) {
            res[i] = (char)(res[i-1] + (res[i] - '0'));
        }
        return new String(res);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna