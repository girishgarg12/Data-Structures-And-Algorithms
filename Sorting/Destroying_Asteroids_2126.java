class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m=mass;int n=asteroids.length;
        for(int i=0;i<n;i++){
            if(m<asteroids[i]) return false;
            m+=asteroids[i];
        }
        return true;
    }
}