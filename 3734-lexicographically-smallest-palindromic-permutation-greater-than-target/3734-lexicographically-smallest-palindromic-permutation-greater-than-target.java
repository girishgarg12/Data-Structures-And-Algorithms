class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int len = (n % 2 == 0) ? n/2 : (n-1)/2;
        String tar = target.substring(0, len);
        int[] freq = new int[26];
        int o = 0, oddIdx = -1;
        for(char c : s.toCharArray()){
            freq[c - 'a']++; 
        }
        for(int i = 0; i < 26; i++){
            if(freq[i] % 2 != 0 && freq[i] != 0){
                o++;
                oddIdx = i;
            }
            freq[i] /= 2;
        }
        if(n % 2 == 0 && o > 0) return "";
        if(n % 2 != 0 && o > 1) return "";

        StringBuilder sb = new StringBuilder();
        boolean gr = false;
        for(char c : tar.toCharArray()){
            int idx = c - 'a';
            if(freq[idx] > 0){
                sb.append(c);
                freq[idx]--;
                continue;
            }
            for(int i = idx + 1; i < 26; i++){
                if(freq[i] > 0){
                    gr = true;
                    sb.append((char)(i + 'a'));
                    freq[i]--;
                    for(int j = 0; j < 26; j++){
                        while(freq[j] > 0){
                            sb.append((char)(j + 'a'));
                            freq[j]--;
                        }
                    }
                    break;
                }
            }
            break;
        }
        StringBuilder sb2 = new StringBuilder(sb);

        if(!gr && sb.length() == len){

            StringBuilder temp = new StringBuilder(sb);

            if(o > 0){
                temp.append((char)(oddIdx + 'a'));
            }

            temp.append(new StringBuilder(sb).reverse());

            if(temp.toString().compareTo(target) > 0){
                return temp.toString();
            }
        }

        if(!gr) {
            int m = sb.length();
            StringBuilder sb2Temp = new StringBuilder(sb);
            int[] originalFreq = freq.clone();

            boolean found = false;

            for(int i = m - 1; i >= 0; i--){
                freq = originalFreq.clone();

                for(int k = i; k < m; k++){
                    freq[sb.charAt(k) - 'a']++;
                }

                int idx = sb.charAt(i) - 'a';

                for(int j = idx + 1; j < 26; j++){
                    if(freq[j] > 0){
                        sb2Temp = new StringBuilder(sb.substring(0, i));
                        sb2Temp.append((char)(j + 'a'));
                        freq[j]--;

                        for(int k = 0; k < 26; k++){
                            while(freq[k] > 0){
                                sb2Temp.append((char)(k + 'a'));
                                freq[k]--;
                            }
                        }

                        found = true;
                        break;
                    }
                }

                if(found)
                    break;
            }
            if(sb2Temp.length() != len)
                return "";

            sb2 = sb2Temp;
        }
        
        StringBuilder rev = new StringBuilder(sb2);
        if(o > 0){
            sb2.append((char)(oddIdx + 'a'));
        }
        sb2.append(rev.reverse());

        if(sb2.toString().compareTo(target) <= 0){
            return "";
        }

        return sb2.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna