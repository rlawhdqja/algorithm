import java.util.*;

class Solution {

    static int n,m;
    static boolean [][] v;
    static int [] di = {0,0,1,-1};
    static int [] dj = {1,-1,0,0};
    static int[] dp;

    public int solution(int[][] land) {
        int answer = 0;
        int max = 0;

        n = land.length;
        m = land[0].length;
        v = new boolean[n][m];

        dp = new int [m];

        for(int j=0; j<m; j++){
            for(int i=0; i<n; i++){
                if(land[i][j] == 1 && !v[i][j]){
                    // max += bfs(i, j, land);
                    bfs(i, j, land);
                }
            }
            // answer = Math.max(answer, max);
            // max = 0;
            // v = new boolean[n][m];
        }

        for(int i=0; i<m; i++){
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }

    static private void bfs(int x, int y, int[][] land){
        int cnt = 1;
        boolean[] b = new boolean[m];
        b[y] = true;
        v[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});

        while(!q.isEmpty()){
            int[] arr = q.poll();
            for(int d=0; d<4; d++){
                int ni = arr[0] + di[d];
                int nj = arr[1] + dj[d];
                if(ni < 0 || ni >= n || nj < 0 || nj >= m || v[ni][nj] || land[ni][nj] == 0) continue;
                if(!b[nj]) b[nj] = true;
                q.offer(new int[] {ni, nj});
                v[ni][nj] = true;
                cnt++;
            }
        }

        for(int i=0; i<m; i++) {
            if(b[i]) dp[i] += cnt;
        }
        // return cnt;
    }
}