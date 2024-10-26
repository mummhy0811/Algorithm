import java.util.*;

class Solution {
    
    public long solution(int n, int[] works) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:works){
            queue.add(i);
        }

        while(n-->0 && !queue.isEmpty()){
            int now = queue.poll()-1;
            if(now>0) queue.add(now);
        }
        
        long min = 0;
        while(!queue.isEmpty()){
            min+=Math.pow(queue.poll(), 2);
        }
        
        return min;
    }
    
}