import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int max=1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
            max=Math.max(max, dp[i]);
        }
        bw.write(max+"");
        bw.flush();
        bw.close();
    }
}