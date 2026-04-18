class Solution {
    public int dp(String s,int i,String t,int[] memo){
        if(i>s.length()) return 0;
        if(t.length()>0){
            if(t.charAt(0)=='0') return 0;
            if(Integer.valueOf(t)>26) return 0;
        }
        if(i==s.length()) return 1;
        if(memo[i]!=-1) return memo[i];
        int one=0,two=0;
        if(i<s.length()){
            one=dp(s,i+1,s.substring(i,i+1),memo);
        }
        if(i<s.length()-1){
            two=dp(s,i+2,s.substring(i,i+2),memo);
        }
        return memo[i]=one+two;
    }
    public int numDecodings(String s) {
        int[] memo=new int[s.length()];
        Arrays.fill(memo,-1);
        return dp(s,0,"",memo);
    }
}