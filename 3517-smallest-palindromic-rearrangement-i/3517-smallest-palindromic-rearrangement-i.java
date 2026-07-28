class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()) freq[c-'a']++;
        StringBuilder sb = new StringBuilder();
        char ch = '@';
        int st = 0, end = 0;
        for(int i = 0; i < 26; i++){
            char c = (char)(i + 'a');
            if(freq[i] % 2 != 0){
                while(freq[i] > 1){
                    sb.insert(0 + (st++), c);
                    sb.insert(sb.length()-1 - (end++), c);
                    freq[i] -= 2;
                }
                ch = c;
            }
            else{
                while(freq[i] > 0){
                    sb.insert(0 + (st++), c);
                    sb.insert(sb.length()-1 - (end++), c);
                    freq[i] -= 2;
                }
            }
        }
        if(ch != '@') sb.insert(sb.length()/2, ch);
        return sb.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna