class Solution {
    class trie {
        trie[] child=new trie[26];
        int isEnd=-1;
        List<Integer> list=new ArrayList<>();
    }
    trie root=new trie();
    public boolean isPal(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    public void insert(String key,int idx){
        trie curr=root;
        for(int i=key.length()-1;i>=0;i--){
            if(isPal(key,0,i)){
                curr.list.add(idx);
            }
            int index=key.charAt(i)-'a';
            if(curr.child[index]==null){
                curr.child[index]=new trie();
            }
            curr=curr.child[index];
        }
        curr.isEnd=idx;
        curr.list.add(idx);
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res=new ArrayList<>();
        int n=words.length;
        for(int i=0;i<n;i++) insert(words[i],i);
        for(int i=0;i<n;i++){
            String s=words[i];
            trie curr=root;
            for(int j=0;j<s.length();j++){
                if(curr.isEnd!=-1 && curr.isEnd!=i && isPal(s,j,s.length()-1)){
                    res.add(Arrays.asList(i,curr.isEnd));
                }
                int index=s.charAt(j)-'a';
                curr=curr.child[index];
                if(curr==null) break;
            }
            if(curr==null) continue;
            for(int idx:curr.list){
                if(i!=idx) res.add(Arrays.asList(i,idx));
            }
        }
        return res;
    }
}