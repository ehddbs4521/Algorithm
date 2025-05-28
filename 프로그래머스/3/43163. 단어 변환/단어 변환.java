import java.util.*;

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        
        return bfs(begin, target, words);
    }
    
    int bfs(String begin, String target, String[] words){
        Queue<Word> que=new LinkedList<>();
        boolean visited[]=new boolean[words.length];
        que.add(new Word(begin,0));
        
        while(!que.isEmpty()){
            Word w=que.poll();
            String now_word=w.word;
            int now_cnt=w.cnt;
            
            if(target.equals(now_word)){
                return now_cnt;
            }
            
            for(int i=0;i<words.length;i++){
                if(!visited[i] && diff(words[i],now_word)){
                    que.add(new Word(words[i],now_cnt+1));
                    visited[i]=true;
                }
            }
        }
        return 0;
    }
    
    boolean diff(String target,String word){
        
        int diff_cnt=0;
        
        for(int i=0;i<target.length();i++){
            if(target.charAt(i)!=word.charAt(i)){
                diff_cnt++;
            }
        }
        
        if(diff_cnt!=1){
            return false;
        }
        return true;
    }
    
}

class Word{
    String word;
    int cnt;
    
    Word(String word, int cnt){
        this.word=word;
        this.cnt=cnt;
    }
}