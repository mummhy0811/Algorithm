import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[][] dp=new long[n+1][10];
        dp[1]= new long[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}; 

        for(int i=2;i<=n;i++){
            for(int j=0;j<=9;j++){
                if(j==9) dp[i][j]=dp[i-1][j-1]%1000000000;
                else if(j==0) dp[i][j]=dp[i-1][j+1]%1000000000;
                else dp[i][j]=dp[i-1][j-1]%1000000000+dp[i-1][j+1]%1000000000;
            }
        }
        long ans=0;
        for(int i=1;i<=9;i++){
            ans+=dp[n][i]%1000000000;
        }
        bw.write(ans%1000000000+"");
        bw.flush();
        bw.close();
    }
}