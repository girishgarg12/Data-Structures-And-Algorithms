class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int p1=0,p2=0;
        while(p1<nums1.length && p2<nums2.length){
            if(nums1[p1]<nums2[p2]) p1++;
            else if(nums1[p1]>nums2[p2]) p2++;
            else return nums1[p1];
        }
        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna