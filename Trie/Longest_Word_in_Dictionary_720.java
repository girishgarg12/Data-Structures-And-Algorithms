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
    boolean isValid(String key){
        trie curr=root;
        int n=key.length();
        for(int i=0;i<n-1;i++){
            int index=key.charAt(i)-'a';
            if(curr.child[index]==null || curr.child[index].isEnd==false) return false;
            curr=curr.child[index];
        }
        return true;
    }
    public String longestWord(String[] words) {
        // Arrays.sort(words,(a,b)->{
        //     if(a.length()==b.length()) return a.compareTo(b);
        //     return a.length()-b.length();
        // });
        String res="";
        for(String s:words){
            insert(s);
        }
        for(String s:words){
            if(s.length()==1 || isValid(s)){
                if(s.length()>res.length()) res=s;
                else if(s.length()==res.length() && s.compareTo(res)<0) res=s;
            }
        }
        return res;
    }
}