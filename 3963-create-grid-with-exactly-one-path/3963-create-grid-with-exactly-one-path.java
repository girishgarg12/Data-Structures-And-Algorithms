class Solution {
    public String[] createGrid(int m, int n) {
        String[] res = new String[m];
        int idx=0;
        for(int i=0;i<m-1;i++){
            StringBuilder sb = new StringBuilder(".");
            for(int j=1;j<n;j++){
                sb.append("#");
            }
            res[idx++] = sb.toString();
        }
        String l = "";
        for(int i=0;i<n;i++){
            l+='.';
        }
        res[idx] = l;
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna