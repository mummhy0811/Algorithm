import java.util.*;

class Solution {
    static class Task implements Comparable<Task>{
        int num, requestTime, duration;
        
        public Task(int n, int r, int d){
            this.num = n; this.requestTime = r; this.duration = d;
        }
        
        @Override
        public int compareTo(Task t){
            if(this.duration!=t.duration) return this.duration-t.duration;
            else if(this.requestTime!=t.requestTime) return this.requestTime-t.requestTime;
            return this.num-t.num;
        }
    }
    
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        
        PriorityQueue<Task> queue = new PriorityQueue<>();
        int totalTime = 0, currentTime = 0, idx = 0, taskCount = jobs.length;
        
        while(!queue.isEmpty() ||idx< taskCount){
            
            //지금 할 수 있는 작업 큐에 추가
            while(idx<taskCount && jobs[idx][0]<=currentTime){
                queue.add(new Task(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            //컨트롤러가 쉬는 경우 다음 요청 시간으로 이동
            if(queue.isEmpty()){
                currentTime = jobs[idx][0];
                continue;
            }
        
            //우선순위 작업 수행
            Task t = queue.poll();
            currentTime+=t.duration;
            totalTime +=(currentTime - t.requestTime);        
             
        }
        return totalTime/jobs.length;
    }
}