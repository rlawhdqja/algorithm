package a230922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1992_쿼드트리 {
    static StringBuilder sb;
    static char[][] carr;
    static boolean flag;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int N  = Integer.parseInt(st.nextToken());

        carr = new char[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            carr[i] = st.nextToken().toCharArray();
        }

        quadtree(N,0,0);
        System.out.println(sb.toString());
        br.close();
    }

    //왼쪽 위
    // i : 0 ~ 2/N , j : 0 ~ N/2
    //오른쪽 위
    // i : 0 ~ 2/N , j : N/2 ~ N
    //왼쪽 아래
    // i : 2/N ~ N , j : 0~N/2
    //오른쪽 아래
    // i : 2/N ~ N , j : N/2 ~ N
    static private void quadtree(int N, int x, int y) {
        char tmp = carr[x][y];
        flag = true;
        l:for(int i=x; i<x+N; i++) {
            for(int j=y; j<y+N; j++){
                if(tmp != carr[i][j]){
                    flag = false;
                    break l;
                }
            }
        }

        if(flag) {
            sb.append(tmp);
            return;
        }

        sb.append("(");
        quadtree(N/2, x,y); // 왼 위
        quadtree(N/2, x,y+N/2); // 오 위
        quadtree(N/2, x+N/2,y); // 왼 아
        quadtree(N/2, x+N/2,y+N/2); // 오 아
        sb.append(")");
    }
}
