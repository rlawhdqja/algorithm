class Solution {

    static int answer;

    public int solution(int[] numbers, int target) {
        answer = 0;
        targetNumber(0,0,numbers,target);

        return answer;
    }

    static private void targetNumber(int index, int sum, int[] nums, int t){
        if(index == nums.length) {
            if(sum==t) answer++;
            return;
        }
        targetNumber(index+1, sum+nums[index], nums,t);
        targetNumber(index+1, sum-nums[index], nums,t);

    }
}