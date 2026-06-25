class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String x : words) map.put(x, map.getOrDefault(x,0)+1);
        HashMap<String,Integer> seen = new HashMap<>();
        int n = s.length(), m = words.length;
        int len = words[0].length();
        List<Integer> res = new ArrayList<>();
        int l = 0;
        int count = 0;
        for(int st = 0; st < len; st++){
            l = st;
            seen = new HashMap<>();
            for(int r = st; r < n-len+1; r += len){
                String curr = s.substring(r,r+len);
                if(map.containsKey(curr)){
                    seen.put(curr,seen.getOrDefault(curr,0)+1);
                    while(seen.get(curr) > map.get(curr)){
                        String last = s.substring(l,l+len);
                        seen.put(last,seen.get(last)-1);
                        if(seen.get(last) == 0) seen.remove(last);
                        l += len;
                    }
                    if(seen.equals(map)) res.add(l);
                }
                else{
                    seen = new HashMap<>();
                    l = r+len;
                }
            }
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna