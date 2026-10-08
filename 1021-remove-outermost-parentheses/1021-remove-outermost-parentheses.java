class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int n = s.length();
        int br = 0, prev = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '(') br++;
            else br--;
            if(br == 0){
                res.append(s.substring(prev + 1, i));
                prev = i + 1;
            }
        }
        return res.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna