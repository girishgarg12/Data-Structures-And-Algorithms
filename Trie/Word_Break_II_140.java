class trie {
    trie[] child=new trie[26];
    boolean isEnd;
}
class Solution {
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
        }
        curr.isEnd=true;
    }
    boolean search(String key){
        trie curr=root;
        int n=key.length();
        for(int i=0;i<n;i++){
            int index=key.charAt(i)-'a';
            if(curr.child[index]==null){
                return false;
            }
            curr=curr.child[index];
        }
        return curr.isEnd;
    }
    public void dfs(String s,String temp,int st,List<String> res){
        if(st==s.length()){
            res.add(temp);
            return;
        }
        trie curr=root;
        for(int i=st;i<s.length();i++){
            int index=s.charAt(i)-'a';
            if(curr.child[index]==null) break;
            curr=curr.child[index];
            if(curr.isEnd){
                String word=s.substring(st, i + 1);
                String t=(temp.length() == 0)?word:temp + " " + word;
                dfs(s,t,i+1,res);
            }

        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        for(String s1:wordDict) insert(s1);
        List<String> res=new ArrayList<>();
        dfs(s,"",0,res);
        return res;
    }
}