class Solution {
    public boolean rec(char[][] board,int i,int j,int idx,String word,boolean[][] visited){
        if(idx==word.length()) return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return false;
        if(board[i][j]!=word.charAt(idx)) return false;
        if(visited[i][j]) return false;
        visited[i][j]=true;
        boolean res= rec(board,i+1,j,idx+1,word,visited) || rec(board,i-1,j,idx+1,word,visited) || rec(board,i,j+1,idx+1,word,visited) || rec(board,i,j-1,idx+1,word,visited);
        visited[i][j]=false;
        return res;

    }
    public boolean exist(char[][] board, String word) {
        int n=board.length,m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean[][] visited=new boolean[n][m];
                    if(rec(board,i,j,0,word,visited)) return true;
                }
            }
        }
        return false;
    }
}