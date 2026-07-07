class Solution {
    public long sumAndMultiply(int n) {
        int num = 0, c = 1, sum = 0;
        int temp = n;
        while(temp > 0){
            int l = temp % 10;
            if(l > 0){
                if(num == 0) num = l;
                else num = (l* (int)Math.pow(10,c++)) + num;
                sum += l;
            }
            temp /= 10;
        }
        return ((long)num * sum);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna