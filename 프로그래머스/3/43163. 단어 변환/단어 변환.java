import java.util.*;

class Word{
    String w;
    int c;
    
    Word(String w, int c){
        this.w=w;
        this.c=c;
    }
}

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        
        return bfs(begin, target, words);
    }
    
    int bfs(String begin, String target, String[] words){
        Queue<Word> que=new LinkedList<>();
        que.add(new Word(begin,0));
        boolean[] visited=new boolean[words.length];
        
        while(!que.isEmpty()){
            Word word=que.poll();
            if(word.w.equals(target)){
                return word.c;
            }
            for(int i=0;i<words.length;i++){
                if(diffOne(word.w,words[i]) && !visited[i]){
                    que.add(new Word(words[i],word.c+1));
                    visited[i]=true;
                }
            }
        }
        return 0;
    }
    
    boolean diffOne(String v1, String v2){
        
        int total=0;
        
        for(int i=0;i<v1.length();i++){
            if(v1.charAt(i)!=v2.charAt(i)){
                total++;
            }
        }
        
        if(total==1){
            return true;
        }
        return false;
    }
}