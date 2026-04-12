class Trie {
    class trie {
        trie[] child=new trie[26];
        boolean isEnd;
    }
    trie root;
    public Trie() {
        root=new trie();
    }
    
    public void insert(String word) {
        trie curr=root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(curr.child[index]==null){
                curr.child[index]=new trie();
            }
            curr=curr.child[index];
        }
        curr.isEnd=true;
    }
    
    public boolean search(String word) {
        trie curr=root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(curr.child[index]==null) return false;
            curr=curr.child[index];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        trie curr=root;
        for(char c:prefix.toCharArray()){
            int index=c-'a';
            curr=curr.child[index];
            if(curr==null) return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */