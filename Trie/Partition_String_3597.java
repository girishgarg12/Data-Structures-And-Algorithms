class Solution {
    class trie {
        trie[] child=new trie[26];
        boolean isEnd;
    }
    trie root=new trie();
    void insert(String key){
        trie curr=root;
        for(int i=0;i<key.length();i++){
            int index=key.charAt(i)-'a';
            if(curr.child[index]==null){
                curr.child[index]=new trie();
            }
            curr=curr.child[index];
        }
        curr.isEnd=true;
    }
    public List<String> partitionString(String s) {
        List<String> res=new ArrayList<>();
        int n=s.length();
        String in="";
        trie curr=root;
        for(int i=0;i<n;i++){
            in+=s.charAt(i);
            int index=s.charAt(i)-'a';
            curr=curr.child[index];
            if(curr==null || !curr.isEnd){
                res.add(in);
                insert(in);
                in="";
                curr=root;
            }
        }
        return res;
    }
}