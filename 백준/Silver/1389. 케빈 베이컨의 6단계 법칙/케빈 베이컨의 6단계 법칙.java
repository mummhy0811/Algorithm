import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] depth = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(depth[i], 99999);
            depth[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            depth[A][B] = 1;
            depth[B][A] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    depth[i][j] = Math.min(depth[i][j], depth[i][k] + depth[k][j]);
                }
            }
        }

        int minUser = -1;
        int minSum = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += depth[i][j];
            }
            if (sum < minSum) {
                minSum = sum;
                minUser = i;
            }
        }

        bw.write(minUser + "");
        bw.flush();
        bw.close();
    }
}