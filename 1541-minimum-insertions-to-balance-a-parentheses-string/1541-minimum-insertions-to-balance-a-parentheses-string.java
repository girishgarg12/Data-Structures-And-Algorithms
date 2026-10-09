class Solution {
    public int minInsertions(String s) {
        int op = 0;
        int n = s.length();
        int res = 0, i = 0;
        while(i < n) {
            char c = s.charAt(i);
            if(c == '(') {
                op++;
                i++;
            }
            else if(i < n-1 && c == ')' && s.charAt(i+1) == ')'){
                if(op == 0) res++;
                else op--;
                i+=2;
            }
            else{
                res++;
                if(op == 0) res++;
                else op--;
                i++;
            }
        }
        res += 2 * op;
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna