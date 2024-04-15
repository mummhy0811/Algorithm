import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K=Integer.parseInt(st.nextToken());
        long N=Long.parseLong(st.nextToken());
        arr = new long[K];
        long max=0;
        for(int i=0;i<K;i++){
            arr[i]=Long.parseLong(br.readLine());
            max=Math.max(max, arr[i]);
        }

        long l=1,  mid;
        long r=max;
        while(l<=r){
            mid=(l+r)/2;
            long stick=calcStick(mid);
            if(stick<N){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        bw.write(r+"");
        bw.flush();
        bw.close();
    }
    static long calcStick(long m){
        long stick=0;
        for(int i=0;i<K;i++){
            stick+=arr[i]/m;
        }
        return stick;
    }
}