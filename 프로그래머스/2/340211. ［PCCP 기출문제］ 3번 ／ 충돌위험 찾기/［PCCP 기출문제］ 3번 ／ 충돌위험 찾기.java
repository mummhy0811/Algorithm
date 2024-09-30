import java.util.*;

class Solution {
    static int[][][] visit;
    static int answer = 0;
    static Deque<int[]>[] queue ; 
    
    public int solution(int[][] points, int[][] routes) {
        visit= new int[101][101][20000];
        queue = new LinkedList[routes.length];
        
        for(int i=0;i<routes.length;i++){
            queue[i] = new LinkedList<>();
            for(int j=0;j<routes[i].length-1;j++){
                queue[i].pollLast();
                int now = routes[i][j];
                int next = routes[i][j+1];
                find(i, points[now-1][0], points[now-1][1], points[next-1][0], points[next-1][1]);
            }
        }
        int max=0;
         for(int i=0;i<routes.length;i++){
             int idx=0;
            while(!queue[i].isEmpty()){
                int[] arr = queue[i].poll();
                visit[arr[0]][arr[1]][idx++]++;
            }
             max=Math.max(max, idx);
        }       
        for(int i=0;i<=100;i++){
            for(int j=0;j<=100;j++){
                for(int k=0;k<=max;k++){
                    if(visit[i][j][k]>1){
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
    
    private void find(int i, int sR, int sC, int eR, int eC){
        queue[i].add(new int[]{sR, sC});
        int depth=0;
        if(sR<eR){//아래로 이동
            for(int j=sR+1;j<=eR;j++){
                queue[i].add(new int[]{j, sC});
            }
        }else if(sR>eR){
            for(int j=sR-1;j>=eR;j--){
                queue[i].add(new int[]{j, sC});
            }
        }
        if(sC<eC){//오른쪽으로 이동
            for(int j=sC+1;j<=eC;j++){
                queue[i].add(new int[]{eR, j});
            }
        }else if(sC>eC){
            for(int j=sC-1;j>=eC;j--){
                queue[i].add(new int[]{eR, j});
            }
        }
    }
}