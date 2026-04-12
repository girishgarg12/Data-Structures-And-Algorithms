class trie {
    trie[] child=new trie[26];
    String isEnd;
}
class Solution {
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
        curr.isEnd=key;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        for(String s:dictionary) insert(s);
        String res="";
        String[] arr=sentence.split(" ");
        int n=arr.length;
        for(int i=0;i<n;i++){
            String s=arr[i];
            trie curr=root;
            String in=s;
            for(char c:s.toCharArray()){
                int index=c-'a';
                curr=curr.child[index];
                if(curr==null) break;
                if(curr.isEnd!=null){
                    in=curr.isEnd;
                    break;
                }
            }
            res+=in;
            if(i!=n-1) res+=" ";
        }
        return res;
    }
}