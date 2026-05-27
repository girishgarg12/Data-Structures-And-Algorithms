class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] freqL = new boolean[26];
        boolean[] freqU = new boolean[26];
        for(char c:word.toCharArray()){
            if(c>='a' && c<='z'){
                freqL[c-'a'] = true;
                if(freqU[c-'a'])    freqL[c-'a'] = false;
            }
            else{
                if(!freqU[c-'A']) freqU[c-'A'] = true;
            }
        }
        int res=0;
        for(int i=0;i<26;i++){
            if(freqL[i] && freqU[i]) res++;
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna