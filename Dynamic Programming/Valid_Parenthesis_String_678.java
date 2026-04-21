class Solution {
    public boolean dp(String s,int i,int op,Stack<Character> st,Boolean[][] memo){
        if(i==s.length() && st.isEmpty()) return true;
        if(i==s.length()) return false;
        if(memo[i][op]!=null) return memo[i][op];
        if(s.charAt(i)=='('){
            st.add('(');
            boolean res=dp(s,i+1,op+1,st,memo);
            st.pop();
            memo[i][op]=res;
        }
        else if(s.charAt(i)==')'){
            if(st.isEmpty()) return memo[i][op]=false;
            st.pop();
            boolean res=dp(s,i+1,op-1,st,memo);
            st.add('(');
            memo[i][op]=res;
        }
        else{
            boolean res=false;
            st.add('(');
            res|=dp(s,i+1,op+1,st,memo);
            st.pop();
            res|=dp(s,i+1,op,st,memo);
            if(!st.isEmpty()){
                st.pop();
                res|=dp(s,i+1,op-1,st,memo);
                st.add('(');
            } 
            memo[i][op]=res;
        }
        return memo[i][op];
    }
    public boolean checkValidString(String s) {
        int n=s.length();
        Boolean[][] memo=new Boolean[n][n];
        for(int i=0;i<n;i++) Arrays.fill(memo[i],null);
        Stack<Character> st=new Stack<>();
        return dp(s,0,0,st,memo);
    }
}