import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        for(int i=1;i<=s.length();i++){
            answer=Math.min(answer,split(s,i));
        }
        return answer;
    }
    
    int split(String s, int cnt){
        List<String> parts = new ArrayList<>();
        
        for(int i=0;i<s.length();i+=cnt){
            String now;
            if(i+cnt > s.length()){
                now = s.substring(i);
            } else {
                now = s.substring(i,i+cnt);
            }
            parts.add(now);
        }
        
        String zip="";
        
        for(int i=0; i<parts.size(); ){
            String current = parts.get(i);
            int count = 1;
            
            for(int j=i+1; j<parts.size() && parts.get(j).equals(current); j++){
                count++;
            }
            
            if(count==1){
                zip+=current;
            }else{
                zip+=count+current;
            }
            
            i += count;
        }
        
        return zip.length();
    }
}