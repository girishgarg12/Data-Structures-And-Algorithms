class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);
            if(map.containsKey(sorted)){
                map.get(sorted).add(s);
            }
            else{
                map.putIfAbsent(sorted, new ArrayList<>());
                map.get(sorted).add(s);
            }
        }
        for(Map.Entry<String, List<String>> e : map.entrySet()){
            res.add(new ArrayList<>(e.getValue()));
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna