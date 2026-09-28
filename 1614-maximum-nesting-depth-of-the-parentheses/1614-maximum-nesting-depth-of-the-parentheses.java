class Solution {
    public int maxDepth(String s) {
        int res = 0;
        Stack<Integer> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(') st.push(1);
            else if(c == ')'){
                res = Math.max(res, st.size());
                st.pop();
            }
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna