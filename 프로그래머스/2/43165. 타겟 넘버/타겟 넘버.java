class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        backtrack(numbers, target, 0, 0);
        return answer;
    }
    
    void backtrack(int[] numbers, int target, int now, int total){
        if(now==numbers.length){
            if(total==target){
                answer++;
            }
            return;
        }
        
        backtrack(numbers,target,now+1,total+numbers[now]);
        backtrack(numbers,target,now+1,total-numbers[now]);
    }
}