class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int l = 0, r = 0;
        StringBuilder sb = new StringBuilder();
        String res = "";
        int ones = 0;
        for(r = 0; r < n; r++){
            char c = s.charAt(r);
            sb.append(c);
            if(c == '1') ones++;
            while(ones >= k){
                if(ones == k) {
                    if(sb.length() < res.length() || res.length() == 0){
                        res = sb.toString();
                    }
                    else if (sb.length() == res.length()){
                        if(sb.toString().compareTo(res) < 0){
                            res = sb.toString();
                        }
                    }
                }
                if(s.charAt(l) == '1') ones--;
                l++;
                sb.deleteCharAt(0);
            }
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna