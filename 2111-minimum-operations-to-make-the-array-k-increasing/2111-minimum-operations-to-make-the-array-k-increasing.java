class Solution {
    public int bs(List<Integer> list, int x){
        int l = 0, r = list.size()-1;
        while(l < r){
            int mid = l + (r-l)/2;
            if(list.get(mid) <= x) l = mid+1;
            else r = mid;
        }
        return l;
    }
    public int find(List<Integer> chain){
        int n = chain.size();
        List<Integer> tail = new ArrayList<>();
        tail.add(chain.get(0));
        for(int i = 1; i < n; i++){
            int x = chain.get(i);
            if(x < tail.get(tail.size()-1)){
                int idx = bs(tail, x);
                tail.set(idx, x);
            }
            else{
                tail.add(x);
            }
        }
        return tail.size();
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