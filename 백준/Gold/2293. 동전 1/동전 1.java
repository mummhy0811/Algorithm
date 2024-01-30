import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k= Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] dp = new int[k+1];
        for(int i=0;i<n;i++) arr[i]=Integer.parseInt(br.readLine());
        Arrays.fill(dp, 0);
        arr = Arrays.stream(arr).sorted().toArray();

        dp[0]=1;
        for(int i=0;i<n;i++){
            for(int j=arr[i];j<=k;j++){
                dp[j]=dp[j]+dp[j-arr[i]];
            }
        }

        bw.write(dp[k]+"");
        bw.flush();
        bw.close();
    }
}
