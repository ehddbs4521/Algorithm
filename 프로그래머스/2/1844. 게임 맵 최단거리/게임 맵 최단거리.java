import java.util.*;

class Solution {
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        int n=maps.length;
        int m=maps[0].length;
        
        Queue<int[]> que=new LinkedList<>();
        
        boolean[][] visited=new boolean[n][m];
        
        que.add(new int[]{0,0,1});
        visited[0][0]=true;
        
        while(!que.isEmpty()){
            int[] now=que.poll();
            int now_x=now[0];
            int now_y=now[1];
            int now_cnt=now[2];
            
            if(now_x==n-1 && now_y==m-1){
                return now_cnt;
            }
            
            for(int i=0;i<4;i++){
                int new_x=now_x+dx[i];
                int new_y=now_y+dy[i];
                
                if(new_x>=0 && new_x<n && new_y>=0 && new_y<m){
                    if(!visited[new_x][new_y] && maps[new_x][new_y]==1){
                        que.add(new int[]{new_x,new_y,now_cnt+1});
                        visited[new_x][new_y]=true;
                    }
                }
            }
        }
        
        return -1;
    }
    
}