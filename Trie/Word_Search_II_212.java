class trie {
    trie[] child=new trie[26];
    String isEnd;
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
        curr.isEnd=key;
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
        return curr.isEnd.equals(key);
    }
    public void dfs(char[][] board,int i,int j,boolean[][] visited,List<String> res,trie curr){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || visited[i][j]) return;
        if(curr.child[board[i][j]-'a']==null) return;
        curr=curr.child[board[i][j]-'a'];
        if(curr.isEnd!=null){
            res.add(curr.isEnd);
            curr.isEnd=null;
        }
        visited[i][j]=true;
        dfs(board,i+1,j,visited,res,curr);
        dfs(board,i-1,j,visited,res,curr);
        dfs(board,i,j+1,visited,res,curr);
        dfs(board,i,j-1,visited,res,curr);
        visited[i][j]=false;
    }
    public List<String> findWords(char[][] board, String[] words) {
        for(String s:words) insert(s);
        List<String> res=new ArrayList<>();
        int n=board.length,m=board[0].length;
        boolean[][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dfs(board,i,j,visited,res,root);
            }
        }
        return res;
    }
}