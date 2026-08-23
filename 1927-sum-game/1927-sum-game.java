class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftQ = 0, rightQ = 0, leftS = 0, rightS = 0;
        int len = 0;
        for(char c : num.toCharArray()) {
            len++;
            if(c >= '0' && c <= '9'){
                if(len <= n/2)  leftS += c - '0';
                else rightS += c - '0';
            }
            else{
                if(len <= n/2)  leftQ++;
                else rightQ++;
            }
        }
        if((leftQ + rightQ) % 2 != 0) return true;
        if(rightQ == leftQ) {
            if(leftS - rightS != 0) return true;
        }
        int q = rightQ - leftQ;
        int diff = leftS - rightS;
        if(diff != (9*(q/2))) return true;
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna