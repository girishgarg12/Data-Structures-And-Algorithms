class Solution {
    public int ceil(List<Integer> tail,int x){
        int l=0,r=tail.size()-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(tail.get(mid)>=x) r=mid;
            else l=mid+1;
        }
        return r;
    }
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });
        int n=envelopes.length;
        List<Integer> tail=new ArrayList<>();
        tail.add(envelopes[0][1]);
        for(int i=1;i<n;i++){
            int t=envelopes[i][1];
            if(t>tail.get(tail.size()-1)) tail.add(t);
            else{
                int c=ceil(tail,t);
                tail.set(c,t);
            }
        }
        return tail.size();
    }
}