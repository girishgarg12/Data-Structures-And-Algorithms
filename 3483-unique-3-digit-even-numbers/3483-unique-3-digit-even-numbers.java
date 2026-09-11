class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        int[] freq = new int[10];
        for(int x : digits) freq[x]++;
        int res = 0;
        for(int last = 0; last < 9; last += 2){
            if(freq[last] == 0) continue;
            freq[last]--;
            for(int start = 1; start <= 9; start++){
                if(freq[start] == 0) continue;
                freq[start]--;
                for(int mid = 0; mid <= 9; mid++){
                    if(freq[mid] > 0) res++;
                }
                freq[start]++;
            }
            freq[last]++;
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna