import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] sum = new int[n];

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        sum[0]=arr[0];
        int max=arr[0];
        for(int i=1;i<n;i++){
            sum[i]=Math.max(sum[i-1]+arr[i], arr[i]);
            max=Math.max(max, sum[i]);
        }
        bw.write(max+"");
        bw.flush();
        bw.close();
    }
}