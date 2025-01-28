package Practice.Graphs;

public class SurroundedRegions {
    public void solve(char[][] board) {

        int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        int rows = board.length;
        int cols = board[0].length;

        for(int j=0; j<cols; j++){
            if(board[0][j] == 'O'){
                dfs(board,0,j,dirs,'$');
            }
        }
        for(int j=0; j<cols; j++){
            if(board[rows-1][j] == 'O'){
                dfs(board,rows-1,j,dirs,'$');
            }
        }
        for(int i=0; i<rows; i++){
            if(board[i][0] == 'O'){
                dfs(board,i,0,dirs,'$');
            }
        }
        for(int i=0; i<rows; i++){
            if(board[i][cols-1] == 'O'){
                dfs(board,i,cols-1,dirs,'$');
            }
        }

        for(int i = 0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j] == '$'){
                    board[i][j] = 'O';
                }else if( board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int row, int col, int[][] dirs, char flag){
        board[row][col] = flag;
        int dx, dy;
        for(int[] dir : dirs){
            dx = dir[0] + row;
            dy = dir[1] + col;
            if(isValid(dx, dy, board.length, board[0].length) && board[dx][dy] == 'O'){
                dfs(board, dx, dy, dirs, flag);
            }
        }
    }

    public boolean isValid(int row, int col, int rows, int cols){
        if(row >= rows || col >= cols || row < 0 || col < 0) return false;
        return true;
    }
}
