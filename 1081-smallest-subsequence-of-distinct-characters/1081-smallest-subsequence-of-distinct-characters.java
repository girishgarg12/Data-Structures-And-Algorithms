class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        Set<Character> set = new HashSet<>();
        int[] lastIdx = new int[26];
        for(int i = 0; i < n; i++) lastIdx[s.charAt(i) - 'a'] = i;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(set.contains(c)) continue;
            while(!st.isEmpty() && st.peek() > c && lastIdx[st.peek() - 'a'] > i){
                set.remove(st.pop());
            }
            st.add(c);
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) sb.insert(0,st.pop());
        return sb.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna