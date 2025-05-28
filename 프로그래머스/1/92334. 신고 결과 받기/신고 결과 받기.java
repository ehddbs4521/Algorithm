import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String,Integer> complaintCount= new HashMap<>();
        Map<String,Set<String>> complainted= new HashMap<>();
        
        for(String id: id_list){
            complaintCount.put(id,0);
            complainted.put(id,new HashSet<>());
        }
        
        for(String reports: report){
            String[] people=reports.split(" ");
            complainted.get(people[1]).add(people[0]);
        }
        
        for(Map.Entry<String,Set<String>> entrySet: complainted.entrySet()){
            String key=entrySet.getKey();
            
            if(entrySet.getValue().size()>=k){
                for(String name: entrySet.getValue()){
                    int cnt=complaintCount.get(name);
                    complaintCount.put(name,cnt+1);
                }
            }
        }
        
        for(int i=0;i<id_list.length;i++){
            answer[i]=complaintCount.get(id_list[i]);
        }
        
        return answer;
    }
}