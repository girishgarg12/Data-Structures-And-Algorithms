class Solution {
    class pair {
        String first;
        int second;
        pair(String first,int second){
            this.first = first;
            this.second = second;
        }
    }
    class trie {
        trie[] child = new trie[26];
        int best = -1;
        boolean isEnd;
    }
    trie root = new trie();

    public void insert(pair p) {
        String s = p.first;
        trie curr = root;
        int len = s.length();
        for(int i=0;i<len;i++){
            int idx = s.charAt(i) - 'a';
            if(curr.child[idx] == null){
                curr.child[idx] = new trie();
            }
            curr = curr.child[idx];
            if(curr.best == -1) curr.best = p.second;
        }
        curr.isEnd=true;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int n = wordsContainer.length;
        int m = wordsQuery.length;
        pair[] p = new pair[n];
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder(wordsContainer[i]);
            String rev = sb.reverse().toString();
            p[i] = new pair(rev,i);
        }
        Arrays.sort(p, (a,b) -> a.first.length() - b.first.length());
        for(int i=0;i<n;i++) insert(p[i]);
        int[] res = new int[m];
        int idx=0;
        for(String s : wordsQuery){
            int len = s.length();
            trie curr = root;
            for(int i=len-1;i>=0;i--){
                int idxx = s.charAt(i) - 'a';
                if(curr.child[idxx] == null) break;
                curr = curr.child[idxx];
            }
            if(curr!=root) res[idx++] = curr.best;
            else res[idx++] = p[0].second;
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna