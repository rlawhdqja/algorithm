import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int L = prices.length;
        int[] answer = new int [L];

        Stack<int[]> s = new Stack<>();
        s.push(new int[]{prices[0],0}); // {가격, 위치} 첫번째 값 넣어주기

        for(int i=1; i<L; i++){
            // !s.isEmpty()를 포함하지 않았을때 런타임에러가 발생했다.
            // 이유 : 비어있는 스택의 다음 다음 값에 접근해서
            // 만약 스택이 비어있지 않으면서 맨 위의 값이 현재 price 보다 크다면
            // 비교하는 스택의 요소는 가격이 떨어졌기 때문에 알맞은 위치에 오른 시간 만큼 넣어준다.
            while(!s.isEmpty() && s.peek()[0]>prices[i]){
                int[] tmp = s.pop();
                answer[tmp[1]] = i-tmp[1];
            }
            // 현재 비교했던 값 스택에 추가
            s.push(new int[]{prices[i],i});
        }
        // 스택안에 남아 있는 요소들은 끝까지 값이 오른 요소들
        while(!s.isEmpty()){
            int[] tmp = s.pop();
            answer[tmp[1]] = L-tmp[1]-1;
        }

        return answer;
    }
}