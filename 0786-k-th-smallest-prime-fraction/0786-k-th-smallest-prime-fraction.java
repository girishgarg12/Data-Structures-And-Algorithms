class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Double.compare((double) a[0]/a[1] , (double) b[0]/b[1]));
        int n = arr.length;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                pq.add(new int[]{arr[i],arr[j]});
            }
        }
        while(k-- > 1) pq.remove();
        return pq.remove();

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna