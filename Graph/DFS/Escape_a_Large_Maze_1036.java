
class Solution {
    HashSet<String> set=new HashSet<>();
    public boolean dfs(int[] src,int[] target,int dist,int i,int j,HashSet<String> visited){
        if(i==target[0] && j==target[1])    return true;
        if(visited.size()>20000)    return true;
        if(i<0 || j<0 || i>=1000000 || j>=1000000) return false;
        if(visited.contains(i+","+j))   return false;
        if(set.contains(i+","+j))    return false;
        visited.add(i+","+j);
        boolean d1=dfs(src,target,Math.abs(src[0]-i)+Math.abs(src[1]-j),i+1,j,visited);
        boolean d2=dfs(src,target,Math.abs(src[0]-i)+Math.abs(src[1]-j),i-1,j,visited);
        boolean d3=dfs(src,target,Math.abs(src[0]-i)+Math.abs(src[1]-j),i,j+1,visited);
        boolean d4=dfs(src,target,Math.abs(src[0]-i)+Math.abs(src[1]-j),i,j-1,visited);
        return d1 || d2 || d3 || d4;
    }
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int n=blocked.length;
        for(int i=0;i<n;i++){
            set.add(blocked[i][0]+","+blocked[i][1]);
        }
        HashSet<String> visited=new HashSet<>();
        boolean r1=dfs(source,target,0,source[0],source[1],visited);
        visited=new HashSet<>();
        boolean r2=dfs(target,source,0,target[0],target[1],visited);
        return r1 && r2;
    }
}