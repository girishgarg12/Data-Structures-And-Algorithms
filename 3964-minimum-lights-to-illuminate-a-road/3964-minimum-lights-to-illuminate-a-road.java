class Solution {
    public int minLights(int[] lights) {
        int n = lights.length;
        int[] diff = new int[n+1];
        for(int i=0;i<n;i++){
            if(lights[i] > 0){
                int l = Math.max(0,i-lights[i]);
                int r = Math.min(n-1,i+lights[i]);
                diff[l]++;
                if(r<n) diff[r+1]--;
            }
        }
        int res = 0,curr=0;
        int len = 0;
        for(int i=0;i<n;i++){
            curr += diff[i];
            if(curr<=0){
               len++;
            }
            else{
                res += (len+2)/3;
                len=0;
            }
        }
        res += (len+2)/3;
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna