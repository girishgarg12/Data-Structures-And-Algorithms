class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] res = new int[n];
        int idx = 0, d = 0;
        for(int i = 0; i < n; i++){
            if(seq.charAt(i) == '('){
                d++;
                res[idx++] = d % 2;
            }
            else{
                res[idx++] = d % 2;
                d--;
            }
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna