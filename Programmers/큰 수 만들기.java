class Solution {
    public String solution(String number, int k) {
        String answer = "";

        int max = 0; // 뽑는 숫자 중 가장 큰 수
        int num = 0; // 뽑는 숫자
        int cnt = 0; // 뽑는 숫자 위치
        int L = number.length(); // 남은 number의 길이
        while(k>0){
            max = 0;
            L = number.length();

            if(L==k){
                number = "";
                break;
            }

            for(int i=0; i<=k; i++){
                num = number.charAt(i) - '0';
                if(max<num) {
                    max = num;
                    cnt = i;
                }
            }
            answer += Character.toString(number.charAt(cnt));
            number = number.substring(cnt+1,L);
            k -= cnt;
        }

        answer += number;


        return answer;
    }
}