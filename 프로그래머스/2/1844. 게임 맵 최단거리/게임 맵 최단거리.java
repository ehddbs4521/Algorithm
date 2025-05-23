import java.util.*;

class Solution {
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        que.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while (!que.isEmpty()) {
            int[] now = que.poll();
            int now_x = now[0];
            int now_y = now[1];
            int steps = now[2];
            
            if (now_x == n - 1 && now_y == m - 1) {
                return steps;
            }
            
            for (int i = 0; i < 4; i++) {
                int new_x = now_x + dx[i];
                int new_y = now_y + dy[i];
                
                if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < m) {
                    if (maps[new_x][new_y] == 1 && !visited[new_x][new_y]) {
                        visited[new_x][new_y] = true;
                        que.add(new int[]{new_x, new_y, steps + 1});
                    }
                }
            }
        }
        
        return -1;
    }
}