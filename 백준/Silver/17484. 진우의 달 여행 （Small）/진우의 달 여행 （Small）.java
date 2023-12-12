import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][]arr = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int[][][]dp = new int[n][m][3];
        for(int i=0;i<m;i++) {
            dp[0][i][0]=arr[0][i];
            dp[0][i][1]=arr[0][i];
            dp[0][i][2]=arr[0][i];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(j==0){
                    dp[i][j][0] = 1000;
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2])+arr[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][0])+arr[i][j];
                }else if(j==m-1){
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2])+arr[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2])+arr[i][j];
                    dp[i][j][2] = 1000;
                }else{
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2])+arr[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2])+arr[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][0])+arr[i][j];
                }
            }
        }
        int[] tmp=new int[m];
        for(int i=0;i<m;i++){

            int min=Integer.MAX_VALUE;
            for(int j=0;j<3;j++){
                min = Math.min(min, dp[n-1][i][j]);
            }
            tmp[i]=min;
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            ans = Math.min(ans, tmp[i]);
        }
        System.out.println(ans);
    }
}