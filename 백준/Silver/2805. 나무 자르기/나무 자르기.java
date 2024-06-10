import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];

        int l=0, r=0;
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            r=Math.max(r, arr[i]);
        }

        while(l<r){
            int mid=(l+r)/2;
            long remain=calcRemain(mid);
            if(remain>=m){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        
        bw.write((r-1)+"\n");
        bw.flush();
        bw.close();
    }

    private static long calcRemain(int cm){
        long h=0;
        for(int i=0;i<n;i++){
            if(arr[i]>cm) h+=(arr[i]-cm);
        }
        return h;
    }
}