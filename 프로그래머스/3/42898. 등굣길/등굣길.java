import java.util.*;

class Solution {
    
    static int[] mx = {1, 0};
    static int[] my = {0, 1};
    
    static int[][] dis;
    static int m, n, answer = 0;
    
    public int solution(int _m, int _n, int[][] puddles) {
        m=_m; n=_n;
        dis = new int[n+1][m+1];
        
        for(int i=0;i<puddles.length;i++){
            int mm = puddles[i][0];
            int nn = puddles[i][1];
            dis[nn][mm] = -1;
        }

        dis[1][1] = 1;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(dis[i][j]==-1 || (i==1 && j==1)) continue;

                if(dis[i-1][j] == -1) 
                    dis[i][j]=dis[i][j-1];
                else if(dis[i][j-1] == -1)
                    dis[i][j]=dis[i-1][j];
                else 
                    dis[i][j] = (dis[i][j-1]+dis[i-1][j])%1000000007;
            }
        }
        return dis[n][m];
    }

}