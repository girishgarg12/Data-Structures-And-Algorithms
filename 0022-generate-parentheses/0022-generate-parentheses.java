class Solution {
    public void rec(String s,int op,int cl,int n,List<String> res){
        if(s.length()==2*n){
            res.add(s);
            return;
        }
        if(op<n){
            rec(s+'(',op+1,cl,n,res);
        }
        if(cl<op){
            rec(s+')',op,cl+1,n,res);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        rec("",0,0,n,res);
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna