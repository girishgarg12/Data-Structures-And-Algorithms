class Solution {
    public int minStoneSum(int[] piles, int k) {
        int n=piles.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int x:piles)    pq.add(x);
        while(k-->0){
            int top=pq.poll();
            int nw=(top%2==0)?top/2:(top/2)+1;
            pq.add(nw);
        }
        int s=0;
        while(!pq.isEmpty()){
            s+=pq.poll();
        }
        return s;
    }
}