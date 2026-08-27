class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        for(char c : s.toCharArray()) freq[c-'a']++;
        for(char c : target.toCharArray()) {
            int idx = c - 'a';
            if(freq[idx] > 0){
                sb.append(c);
                freq[idx]--;
                continue;
            }

            for(int j = idx + 1; j < 26; j++){
                if(freq[j] > 0) {
                    sb.append((char)(j + 'a'));
                    freq[j]--;
                    for(int i = 0; i < 26; i++){
                        while(freq[i] > 0){
                            sb.append((char)(i+'a'));
                            freq[i]--;
                        }
                    }
                    return sb.toString();
                }
            }
            break;
        }
        int len = sb.length();
        for(int i = len - 1; i >= 0; i--){
            int idx = sb.charAt(i) - 'a';
            freq[idx]++;
            for(int j = idx+1; j < 26; j++){
                if(freq[j] > 0){
                    StringBuilder sb2 = new StringBuilder(sb.toString().substring(0,i));
                    sb2.append((char)(j + 'a'));
                    freq[j]--;
                    for(int k = 0; k < 26; k++){
                        while(freq[k] > 0){
                            sb2.append((char)(k+'a'));
                            freq[k]--;
                        }
                    }
                    return sb2.toString();
                }
            }
        }
        return "";
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna