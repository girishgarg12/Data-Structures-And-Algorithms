class Solution {
    public int vowelConsonantScore(String s) {
        int v = 0, con = 0;
        for(char c : s.toCharArray()){
            if(c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u') v++;
            else if(c >= 'a' && c <= 'z')   con++;
        }
        if(con == 0) return 0;
        return (int)Math.floor(v/con);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna