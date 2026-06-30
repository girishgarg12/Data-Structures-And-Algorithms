class Solution {
    public int numberOfSubstrings(String s) {
        int lastA=-1,lastB=-1,lastC=-1;
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a') lastA=i;
            else if(s.charAt(i)=='b') lastB=i;
            else lastC=i;

            int min=Math.min(lastA,lastB);
            int minidx=Math.min(min,lastC);

            if(lastA>=0&&lastB>=0&&lastC>=0){
                res+=(minidx+1);
            }
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna