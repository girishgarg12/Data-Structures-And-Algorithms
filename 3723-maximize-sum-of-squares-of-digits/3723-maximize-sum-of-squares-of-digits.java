class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(num*9 < sum) return "";
        int c = sum/9;
        StringBuilder sb = new StringBuilder();
        while(c-- > 0){
            sb.append('9');
            sum -= 9;
        }
        if(sum != 0)    sb.append(sum);
        while(sb.length() < num) sb.append('0');
        return sb.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna