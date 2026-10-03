class Solution {
    public int longestValidParentheses(String s) {
        int res=0;
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')    st.push(i);
            else{
                st.pop();
                if(!st.isEmpty())   res=Math.max(res,i-st.peek());
                else st.push(i);
            }
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna