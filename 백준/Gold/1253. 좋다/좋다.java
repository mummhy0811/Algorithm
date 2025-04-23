import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int cnt = 0;
        for(int i=0;i<N;i++) if(isGood(i)) cnt++;

        System.out.println(cnt);

    }

    static boolean isGood(int target){

        for(int i=0;i<N;i++){
            if(i==target) continue;
            for(int j=i+1;j<N;j++){
                if(j==target) continue;
                if(arr[i]+arr[j]==arr[target]) return true;
            }
        }
        return false;
    }
}