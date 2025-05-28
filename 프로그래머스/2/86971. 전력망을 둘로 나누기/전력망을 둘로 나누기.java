import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            graph.get(v1).remove(Integer.valueOf(v2));
            graph.get(v2).remove(Integer.valueOf(v1));
            
            int first = bfs(graph, v1, n);
            int second = n - first;
            
            min = Math.min(min, Math.abs(first - second));
            
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        return min;
    }
    
    int bfs(List<List<Integer>> graph, int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> que = new LinkedList<>();
        
        que.add(start);
        visited[start] = true;  
        
        int count = 1;
        
        while(!que.isEmpty()) {
            int now = que.poll();
            
            for(int next : graph.get(now)) {
                if(!visited[next]) {
                    visited[next] = true;  
                    que.add(next);
                    count++;
                }
            }
        }
        
        return count;
    }
}