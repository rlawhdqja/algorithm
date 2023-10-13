class Solution {
    static int MAX = Integer.MIN_VALUE+1;
    public int solution(int k, int[][] dungeons) {
        // int answer = -1;
        int L = dungeons.length;
        boolean[] v = new boolean[L];
        dfs(L,k,dungeons,v);
        return MAX;
    }

    static private void dfs(int L, int k, int[][] dungeons, boolean[] v){
        int cnt = 0;
        for(int i=0; i<L; i++){
            if(v[i]) cnt++;
        }
        MAX = Math.max(MAX, cnt);

        for(int i=0; i<L; i++){
            if(!v[i]) {
                if(dungeons[i][0] <= k) {
                    v[i] = true;
                    k -= dungeons[i][1];
                    dfs(L ,k, dungeons, v);
                    k += dungeons[i][1];
                    v[i] = false;
                }
            }
        }
    }
}