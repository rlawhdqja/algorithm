class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;

        int T = attacks.length;

        int time = attacks[0][0]+1;
        answer -= attacks[0][1];


        for(int i=1; i<T; i++){

            answer = band(bandage, answer, attacks[i][0]-time, health);
            answer -= attacks[i][1];
            time = attacks[i][0]+1;
            if(answer <= 0) {
                answer = -1;
                break;
            }
        }



        return answer;
    }

    static private int band(int[] bandage, int health, int time, int max){
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];

        if(time>=t) health += (time/t * y);


        health+=(time*x);

        if(health > max) health = max;

        return health;
    }
}