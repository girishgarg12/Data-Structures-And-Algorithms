class Solution {
    int res=Integer.MAX_VALUE;
    public void rec(List<Integer> price,List<List<Integer>> special,List<Integer> needs,int i,int cost){
        int d=cost;
        for(int k=0;k<needs.size();k++){
             d+=needs.get(k)*price.get(k);
        }
        res=Math.min(res,d);
        for(int j=i;j<special.size();j++){
            int n=special.get(j).size();
            boolean flag=true;
            for(int k=0;k<n-1;k++){
                if(needs.get(k)<special.get(j).get(k)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                for(int k=0;k<n-1;k++){
                    needs.set(k,needs.get(k)-special.get(j).get(k));
                }
                cost+=special.get(j).get(n-1);
                rec(price,special,needs,j,cost);
                for(int k=0;k<n-1;k++){
                    needs.set(k,needs.get(k)+special.get(j).get(k));
                }
                cost-=special.get(j).get(n-1);
            }
        }
    }
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        rec(price,special,needs,0,0);
        return res;
    }
}