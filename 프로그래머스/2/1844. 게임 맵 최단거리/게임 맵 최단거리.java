import java.util.*;

class Solution {
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        Queue<int[]> que=new LinkedList<>();
        que.add(new int[]{0,0,1});
        
        boolean[][] visited=new boolean[maps.length][maps[0].length];
        visited[0][0]=true;
        
        while(!que.isEmpty()){
            int[] now=que.poll();
            int nowX=now[0];
            int nowY=now[1];
            int nowCount=now[2];
            
            if(nowX==maps.length-1 && nowY==maps[0].length-1){
                return nowCount;
            }
            for(int i=0;i<4;i++){
                int newX=nowX+dx[i];
                int newY=nowY+dy[i];
                
                if(newX>=0 && newX<maps.length && newY>=0 && newY<maps[0].length){
                    if(!visited[newX][newY] && maps[newX][newY]==1){
                        que.add(new int[]{newX,newY,nowCount+1});
                        visited[newX][newY]=true;
                    }
                }
            }
        }
        return -1;
    }
    
}