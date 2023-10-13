import java.util.*;
class Solution {
    static boolean [] v;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        // 컴퓨터가 네트워크에 속했는지 확인
        v = new boolean[n];

        for(int i=0; i<n; i++){
            // 네트워크에 속하지 않았다면 bfs()를 통해 네트워크를 형성하고 갯수 추가.
            if(!v[i]) answer+=bfs(i,n,computers);
        }

        return answer;
    }

    static private int bfs(int x, int n, int[][] computers){
        Queue<Integer> q= new LinkedList<>();
        q.offer(x);
        v[x] = true;
        while(!q.isEmpty()){
            int i = q.poll();
            for(int d=0; d<n; d++){
                if(!v[d] && computers[i][d]==1){
                    v[d] = true;
                    q.offer(d);
                }
            }
        }
        return 1;
    }
}