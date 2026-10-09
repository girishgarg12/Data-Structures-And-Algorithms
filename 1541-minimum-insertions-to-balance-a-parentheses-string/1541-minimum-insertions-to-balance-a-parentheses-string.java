class Solution {
    public int minInsertions(String s) {
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        int res = 0, i = 0;
        while(i < n) {
            char c = s.charAt(i);
            if(c == '(') {
                st.push(1);
                i++;
            }
            else if(i < n-1 && c == ')' && s.charAt(i+1) == ')'){
                if(st.isEmpty()) res++;
                else st.pop();
                i+=2;
            }
            else{
                res++;
                if(st.isEmpty()) res++;
                else st.pop();
                i++;
            }
        }
        res += 2 * st.size();
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna