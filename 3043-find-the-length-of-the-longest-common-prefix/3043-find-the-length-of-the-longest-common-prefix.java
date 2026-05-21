class Solution {
    class trie {
        trie[] child = new trie[10];
    }
    trie root = new trie();

    public void insert(String s){
        int n=s.length();
        trie curr = root;
        for(int i=0;i<n;i++){
            int idx = s.charAt(i) - '0';
            if(curr.child[idx] == null){
                curr.child[idx] = new trie();
            }
            curr = curr.child[idx];
        }

    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        for(int x : arr2) insert(String.valueOf(x));
        int res = 0;
        for(int x : arr1){
            String s = String.valueOf(x);
            trie curr = root;
            curr = root;
            int c = 0 , i=0;
            while(curr!=null && i<s.length()){
                int idx = s.charAt(i) - '0';
                curr = curr.child[idx];
                if(curr==null) break;
                c++; i++;
            }
            res = Math.max(res,c);
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna