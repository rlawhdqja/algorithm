class Solution {

    static int di[] = {0,0,1,-1};  // 동서남북
    static int dj[] = {1,-1,0,0};

    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};

        int H = park.length;
        int W = park[0].length();

        String [] route = new String[2];

        int [] location = new int [2];

        char[][] map = new char[H][W];

        String str = "";
        for(int i=0; i<H; i++){
            str = park[i];
            for(int j=0; j<W; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'S'){
                    location[0] = i;
                    location[1] = j;
                }
            }
        }

        int ni=location[0], nj=location[1];
        int c = 0;


        label : for(int t=0; t<routes.length; t++){
            route = routes[t].split(" ");
            c = Integer.parseInt(route[1]);
            ni=location[0];
            nj=location[1];

            if(route[0].equals("E")) {
                while(c>0){
                    ni += di[0];
                    nj += dj[0];
                    if(ni<0 || ni>=H || nj<0 || nj>=W || map[ni][nj] == 'X') continue label;
                    c--;
                }
                location[0] = ni;
                location[1] = nj;
            } else if(route[0].equals("W")) {
                while(c>0){
                    ni += di[1];
                    nj += dj[1];
                    if(ni<0 || ni>=H || nj<0 || nj>=W || map[ni][nj] == 'X') continue label;
                    c--;
                }
                location[0] = ni;
                location[1] = nj;
            } else if(route[0].equals("S")) {
                while(c>0){
                    ni += di[2];
                    nj += dj[2];
                    if(ni<0 || ni>=H || nj<0 || nj>=W || map[ni][nj] == 'X') continue label;
                    c--;
                }
                location[0] = ni;
                location[1] = nj;
            } else if(route[0].equals("N")) {
                while(c>0){
                    ni += di[3];
                    nj += dj[3];
                    if(ni<0 || ni>=H || nj<0 || nj>=W || map[ni][nj] == 'X') continue label;
                    c--;
                }
                location[0] = ni;
                location[1] = nj;
            }
        }
        answer = location;

        return answer;
    }
}