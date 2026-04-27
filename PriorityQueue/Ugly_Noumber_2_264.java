class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        HashSet<Long> set=new HashSet<>();
        pq.add((long)1);
        int c=1;
        while(c<n){
            long curr=pq.poll();
            if(!set.contains(curr*2)){
                pq.add(curr*2);
                set.add(curr*2);
            }
            if(!set.contains(curr*3)){
                pq.add(curr*3);
                set.add(curr*3);
            }
            if(!set.contains(curr*5)){
                pq.add(curr*5);
                set.add(curr*5);
            }
            c++;
        }
        return (int)(long)pq.poll();
    }
}