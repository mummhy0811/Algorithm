import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] belt = new int[n + k - 1];
        for(int i=0;i<n;i++){
            belt[i] = Integer.parseInt(br.readLine());
        }
        for (int i = n; i < n + k - 1; i++) {
            belt[i] = belt[i - n];
        }
        int ans=1;
        int[] now = new int[d+1];
        now[c]++;
        for(int i=0;i<k;i++){
            if(now[belt[i]]==0) ans++;
            now[belt[i]]++;
        }

        int max=ans;

        for(int i=k;i<belt.length;i++){
            if(now[belt[i]]==0) ans++;
            now[belt[i]]++;

            now[belt[i-k]]--;
            if(now[belt[i-k]]==0) ans--;

            max=Math.max(max, ans);
        }
        bw.write(max+"");
        bw.flush();
        bw.close();
    }
}