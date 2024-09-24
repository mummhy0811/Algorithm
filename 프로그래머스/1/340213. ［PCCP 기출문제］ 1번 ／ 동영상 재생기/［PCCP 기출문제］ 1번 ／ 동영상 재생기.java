import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands){
        int video_len_sec = calcToSec(video_len);
        int op_start_sec = calcToSec(op_start);
        int op_end_sec = calcToSec(op_end);
        int now = calcToSec(pos);
        
        if(now>=op_start_sec && now<=op_end_sec) now=op_end_sec;
        
        for(int i=0;i<commands.length;i++){
            if(commands[i].equals("prev")){
                if(now<10) now=0;
                else now-=10;
            }else{
                if(video_len_sec-now<10) now=video_len_sec;
                else now+=10;
            }
            
            if(now>=op_start_sec && now<=op_end_sec) now=op_end_sec;
        }
        
        String h = now/60<10 ? "0"+now/60 : now/60+"";
        String m = now%60<10 ? "0"+now%60 : now%60+"";
        return h+":"+m;
    }

    
    public static int calcToSec(String s){
        StringTokenizer st = new StringTokenizer(s, ":");
        return Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
    }
}