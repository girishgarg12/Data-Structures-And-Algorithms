class Solution {
    public int find(List<Integer> chain){
        int n = chain.size();
        int[] tail = new int[n];
        int len = 0;
        for(int x : chain){
            int l = 0, r = len;
            while(l < r){
                int mid = l + (r-l)/2;
                if(tail[mid] <= x) l = mid+1;
                else r = mid;
            }
            tail[l] = x;
            if(l == len) len++;
        }
        return len;
    }
    public int kIncreasing(int[] arr, int k) {
        int res = 0, n = arr.length;
        for(int i = 0; i < k; i++){
            List<Integer> chain = new ArrayList<>();
            for(int j = i; j < n; j+=k) chain.add(arr[j]);
            int len = find(chain);
            res += chain.size() - len;
        }
        return res;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna