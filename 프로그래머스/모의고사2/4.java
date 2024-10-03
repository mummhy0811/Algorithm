import java.util.*;

class Solution {
    static int[] moveX = {0,1, 0, -1};
    static int[] moveY = {1, 0, -1, 0};
    static int[] move2X = {0,2, 0, -2};
    static int[] move2Y = {2, 0, -2, 0};

    public int solution(int n, int m, int[][] hole) {

        boolean[][] map = new boolean[m][n];
        boolean[][][] visit = new boolean[m][n][2];

        for(int i=0;i<hole.length;i++){
            map[hole[i][1]-1][hole[i][0]-1]=true;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0}); // x, y, depth, jump

        while(!queue.isEmpty()){
            int now[] = queue.poll();
            int x=now[0], y=now[1], depth=now[2], jump=now[3];

            if(x==n-1 && y==m-1){ 
                return depth;
            }

            for(int i=0;i<4;i++){
                int nx = x+ moveX[i];
                int ny = y+ moveY[i];
                if(nx<0 || ny<0 || nx>=n || ny>=m || visit[ny][nx][jump]) continue;

                if(!map[ny][nx]){
                    queue.add(new int[]{nx, ny, depth+1,jump});
                    visit[ny][nx][jump]=true;
                }
            }

            if(jump==0){
                for(int i=0;i<4;i++){
                    int nx = x+ move2X[i];
                    int ny = y+ move2Y[i];
                    if(nx<0 || ny<0 || nx>=n || ny>=m || visit[ny][nx][jump+1]) continue;

                    if(!map[ny][nx]){
                        queue.add(new int[]{nx, ny, depth+1,jump+1});
                        visit[ny][nx][jump+1]=true;
                    }

                }
            }
        }
        return -1;
    }
}