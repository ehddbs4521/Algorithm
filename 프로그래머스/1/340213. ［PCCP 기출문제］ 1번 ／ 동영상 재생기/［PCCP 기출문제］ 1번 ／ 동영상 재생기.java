class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        String[] time = pos.split(":");
        int posMinute = Integer.parseInt(time[0]);
        int posSecond = Integer.parseInt(time[1]);
        
        time = op_start.split(":");
        int opStartMinute = Integer.parseInt(time[0]);
        int opStartSecond = Integer.parseInt(time[1]);
        
        time = op_end.split(":");
        int opEndMinute = Integer.parseInt(time[0]);
        int opEndSecond = Integer.parseInt(time[1]);
        
        time = video_len.split(":");
        int videoMinute = Integer.parseInt(time[0]);
        int videoSecond = Integer.parseInt(time[1]);
        
        if (posMinute * 60 + posSecond >= opStartMinute * 60 + opStartSecond &&
            posMinute * 60 + posSecond <= opEndMinute * 60 + opEndSecond) {
            posMinute = opEndMinute;
            posSecond = opEndSecond;
        }
        
        for (String command : commands) {
            if (command.equals("next")) {
                posSecond += 10;
                if (posSecond >= 60) {
                    posSecond -= 60;
                    posMinute += 1;
                }
                
                if (posMinute * 60 + posSecond > videoMinute * 60 + videoSecond) {
                    posMinute = videoMinute;
                    posSecond = videoSecond;
                }
                
                if (posMinute * 60 + posSecond >= opStartMinute * 60 + opStartSecond &&
                    posMinute * 60 + posSecond <= opEndMinute * 60 + opEndSecond) {
                    posMinute = opEndMinute;
                    posSecond = opEndSecond;
                }
                
            } else if (command.equals("prev")) {
                posSecond -= 10;
                if (posSecond < 0) {
                    posSecond += 60;
                    posMinute -= 1;
                }
                
                if (posMinute < 0) {
                    posMinute = 0;
                    posSecond = 0;
                }
                
                if (posMinute * 60 + posSecond >= opStartMinute * 60 + opStartSecond &&
                    posMinute * 60 + posSecond <= opEndMinute * 60 + opEndSecond) {
                    posMinute = opEndMinute;
                    posSecond = opEndSecond;
                }
            }
            
            answer = String.format("%02d:%02d", posMinute, posSecond);
            System.out.println(answer);
        }
        
        return answer;
    }
}