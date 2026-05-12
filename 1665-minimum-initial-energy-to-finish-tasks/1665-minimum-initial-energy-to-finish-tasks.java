class Solution {
    public int minimumEffort(int[][] tasks) {
        int n=tasks.length;
        Arrays.sort(tasks,(a,b)->(b[1]-b[0])-(a[1]-a[0]));
        int res=0,init=0;
        for(int i=0;i<n;i++){
            if(init<tasks[i][1]){
                res+=tasks[i][1]-init;
                init=tasks[i][1];
                init-=tasks[i][0];
            }
            else{
                init-=tasks[i][0];
            }
        }
        return res;  
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna