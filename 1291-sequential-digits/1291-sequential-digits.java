class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        String[] digits = new String[]{"1","2","3","4","5","6","7","8","9"};
        int l = 0;
        StringBuilder sb = new StringBuilder();
        for(int r = 0; r < 9; r++){
            sb.append(digits[r]);
            int val = Integer.valueOf(sb.toString());
            while(val > high){
                sb.deleteCharAt(0);
                val = Integer.valueOf(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder(sb);
            while(val >= low && val <= high){
                res.add(val);
                sb2.deleteCharAt(0);
                val = Integer.valueOf(sb2.toString());
            }
        }
        Collections.sort(res);
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna