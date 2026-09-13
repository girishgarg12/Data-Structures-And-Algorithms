class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length, m = img1[0].length;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int x = 0; x < n; x++){
                    for(int y = 0; y < m; y++){
                        if(img2[i][j] == 1 && img1[x][y] == 1) {
                            int dx = x - i;
                            int dy = y - j;
                            String s = dx + "," + dy;
                            map.put(s, map.getOrDefault(s, 0) + 1);
                        }
                    }
                }
            }
        }
        int res = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            res = Math.max(res, entry.getValue());
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna