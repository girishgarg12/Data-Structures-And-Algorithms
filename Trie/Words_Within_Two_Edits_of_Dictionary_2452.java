class Solution {
    class trie {
        trie[] child=new trie[26];
        boolean isEnd;
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
        }
        curr.isEnd=true;
    }
    public boolean dfs(String s,trie curr,int c,int i){
        if(curr==null) return false;
        if(i==s.length()){
            return curr.isEnd && c<=2;
        }
        int index=s.charAt(i)-'a';
        if(c<2){
            for(int j=0;j<26;j++){
                if(dfs(s,curr.child[j],c+1,i+1)) return true;
            }
        }
        return dfs(s,curr.child[index],c,i+1);
    }
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res=new ArrayList<>();
        for(String s:dictionary) insert(s);
        for(String s:queries){
            if(dfs(s,root,0,0)) res.add(s);
        }
        return res;
    }
}