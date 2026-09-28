class Solution {
    public int maxDepth(String s) {
        int res = 0;
        int o = 0;
        for(char c : s.toCharArray()){
            if(c == '(') o++;
            else if(c == ')'){
                res = Math.max(res, o);
                o--;
            }
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna