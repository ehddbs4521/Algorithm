class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        backtrack(numbers, target, 0, 0);
        return answer;
    }
    
    void backtrack(int[] numbers, int target, int index, int currentSum) {
        if (index == numbers.length) {
            if (currentSum == target) {
                answer++;
            }
            return;
        }
        
        backtrack(numbers, target, index + 1, currentSum + numbers[index]);
        backtrack(numbers, target, index + 1, currentSum - numbers[index]);
    }
}