import java.io.*;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] price =new int[n][3];
        int[][] dp =new int[n][3];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                price[i][j]=Integer.parseInt(st.nextToken());
                dp[i][j]=price[i][j];
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            for(int j=0;j<3;j++){
                if(j==0){
                    dp[i][j]=Math.min(dp[i-1][1], dp[i-1][2])+price[i][j]; continue;
                }
                if(j==1){
                    dp[i][j]=Math.min(dp[i-1][0], dp[i-1][2])+price[i][j]; continue;
                }
                dp[i][j]=Math.min(dp[i-1][0], dp[i-1][1])+price[i][j];
            }
        }
        for(int i=0;i<3;i++) min=Math.min(min, dp[n-1][i]);

        bw.write(min+"");
        bw.flush();
        bw.close();
    }
}