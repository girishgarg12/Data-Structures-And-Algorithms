class Solution {
    public int mirrorFrequency(String s) {
        int[] freq=new int[128];
        int res=0;
        for(char c:s.toCharArray()) freq[c]++;
        for(int i=0;i<13;i++){
            res+=Math.abs(freq['a'+i]-freq['z'-i])+((i<5)?Math.abs(freq['0'+i]-freq['9'-i]):0);
        }
        return res;
    }
}