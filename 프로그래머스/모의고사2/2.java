import java.util.*;

class Solution {
    public int solution(int[] ability, int number) {
        int answer=0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<ability.length;i++){
            answer+=ability[i];
            queue.add(ability[i]);
        }
        for(int i=0;i<number;i++){
            int sum = queue.poll()+queue.poll();
            answer += sum;
            queue.add(sum);
            queue.add(sum);
        }
        return answer;
    }
}