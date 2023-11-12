import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        for(int i=0; i<works.length; i++){
            pq.offer(works[i]);        }
        for(int i=0; i<n; i++){
            pq.offer(pq.poll()-1);
        }
        int tmp = 0;
        while(!pq.isEmpty()){
            tmp = pq.poll();
            if(tmp>0) answer += (tmp*tmp);
        }
        return answer;
    }
}