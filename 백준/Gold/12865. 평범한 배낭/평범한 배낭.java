import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][2];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }
        bw.write(run(N, K, arr)+"");
        bw.flush();
        bw.close();
    }

    //-------------------------------------------

    public static long run(int N, int K, int[][] arr){

        int[][] dp = new int[N+1][K+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=K;j++){

                if(arr[i][0]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-arr[i][0]] + arr[i][1]);
                }
            }
        }

        return dp[N][K];
    }
}