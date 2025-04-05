import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int solved = arr[0]+L-1; // 막힌 위치
        int cnt = 1;

        for(int i=1;i<N;i++){
            if(arr[i]<=solved) continue;
            cnt++;
            solved = arr[i]+L-1;
        }

        System.out.println(cnt);
    }
}