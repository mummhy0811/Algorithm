import java.util.*;
class Solution {
    static int[] distance;
    static boolean[][] map;
    
    public int solution(int n, int[][] edge) {
        map = new boolean[n+1][n+1];
        distance = new int[n+1];
        
        int edges = edge.length;
        for(int i=0;i<edges;i++){
            int a = edge[i][0];
            int b = edge[i][1];
            map[a][b] = true;
            map[b][a] = true;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int maxLen = 1;
        int cnt = 0;
        
        queue.add(1);
        distance[1] = 1;
        
         while(!queue.isEmpty()){
            int num = queue.poll();
            for(int i=1;i<=n;i++){

                if(distance[i]==0 && map[num][i]) {
                    queue.add(i);
                    
                    int next = distance[num]+1;
                    distance[i] = next;
                    if(maxLen<next){
                        maxLen = next;
                        cnt = 1;
                    }else if(maxLen == next){
                        cnt++;
                    }
                }
            }
        }
        
        return cnt;
    }
}