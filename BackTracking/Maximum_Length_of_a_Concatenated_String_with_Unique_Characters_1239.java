class Solution {
    int res=0;
    public void dfs(List<String> arr,int i,int c,int[] freq){
        if(i<=arr.size()){
            boolean flag=true;
            for(int k=0;k<26;k++){
                if(freq[k]>1){
                    flag=false;
                    break;
                }
            }
            if(flag) res=Math.max(res,c);
        }
        for(int j=i;j<arr.size();j++){
            String s=arr.get(j);
            for(char ch:s.toCharArray()) freq[ch-'a']++;
            dfs(arr,j+1,c+s.length(),freq);
            for(char ch:s.toCharArray()) freq[ch-'a']--;
        }
    }
    public int maxLength(List<String> arr) {
        int[] freq=new int[26];
        List<String> valid=new ArrayList<>();
        for(String s:arr){
            int[] f=new int[26];
            boolean fl=true;
            for(char c:s.toCharArray()){
                if(f[c-'a']>0){
                    fl=false;
                    break;
                }
                f[c-'a']++;
            }
            if(fl) valid.add(s);
        }
        dfs(valid,0,0,freq);
        return res;
    }
}