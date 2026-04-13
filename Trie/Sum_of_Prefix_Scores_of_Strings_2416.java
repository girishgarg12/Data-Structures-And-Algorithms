class Solution {
    class trie {
        trie[] child=new trie[26];
        int count;
    }
    trie root=new trie();
    public void insert(String key){
        trie curr=root;
        for(int i=0;i<key.length();i++){
            int index=key.charAt(i)-'a';
            if(curr.child[index]==null){
                curr.child[index]=new trie();
            }
            curr=curr.child[index];
            curr.count++;
        }
    }
    public int[] sumPrefixScores(String[] words) {
        int n=words.length;
        int[] res=new int[n];
        for(String s:words) insert(s);
        int idx=0;
        for(String s:words){
            trie curr=root;
            int co=0;
            for(char c:s.toCharArray()){
                int index=c-'a';
                curr=curr.child[index];
                if(curr==null) break;
                co+=curr.count;
            }
            res[idx++]=co;
        }
    return res;
    }
}