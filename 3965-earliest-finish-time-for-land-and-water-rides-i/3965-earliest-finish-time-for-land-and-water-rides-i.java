class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int res1 = Integer.MAX_VALUE, res2 = Integer.MAX_VALUE;
        int n = landStartTime.length, m = waterStartTime.length;
        int minLand = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            minLand = Math.min(minLand,landStartTime[i]+landDuration[i]);
        }
        for(int i=0;i<m;i++){
            int watTime = 0;
            if(minLand > waterStartTime[i]) watTime = waterDuration[i];
            else watTime = (waterStartTime[i] - minLand) + waterDuration[i];
            res1 = Math.min(res1,minLand + watTime);
        }
        int minWater = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            minWater = Math.min(minWater,waterStartTime[i]+waterDuration[i]);
        }
        for(int i=0;i<n;i++){
            int landTime = 0;
            if(minWater > landStartTime[i]) landTime = landDuration[i];
            else landTime = (landStartTime[i] - minWater) + landDuration[i];
            res2 = Math.min(res2,minWater + landTime);
        }

        return Math.min(res1,res2);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna