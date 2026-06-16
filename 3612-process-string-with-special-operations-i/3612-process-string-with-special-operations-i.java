class Solution {
    public String processStr(String s) {
        StringBuilder res=new StringBuilder();
        for(char c:s.toCharArray()){
            if(c>='a'&&c<='z') res.append(c);
            else if(c=='*'){
                if(res.length()>0){
                    String rem=res.substring(0,res.length()-1);
                    res=new StringBuilder(rem);
                }
            }
            else if(c=='#'){
                res.append(res);
            }
            else{
                res.reverse();
            }
        }
        return res.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna