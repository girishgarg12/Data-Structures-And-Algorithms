class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> set=new HashSet<>();
        for(int n:arr1){
            String s=String.valueOf(n);
            String r="";
            for(char c:s.toCharArray()){
                r+=c;
                set.add(r);
            }
        }
        int res=0;
        for(int n:arr2){
            String s=String.valueOf(n);
            String r="";
            for(char c:s.toCharArray()){
                r+=c;
                if(set.contains(r)) res=Math.max(res,r.length());
            }
        }
        return res;
    }
}