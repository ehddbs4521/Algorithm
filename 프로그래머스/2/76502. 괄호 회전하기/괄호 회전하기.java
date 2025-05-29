import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int rotateCount=s.length();
        
        for(int i=0;i<rotateCount;i++){
            String newS=rotateString(i,s);
            if(isPerfect(newS)){
                answer++;
            }
        }
        return answer;
    }
    
    String rotateString(int i, String s){
        return s.substring(i) + s.substring(0, i);
    }
    
boolean isPerfect(String s){
        Deque<Character> deque = new ArrayDeque<>();
        
        for(char c: s.toCharArray()){
            if(c=='['|| c=='('|| c=='{'){
                deque.add(c);
            }
            
            if(deque.isEmpty()){
                return false;
            }
            
            else if(!deque.isEmpty()){
                if(c==']' && deque.peekLast()=='['){
                    deque.pollLast();
                }
                else if(c==')' && deque.peekLast()=='('){
                    deque.pollLast();
                }
                if(c=='}' && deque.peekLast()=='{'){
                    deque.pollLast();
                }
            }
        }
        
        if(deque.isEmpty()){
            return true;
        }
        return false;
    }    
}