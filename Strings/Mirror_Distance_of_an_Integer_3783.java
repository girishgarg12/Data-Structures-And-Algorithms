class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n-Integer.valueOf(new StringBuilder(String.valueOf(n)).reverse().toString()));
    }
}