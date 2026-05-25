class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1') return false;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        int farthest = 0; 
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == n - 1) return true;
            int start = Math.max(curr + minJump, farthest);
            int end = Math.min(curr + maxJump, n - 1);
            farthest = Math.max(farthest, end + 1);
            for (int i = start; i <= end; i++) {
                if (s.charAt(i) == '0') {
                    q.add(i);
                }
            }
        }
        return false;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna