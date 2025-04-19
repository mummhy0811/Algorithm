import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        int len = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
            if(n>=S) len = 1;
        }

        if(len==1){
            System.out.println(1);
            return;
        }

        int l=0, r=0, sum=0;
        while(l<=r && r<N){
            sum+=arr[r];

            if(sum>=S){
                len = Math.min(r-l+1, len);
                while(l<=r){
                    sum-=arr[l++];
                    if(sum<S) break;
                    len = Math.min(r-l+1, len);
                }
            }
            r++;
        }

        if(len==Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(len);
    }

}