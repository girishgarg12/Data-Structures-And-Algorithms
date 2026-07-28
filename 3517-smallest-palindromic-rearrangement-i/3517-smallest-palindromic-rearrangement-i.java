class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for(char c : s.toCharArray()) freq[c-'a']++;
        char[] res = new char[n];
        char ch = '@';
        int st = 0, end = n-1;
        for(int i = 0; i < 26; i++){
            char c = (char)(i + 'a');
            if(freq[i] % 2 != 0){
                while(freq[i] > 1){
                    res[st++] = c;
                    res[end--] = c;
                    freq[i] -= 2;
                }
                ch = c;
            }
            else{
                while(freq[i] > 0){
                    res[st++] = c;
                    res[end--] = c;
                    freq[i] -= 2;
                }
            }
        }
        if(ch != '@') res[n/2] = ch;
        return new String(res);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna