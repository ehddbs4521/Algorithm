import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }
    
    int bfs(String begin, String target, String[] words){
        Queue<Word> que=new LinkedList<>();
        que.add(new Word(begin,0));
        boolean[] visited=new boolean[words.length];

        while(!que.isEmpty()){
            Word now=que.poll();
            String now_word=now.word;
            int now_cnt=now.cnt;
            
            if(now_word.equals(target)){
                return now_cnt;
            }
            
            for(int i=0;i<words.length;i++){
                if(!visited[i]&&diff(now_word,words[i])){
                    visited[i]=true;
                    que.add(new Word(words[i],now_cnt+1));
                }
            }
        }
        return 0;
    }
    
    boolean diff(String word, String target){
        int cnt=0;
        for(int i=0;i<target.length();i++){
            if(word.charAt(i)!=target.charAt(i)){
                cnt++;
            }
        }
        if(cnt==1){
            return true;
        }
        return false;
    }
    
    class Word{
        String word;
        int cnt;
        
        Word(String word, int cnt){
            this.word=word;
            this.cnt=cnt;
        }
    }
}