class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] copy = Arrays.copyOf(arr, n);
        Arrays.sort(copy);
        HashMap<Integer, Integer> map = new HashMap<>();
        int c = 0;
        for(int i = 0; i < n; i++){
            if(!map.containsKey(copy[i])){
                map.put(copy[i], c++);
            }
        }
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = map.get(arr[i]) + 1;
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna