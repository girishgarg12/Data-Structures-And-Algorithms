class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] x : reservedSeats){
            map.putIfAbsent(x[0], new ArrayList<>());
            map.get(x[0]).add(x[1]);
        }
        int res = 0;
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            boolean[] seats = new boolean[11];
            for(int x : entry.getValue()){
                seats[x] = true;
            }
            boolean left = !(seats[2] || seats[3] || seats[4] || seats[5]);
            boolean mid = !(seats[4] || seats[5] || seats[6] || seats[7]);
            boolean right = !(seats[6] || seats[7] || seats[8] || seats[9]);
            if(left && right) res += 2;
            else if(left || right || mid) res += 1;
        }
        res += (n - map.size()) * 2;
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna