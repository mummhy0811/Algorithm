import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long l = 0, r= n * 1000000000L;
        long mid=0;
        
        while(l<r){
            mid = (l+r)/2;
            if(canCheck(times, mid, n)){
                r=mid;
            }else{
                l=mid+1;
            }
            
        }
        
        return r;
    }
    
    public static boolean canCheck(int[] times, long time, int n){
        long cnt=0;
        for(int i=0;i<times.length;i++){
            cnt+=time/times[i];
        }
        return cnt>=n;
    }
}


// 우선 순위 큐 - 시간 초과
// class Solution {
//     class Desk implements Comparable<Desk>{
//         int start;
//         int end;
//         int time;
//         public Desk(int s, int e, int t){
//             this.start = s;
//             this.end = e;
//             this.time = t;
//         }
        
//         @Override
//         public int compareTo(Desk d){
//             if(this.end == d.end){
//                 return this.time-d.time;
//             }
//             return this.end - d.end;
//         }
//     }
//     public long solution(int n, int[] times) {
//         long answer = 0;
//         Queue<Desk> queue = new PriorityQueue<>();
//         int now=0;
//         for(int i=0;i<times.length;i++){
//             queue.add(new Desk(0, times[i],times[i]));
//         }
        
//         while(n-->0){
//             Desk d = queue.poll();
//             answer+=(d.end - now);
//             now=d.end;
//             queue.add(new Desk(now, now+d.time, d.time));
//         }
        
//         return answer;
//     }
    
// }