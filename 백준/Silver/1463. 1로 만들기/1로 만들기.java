import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[1]=0;

        for(int i=2;i<=n;i++){
            int cnt;
            if(i%6==0){
                cnt = Math.min(dp[i / 3], dp[i / 2]);
                cnt = Math.min(cnt,dp[i-1])+1;
            } else if(i%3==0){
                cnt = Math.min(dp[i / 3], dp[i-1])+1;
            }else if(i%2==0) {
                cnt=Math.min(dp[i / 2],dp[i-1])+1;
            }else{
                cnt = 1+dp[i-1];
            }
            dp[i]=cnt;
        }

        bw.write(dp[n]+"");
        bw.flush();
        bw.close();
    }
}