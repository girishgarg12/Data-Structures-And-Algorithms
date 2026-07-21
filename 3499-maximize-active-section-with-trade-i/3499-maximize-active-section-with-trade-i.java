class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        List<Integer> list = new ArrayList<>();
        int x = 0;
        for(char c : s.toCharArray()){
            if(c == '1'){
                if(x <= 0){
                    list.add(x);
                    x = 1;
                }
                else x++;
            }
            else{
                if(x >= 0){
                    list.add(x);
                    x = -1;
                }
                else x--;
            }
        }
        list.add(x);
        int pos = 0;
        for(int p : list) if(p > 0) pos += p;
        int res = pos;
        for(int i = 0; i < list.size(); i++){
            int curr = list.get(i);
            if(curr > 0){
                int right = (i == list.size()-1) ? 0 : list.get(i+1);
                int left = list.get(i-1);
                int posLeft = pos - curr;
                if(left < 0 && right < 0) res = Math.max(res, Math.abs(left + right) + curr + posLeft);
            }
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna