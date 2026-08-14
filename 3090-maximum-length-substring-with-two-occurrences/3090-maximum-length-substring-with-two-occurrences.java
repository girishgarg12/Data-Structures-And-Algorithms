class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int[] freq = new int[26];
        int l = 0;
        int res = 0;
        for(int r = 0; r < n; r++){
            int ch = s.charAt(r);
            freq[ch - 'a']++;
            while(freq[ch - 'a'] > 2){
                freq[s.charAt(l) - 'a']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna