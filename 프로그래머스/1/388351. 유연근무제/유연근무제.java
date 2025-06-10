class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < schedules.length; i++){
            boolean pass = true;
            
            // 출근 희망 시각 + 10분 계산
            int deadline = addMinutes(schedules[i], 10);
            
            for(int j = 0; j < timelogs[i].length; j++){
                // 현재 날짜가 토요일 또는 일요일인지 확인
                int currentDay = (startday + j - 1) % 7 + 1; // 1~7로 정규화
                
                if(currentDay == 6 || currentDay == 7){ // 토요일(6) 또는 일요일(7)
                    continue;
                }
                
                // 지각 여부 확인
                if(timelogs[i][j] > deadline){
                    pass = false;
                    break;
                }
            }
            
            if(pass){
                answer++;
            }
        }
        
        return answer;
    }
    
    // 시각에 분을 더하는 메서드
    private int addMinutes(int time, int minutes) {
        int hour = time / 100;
        int minute = time % 100;
        
        minute += minutes;
        
        if(minute >= 60) {
            hour += minute / 60;
            minute = minute % 60;
        }
        
        return hour * 100 + minute;
    }
}