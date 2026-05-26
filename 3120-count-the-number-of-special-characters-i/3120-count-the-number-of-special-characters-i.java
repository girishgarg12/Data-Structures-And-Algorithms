class Solution {
    public int numberOfSpecialChars(String word) {
        int[] freq = new int[52];
        for(char c:word.toCharArray()){
            if(c>='a' && c<='z') freq[c-'a']++;
            else freq[c-'A'+26]++;
        }
        int res=0;
        for(int i=0;i<26;i++){
            if(freq[i]>0 && freq[i+26]>0) res++;
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna