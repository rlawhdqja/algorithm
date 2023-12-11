import java.util.*;

class Solution {

    static int[] di = {0,0,1,-1};
    static int[] dj = {1,-1,0,0};

    static int min, N, M;

    public int solution(String[] board) {
        int answer = 0;
        min = Integer.MAX_VALUE-1;

        N = board.length;
        M = board[0].length();

        char [][] board_ch = new char[N][M];

        for(int i=0; i<N; i++){
            board_ch[i] = board[i].toCharArray();
        }

        // boolean [][] v = new boolean[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board_ch[i][j]=='R') {
                    // v[i][j] = true;
                    // dfs(0, i, j, board_ch, v);
                    answer = bfs(i,j,board_ch);
                }
            }
        }
        // answer = min == Integer.MAX_VALUE-1 ? -1 : min;
        return answer;
    }

    static private int bfs(int x, int y, char[][] board){

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y,0});

        boolean [][] v = new boolean[N][M];
        v[x][y] = true;

        while(!q.isEmpty()){
            int[] arr = q.poll();
            int i = arr[0];
            int j = arr[1];
            int c = arr[2];
            if(board[i][j]=='G') {
                return c;
            }
            for(int d=0; d<4; d++){
                int ni = i+di[d];
                int nj = j+dj[d];

                while(ni>=0 && ni<N && nj>=0 && nj<M && board[ni][nj]!='D'){
                    ni += di[d];
                    nj += dj[d];
                }
                ni -= di[d];
                nj -= dj[d];
                if(v[ni][nj]) continue;
                v[ni][nj] = true;
                q.offer(new int []{ni,nj,c+1});
            }
        }
        return -1;
    }



    static private void dfs(int c, int i, int j, char[][] board, boolean[][] v){
        if(c>=min) return;
        if(board[i][j]=='G') {
            min = c;
            return;
        }

        for(int d=0; d<4; d++){
            int ni = i+di[d];
            int nj = j+dj[d];

            while(ni>=0 && ni<N && nj>=0 && nj<M && board[ni][nj]!='D'){
                ni += di[d];
                nj += dj[d];
            }
            ni -= di[d];
            nj -= dj[d];
            if(v[ni][nj]) continue;
            v[ni][nj] = true;
            dfs(c+1, ni, nj, board, v);
            v[ni][nj] = false;
        }

        return;
    }
}