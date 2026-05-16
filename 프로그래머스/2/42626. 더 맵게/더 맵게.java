import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Long> queue = new PriorityQueue<>();
        
        for(int i=0;i<scoville.length;i++) queue.add(Long.valueOf(scoville[i]));
        
        if(queue.peek()>=K) return 0;
        
        while(queue.size()>1){
            
            if(queue.peek()>=K) return answer;
            
            answer++;
            queue.add(queue.poll()+(queue.poll()*2));
            
        }
        
        if(queue.peek()<K) return -1;
        return answer;

    }
}