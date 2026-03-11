class Solution {
    public void dfs(char[][] board,int i,int j,boolean[][] visited){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length)   return;
        if(board[i][j]=='X' || visited[i][j])    return;
        visited[i][j]=true;
        dfs(board,i+1,j,visited);
        dfs(board,i-1,j,visited);
        dfs(board,i,j+1,visited);
        dfs(board,i,j-1,visited);
    }
    public void solve(char[][] board) {
        int n=board.length,m=board[0].length;
        boolean[][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                   if(board[i][j]=='O') dfs(board,i,j,visited);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
}