import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n=Integer.parseInt(br.readLine());
        long[] dis = new long[n-1];
        int[] price = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n-1;i++) dis[i]=Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) price[i]=Integer.parseInt(st.nextToken());

        long[] total = new long[n];
        int min_price=price[0];
        for(int i=1;i<n;i++){
            min_price = Math.min(price[i-1], min_price);
            total[i]=min_price*dis[i-1]+total[i-1];
        }

        bw.write(total[n-1]+"");
        bw.flush();
        bw.close();
    }
}