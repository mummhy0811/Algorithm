import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0;i<t;i++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            int[] cnt = new int[100001];
            for(int j=0;j<N;j++) {
                int n = Integer.parseInt(st.nextToken());
                arr[j] = n;
                cnt[n]++;
            }
            bw.write(find(arr, cnt)+"\n");
        }
        bw.flush();
        bw.close();
    }

    private static long find(int[] arr, int[] cnt){

        Queue<Integer> queue = new LinkedList<>();
        long ans = 0;

        for (int n : arr) {
            cnt[n]--;
            boolean isBiggest = true;
            for (int j = n; j < 100001; j++) {
                if (cnt[j] > 0) {
                    queue.add(n);
                    isBiggest = false;
                    break;
                }
            }
            if (isBiggest) {
                while (!queue.isEmpty()) {
                    ans += (n - queue.poll());
                }
            }
        }

        return ans;
    }
}