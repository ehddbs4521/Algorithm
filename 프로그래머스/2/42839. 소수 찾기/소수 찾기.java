import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        String[] num = new String[numbers.length()];
        
        for(int i = 0; i < numbers.length(); i++){
            num[i] = String.valueOf(numbers.charAt(i)); 
        }
        
        boolean[] visited = new boolean[num.length];
        Set<Integer> permutations = new HashSet<>(); 
        backtrack(num, new ArrayList<>(), permutations, visited); 
        
        answer = calculatePrimeCount(permutations);
        
        return answer;
    }
    
    int calculatePrimeCount(Set<Integer> permutations){
        int count = 0;
        
        for(int num : permutations) {
            if(num <= 1) continue;
            if(num == 2) {
                count++;
                continue;
            }
            if(num % 2 == 0) continue;
            
            boolean isPrime = true;
            for(int i = 3; i * i <= num; i += 2) {
                if(num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            if(isPrime) count++;
        }
        
        return count;
    }
    
    void backtrack(String[] num, List<String> cur, Set<Integer> permutations, boolean[] visited){
        if(cur.size() != 0 && cur.size() <= num.length){
            String numberStr = String.join("", cur); 
            int numValue = Integer.parseInt(numberStr);
            permutations.add(numValue);
        }
        
        for(int i = 0; i < num.length; i++){
            if(!visited[i]){
                visited[i] = true;
                cur.add(num[i]);
                backtrack(num, cur, permutations, visited);
                visited[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
}