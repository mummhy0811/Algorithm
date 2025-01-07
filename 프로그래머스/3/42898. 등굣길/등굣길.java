import java.util.*;

class Solution {
    
    public int solution(int m, int n, int[][] puddles) {

        int[][] dis = new int[n+1][m+1];
        
        for(int i=0;i<puddles.length;i++){
            dis[puddles[i][1]][puddles[i][0]] = -1;
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