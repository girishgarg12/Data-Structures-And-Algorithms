class Solution {
    class trie {
        trie[] child=new trie[26];
        int count;
    }
    trie root=new trie();
    void insert(String key){
        trie curr=root;
        int n=key.length();
        for(int i=0;i<n;i++){
            int index=key.charAt(i)-'a';
            if(curr.child[index]==null){
                curr.child[index]=new trie();
            }
            curr=curr.child[index];
            curr.count++;
        }
    }
    public void dfs(trie curr,int d,int[] valid,int k){
        if(curr==null) return;
        if(d>0 && curr.count>=k){
            valid[d]++;
        }
        for(int i=0;i<26;i++){
            dfs(curr.child[i],d+1,valid,k);
        }
    }
    public int[] longestCommonPrefix(String[] words, int k) {
        int maxD=0;
        for(String s:words){
            insert(s);
            maxD=Math.max(maxD,s.length());
        }
        int[] valid=new int[maxD+1];
        dfs(root,0,valid,k);
        int n=words.length;
        int[] res=new int[n];
        int idx=0;
        for(String s:words){
            List<trie> path=new ArrayList<>();
            trie curr=root;

            for(char c:s.toCharArray()){
                curr=curr.child[c-'a'];
                path.add(curr);
            }

            for(int i=0;i<s.length();i++){
                trie no=path.get(i);
                if(no.count==k){
                    valid[i+1]--;
                }
                no.count--;
            }

            int b=0;
            for(int i=valid.length-1;i>=1;i--){
                if(valid[i]>0){
                    b=i;
                    break;
                }
            }
            res[idx++]=b;

            for(int i=0;i<s.length();i++){
                trie no=path.get(i);
                no.count++;
                if(no.count==k){
                    valid[i+1]++;
                }
            }
        }
        return res;
    }
}