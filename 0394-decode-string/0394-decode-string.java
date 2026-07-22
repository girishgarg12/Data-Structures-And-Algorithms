class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ']'){
                StringBuilder sb = new StringBuilder();
                while(!s.isEmpty() && c == ']' && st.peek() != '['){
                    sb.append(st.pop());
                }
                st.pop();
                sb.reverse();
                StringBuilder num = new StringBuilder();
                while(!st.isEmpty() && st.peek() >= '0' && st.peek() <= '9'){
                    num.append(st.pop());
                }
                num.reverse();
                int n = Integer.valueOf(num.toString());
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < sb.length(); j++){
                        st.push(sb.charAt(j));
                    }
                }
            }
            else st.push(c);
        }
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()) res.append(st.pop());
        res.reverse();
        return res.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna