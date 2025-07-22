import java.util.*;
class Solution {
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};
    public int solution(String[] maps) {
        int answer = 0;
        int sx=0;
        int sy=0;
        int lx=0;
        int ly=0;
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(maps[i].charAt(j)=='S'){
                    sx=i;
                    sy=j;
                }else if(maps[i].charAt(j)=='L'){
                    lx=i;
                    ly=j;
                }
            }
        }
        int ld=bfs(sx,sy,'L',maps);
        if(ld==-1){
            return -1;
        }
        int ed=bfs(lx,ly,'E',maps);
        if(ed==-1){
            return -1;
        }
        return ld+ed;
    }
    int bfs(int x,int y,char dest,String[] maps){
        Queue<int[]> que=new LinkedList<>();
        boolean[][] visited=new boolean [maps.length][maps[0].length()];
        que.add(new int[]{x,y,0});
        visited[x][y] = true;
        while(!que.isEmpty()){
            int[] current=que.poll();
            int now_x=current[0];
            int now_y=current[1];
            int now_distance=current[2];
            if(maps[now_x].charAt(now_y)==dest){
                return now_distance;
            }
            for(int i=0;i<4;i++){
                int new_x=now_x+dx[i];
                int new_y=now_y+dy[i];
                if(new_x>=0&&new_x<maps.length && new_y>=0&&new_y<maps[0].length()){
                    if(!visited[new_x][new_y]&&maps[new_x].charAt(new_y)!='X'){
                        que.add(new int[]{new_x, new_y, now_distance+1});
                        visited[new_x][new_y]=true;
                    }
                }
            }
        }
        return -1; 
    }
}