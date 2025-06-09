class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int rx=Integer.MAX_VALUE;
        int ry=Integer.MAX_VALUE;
        int hx=0;
        int hy=0;
        for(int i=0;i<wallpaper.length;i++){
            for(int j=0;j<wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j)=='#'){
                    if(rx>i){
                        rx=i;
                    }
                    if(ry>j){
                        ry=j;
                    }
                    if(hx<i){
                        hx=i;
                    }
                    if(hy<j){
                        hy=j;
                    }
                }
            }
        }
        answer[0]=rx;
        answer[1]=ry;
        answer[2]=hx+1;
        answer[3]=hy+1;

        return answer;
    }
}