class Solution {
    public boolean isPal(String s, int i , int j) {
        while(i <= j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int res = 0;
        int lastEnd = -1;

        for (int j = k - 1; j < n; j++) {
            for (int i = 0; i <= j - k + 1; i++) {
                if (i > lastEnd && isPal(s, i, j)) {
                    res++;
                    lastEnd = j;
                    break;
                }
            }
        }
        
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna