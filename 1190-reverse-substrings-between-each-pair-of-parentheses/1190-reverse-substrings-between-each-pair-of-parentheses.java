class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb =  new StringBuilder(s);
        int n = s.length();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }
            else if(s.charAt(i) == ')'){
                int prev = st.pop();
                StringBuilder rev = new StringBuilder(sb.substring(prev+1, i));
                sb.replace(prev + 1, i, rev.reverse().toString());
            }
        }
        for(int i = n-1; i >= 0; i--){
            if(sb.charAt(i) == '(' || sb.charAt(i) == ')') sb.deleteCharAt(i);
        }
        return sb.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna