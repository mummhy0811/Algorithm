import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        int[] sum = new int[n+1];

        st = new StringTokenizer(br.readLine());
        arr[0]=0; sum[0]=0;
        for(int i=1;i<=n;i++){
            int num=Integer.parseInt(st.nextToken());
            arr[i]=num;
            sum[i]=sum[i-1]+num;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int l=Integer.parseInt(st.nextToken());
                int r=Integer.parseInt(st.nextToken());
                bw.write((sum[r]-sum[l-1])+"\n");
            }
        }

        bw.flush();
        bw.close();
    }
}