class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        Integer[] freq = new Integer[26];
        Arrays.fill(freq,0);
        for(char c : word.toCharArray()){
            freq[c-'a']++;
        }
        Arrays.sort(freq, Collections.reverseOrder());
        int res = 0, c = 1;
        for(int i = 0; i < 26; i++){
            if(freq[i] == 0) break;
            if(i != 0 && i%8 == 0) c++;
            res += freq[i] * c;
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna