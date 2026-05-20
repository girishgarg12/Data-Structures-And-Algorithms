class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[n+1];
        int[] res=new int[n];
        int c=0;
        for(int i=0;i<n;i++){
            freq[A[i]]++;
            if(freq[A[i]] == 2) c++;
            freq[B[i]]++;
            if(freq[B[i]] == 2) c++;
            res[i] = c;
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna