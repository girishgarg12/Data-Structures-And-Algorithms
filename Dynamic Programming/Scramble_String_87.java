class Solution {
    HashMap<String,Boolean> map=new HashMap<>();
    public boolean dp(String s1,String s2){
        int n=s1.length();
        if(s1.equals(s2)) return true;
        if(n==1) return false;
        String key=s1+" "+s2;
        if(map.containsKey(key)) return map.get(key);
        for(int i=1;i<n;i++){
            if(dp(s1.substring(0,i),s2.substring(0,i)) && dp(s1.substring(i,n),s2.substring(i,n))){
             map.put(key,true);
             return true;
            }
            if(dp(s1.substring(0,i),s2.substring(n-i,n)) && dp(s1.substring(i,n),s2.substring(0,n-i))){
                 map.put(key,true);
                 return true;
            }
        }
        map.put(key,false);
        return false;
    }
    public boolean isScramble(String s1, String s2) {
        return dp(s1,s2);
    }
}