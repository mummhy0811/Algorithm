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
            else return this.num-t.num;
        }
    }
    
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        
        PriorityQueue<Task> queue = new PriorityQueue<>();
        int sum = 0, now = 0, end = 0, idx = 0, i=0;
        
        Task t = new Task(idx,0, 0);
        
        while(!queue.isEmpty() ||i<jobs.length ){
            
            if(queue.isEmpty()){
                now = jobs[i][0];
                for(int time=now;time<=now + t.duration && i<jobs.length;i++){
                    if(jobs[i][0]!=time) break;
                    queue.add(new Task(idx++, jobs[i][0], jobs[i][1]));
                }  
            }
        
            t = queue.poll();
            end = now + t.duration;;
            for(int time=now;time<=end && i<jobs.length;time++, i++){
                if(end<jobs[i][0]) break;
                queue.add(new Task(idx++, jobs[i][0], jobs[i][1]));
            }  
            now += t.duration;
            sum += (now - t.requestTime);          
             
        }
        return sum/jobs.length;
    }
}