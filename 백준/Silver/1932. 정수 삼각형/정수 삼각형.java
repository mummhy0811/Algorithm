import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr= new int[n][];
        int[][] dp= new int[n][];

        for(int i=0;i<n;i++){
            arr[i]=new int[i+1];
            dp[i]=new int[i+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j=0;
           while(st.hasMoreTokens()){
               arr[i][j]=Integer.parseInt(st.nextToken());
               dp[i][j]=0;
               j++;
           }
        }

        dp[0][0]=arr[0][0];
        int result=dp[0][0];
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    dp[i][j]=dp[i-1][j]+arr[i][j];
                }else if(j==i){
                    dp[i][j]=dp[i-1][j-1]+arr[i][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-1])+arr[i][j];
                }
                result=Math.max(result, dp[i][j]);
            }
        }
        bw.write(result+"");
        bw.flush();bw.close();
    }
}