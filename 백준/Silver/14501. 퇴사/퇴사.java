import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] T = new int[n+1];
        int[] P = new int[n+1];
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i]=Integer.parseInt(st.nextToken());
            P[i]=Integer.parseInt(st.nextToken());
            dp[i]=0;
        }
        dp[0]=0;
        int max=0;
        for(int i=1;i<=n;i++){
            if(i+T[i]>n+1) continue;
            for(int j=0;j<i;j++){
                if(j+T[j]<=i){
                    dp[i]=Math.max(dp[j]+P[i], dp[i]);
                }
            }
            max=Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}