import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] cnt = new int[100001];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int s=0, e=0;
        int max=0;
        while(s<=e && e<N){
            if(cnt[arr[e]]==K){
                cnt[arr[s++]]--;
            }else{
                cnt[arr[e++]]++;
            }
            max=Math.max(max,e-s);
        }
        bw.write(max+"");
        bw.flush();
        bw.close();

    }
}