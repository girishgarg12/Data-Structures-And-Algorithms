/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    int res=0;
    public void dfs(HashMap<Integer,Employee> map,int n){
        res+=map.get(n).importance;
        for(int nei:map.get(n).subordinates){
            dfs(map,nei);
        }
    }
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map=new HashMap<>();
        for(Employee e:employees){
            map.put(e.id,e);
        }
        dfs(map,id);
        return res;
    }
}