import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        List<List<Integer>> graph=new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] num:wires){
            graph.get(num[0]).add(num[1]);
            graph.get(num[1]).add(num[0]);
        }
        int min=Integer.MAX_VALUE;
        for(int[] num:wires){
            graph.get(num[0]).remove(Integer.valueOf(num[1]));
            graph.get(num[1]).remove(Integer.valueOf(num[0]));
            int result=bfs(n,num[0],graph);
            min=Math.min(min,Math.abs(n-2*result));
            graph.get(num[0]).add(Integer.valueOf(num[1]));
            graph.get(num[1]).add(Integer.valueOf(num[0]));
        }
        return min;
    }
    
    int bfs(int n,int v, List<List<Integer>> graph){
        boolean[] visited=new boolean[n+1];
        Queue<Integer> que=new LinkedList<>();
        que.add(v);
        visited[v]=true;
        int total=1;
        while(!que.isEmpty()){
            int num=que.poll();
            for(int x:graph.get(num)){
                if(!visited[x]){
                    que.add(x);
                    visited[x]=true;
                    total++;
                }
            }
        }
        return total;
    }
}