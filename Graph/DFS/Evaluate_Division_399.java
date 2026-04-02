class pair {
    String first;
    double second;
    pair(String first,Double second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public double dfs(HashMap<String,List<pair>> map,String n,String dest,double val,HashSet<String> visited){
        if(n.equals(dest)){
            return val;
        }
        visited.add(n);
        for(pair nei:map.get(n)){
            String newNo=nei.first;
            double dis=nei.second;
            if(!visited.contains(newNo)){
                double res=dfs(map,newNo,dest,val*dis,visited);
                if(res!=-1) return res;
            }
        }
        return -1;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n=equations.size();
        HashMap<String,List<pair>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            String a=equations.get(i).get(0);
            String b=equations.get(i).get(1);
            if(!map.containsKey(a)) map.put(a,new ArrayList<>());
            if(!map.containsKey(b)) map.put(b,new ArrayList<>());
            map.get(a).add(new pair(b,values[i]));
            map.get(b).add(new pair(a,1/values[i]));
        }
        int m=queries.size();
        double[] res=new double[m];
        for(int i=0;i<m;i++){
            HashSet<String> visited=new HashSet<>();
            String a=queries.get(i).get(0);
            String b=queries.get(i).get(1);
            if(!map.containsKey(a) || !map.containsKey(b)) res[i]=-1;
            else res[i]=dfs(map,a,b,1,visited);
        }
        return res;
    }
}