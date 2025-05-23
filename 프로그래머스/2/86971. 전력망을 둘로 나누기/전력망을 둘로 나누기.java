import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        for(int[] wire : wires) {
            int start = wire[0];
            int end = wire[1];
            
            graph.get(start).remove(Integer.valueOf(end));
            graph.get(end).remove(Integer.valueOf(start));
            
            int componentSize = bfs(start, graph, n);
            int otherComponentSize = n - componentSize;
            
            int diff = Math.abs(componentSize - otherComponentSize);
            min = Math.min(min, diff);
            
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        
        return min;
    }
    
    private int bfs(int start, List<List<Integer>> graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        
        queue.add(start);
        visited[start] = true;
        int count = 1;
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            for(int neighbor : graph.get(current)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    count++;
                }
            }
        }
        
        return count;
    }
}