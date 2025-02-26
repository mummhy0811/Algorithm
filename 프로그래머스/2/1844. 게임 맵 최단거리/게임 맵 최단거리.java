import java.util.*;

class Solution {
    static int[] mx = {0, 1, 0, -1};
    static int[] my = {1, 0, -1 ,0};
    static boolean[][] visit;
    
    public int solution(int[][] maps) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        int n = maps.length;
        int m = maps[0].length;
        visit  = new boolean[n][m];
        visit[0][0] = true;

        while(!queue.isEmpty()){
            
            int[] pos = queue.poll();
            int r = pos[0];
            int c = pos[1];
            int pass = pos[2];
            
            for(int i=0;i<4;i++){
                int nr = r+mx[i];
                int nc = c+my[i];
                if(nr>=n || nc>=m || nr<0 || nc<0 || maps[nr][nc]==0 || visit[nr][nc]) continue;
                
                if(nr==n-1 && nc == m-1) return pass+1;
                visit[nr][nc] = true;
                queue.add(new int[]{nr, nc, pass+1});
            }
        }
        return -1;
    }
}