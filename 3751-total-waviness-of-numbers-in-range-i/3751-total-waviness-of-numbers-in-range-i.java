class Solution {
    public int totalWaviness(int num1, int num2) {
        int res = 0;
        for(int i=num1;i<=num2;i++){
            int w = 0;
            String s = String.valueOf(i);
            for(int j=1;j<s.length()-1;j++){
                if(s.charAt(j)>s.charAt(j-1) && s.charAt(j)>s.charAt(j+1)) w++;
                if(s.charAt(j)<s.charAt(j-1) && s.charAt(j)<s.charAt(j+1)) w++;
            }
            res += w;
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna