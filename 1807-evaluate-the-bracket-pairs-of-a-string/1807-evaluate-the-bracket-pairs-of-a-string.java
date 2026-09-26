class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        HashMap<String, String> map = new HashMap<>();
        for(List<String> list : knowledge){
            map.put(list.get(0), list.get(1));
        }
        int i = 0;
        StringBuilder res = new StringBuilder();
        while(i < n) {
            char c = s.charAt(i);
            StringBuilder sb = new StringBuilder();
            if(c == '('){
                while(true){
                    i++;
                    if(s.charAt(i) == ')') break;
                    sb.append(s.charAt(i));
                }
            }
            if(s.charAt(i) == ')'){
                if(map.containsKey(sb.toString())){
                    res.append(map.get(sb.toString()));
                }
                else res.append("?");
            }
            else res.append(s.charAt(i));
            i++;
        }
        return res.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna