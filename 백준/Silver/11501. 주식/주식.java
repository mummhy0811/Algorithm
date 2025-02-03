import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            
            sb.append(find(arr)).append("\n");
        }
        System.out.println(sb);
    }

    private static long find(int[] arr){
        long maxProfit = 0;
        int maxPrice = 0;
        for(int i = arr.length-1;i>=0;i--){
            if(arr[i]>maxPrice ) maxPrice  = arr[i];
            else maxProfit += (maxPrice - arr[i]);
        }
        return maxProfit;
    }
}