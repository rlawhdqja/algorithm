import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        int L = clothes.length;
        HashMap<String, Integer> hm = new HashMap<>();

        // hashMap<"의상의 종류", "의상의 갯수">
        for(int i=0; i<L; i++){
            if(hm.containsKey(clothes[i][1])){
                hm.put(clothes[i][1], hm.get(clothes[i][1])+1);
            } else {
                hm.put(clothes[i][1], 1);
            }
        }
        // 의상의 종류와 갯수별로 나올 수 있는 경우의 수
        for(String s : hm.keySet()){
            answer *= hm.get(s)+1;
        }

        return answer-1;
    }
}