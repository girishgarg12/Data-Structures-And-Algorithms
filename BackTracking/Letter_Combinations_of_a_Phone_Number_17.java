class Solution {
    public void dfs(String digits,int i,StringBuilder temp,String[] arr,List<String> res){
        if(i==digits.length()){
            res.add(temp.toString());
            return;
        }
        int idx=digits.charAt(i)-'0';
        String s=arr[idx];
        for(int j=0;j<s.length();j++){
            temp.append(s.charAt(j));
            dfs(digits,i+1,temp,arr,res);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        String[] arr=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res=new ArrayList<>();
        dfs(digits,0,new StringBuilder(),arr,res);
        return res;
    }
}