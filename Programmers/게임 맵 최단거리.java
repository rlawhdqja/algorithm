import java.util.*;
class Solution {

    static int[] di = {0,0,-1,1};
    static int[] dj = {-1,1,0,0};
    // static int answer;
    // static int MAX = Integer.MAX_VALUE-1;
    // static boolean[][] v;
    // static int[][] map;
    public int solution(int[][] maps) {
        // answer = MAX;
        int n = maps.length;
        int m = maps[0].length;
        // map = maps;
        // v = new boolean[n][m];
        // v[0][0] = true;
        // dfs(n,m,0,0,1);
        // return answer==MAX ? -1 : answer;
        return bfs(n, m, maps);

    }
    // static public void dfs(int n, int m, int i, int j, int cnt){
    //     if(i==n-1 && j==m-1){
    //         answer = answer > cnt ? cnt : answer;
    //         return;
    //     }
    //     for(int d=0; d<4; d++){
    //         int ni = i + di[d];
    //         int nj = j + dj[d];
    //         if(ni<0 || ni>=n || nj<0 || nj>=m || map[ni][nj]==0 || v[ni][nj]) continue;
    //         v[ni][nj] = true;
    //         dfs(n,m,ni, nj, cnt+1);
    //         v[ni][nj] = false;
    //     }
    // }


    static public int bfs(int n, int m, int[][] map){
        Queue<int[]> q = new LinkedList<>();
        boolean [][] v = new boolean[n][m];
        q.offer(new int []{0,0,1});
        v[0][0] = true;
        while(!q.isEmpty()){
            int[] arr = q.poll();
            if(arr[0]==n-1 && arr[1]==m-1){
                return arr[2];
            }
            for(int d=0; d<4; d++){
                int ni = arr[0] + di[d];
                int nj = arr[1] + dj[d];
                if(ni<0 || ni>=n || nj<0 || nj>=m || map[ni][nj]==0 || v[ni][nj]) continue;
                q.offer(new int []{ni,nj,arr[2]+1});
                v[ni][nj] = true;
            }
        }
        return -1;
    }
}