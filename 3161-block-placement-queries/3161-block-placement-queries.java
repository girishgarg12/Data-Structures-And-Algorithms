import java.util.*;

class Solution {
    public List<Boolean> getResults(int[][] q) {
        List<Boolean> ans = new ArrayList<>();
        int n = q.length;
        List<Integer> bar = new ArrayList<>();
        Map<Integer, int[]> mpp = new HashMap<>();
        TreeSet<int[]> s = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        bar.add(0);
        bar.add(50001);
        for (int i = 0; i < n; i++) {
            if (q[i][0] == 1) bar.add(q[i][1]);
        }
        Collections.sort(bar);
        int sz = bar.size();
        mpp.put(bar.get(0), new int[]{bar.get(0), bar.get(1)});
        for (int i = 1; i < sz - 1; i++) {
            mpp.put(bar.get(i), new int[]{bar.get(i - 1), bar.get(i + 1)});
        }
        mpp.put(bar.get(sz - 1), new int[]{bar.get(sz - 2), 0});
        for (int i = 0; i < sz - 1; i++) {
            s.add(new int[]{bar.get(i + 1) - bar.get(i), bar.get(i)});
        }
        s.add(new int[]{0, bar.get(sz - 1)});
        for (int i = n - 1; i >= 0; i--) {
            if (q[i][0] == 1) {
                int x = q[i][1];
                int xL = mpp.get(x)[0];
                int xR = mpp.get(x)[1];
                s.remove(new int[]{x - xL, xL});
                s.remove(new int[]{xR - x, x});
                mpp.get(xL)[1] = xR;
                mpp.get(xR)[0] = xL;
                s.add(new int[]{xR - xL, xL});
            } 
            else {
                int x = q[i][1];
                int dist = q[i][2];
                if (dist > x) {
                    ans.add(false);
                    continue;
                }
                int[] it = s.ceiling(new int[]{dist, 0});
                boolean can = false;
                while (it != null) {
                    if (dist + it[1] <= x) {
                        can = true;
                        break;
                    }
                    it = s.higher(it);
                }
                ans.add(can);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna