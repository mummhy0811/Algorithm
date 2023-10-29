import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<t;i++){
            arr.add(Integer.parseInt(br.readLine()));
        }
        int[] dp=new int[12];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;

        for(int i=4;i<11;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }

        for(int n : arr){
            bw.write(dp[n]+"\n");
        }
        bw.flush();
        bw.close();
    }
}