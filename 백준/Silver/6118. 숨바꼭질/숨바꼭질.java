import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        int[] dist = new int[N + 1]; // 1번 헛간부터의 거리 저장
        Arrays.fill(dist, -1);
        dist[1] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        int maxDist = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (dist[next] == -1) { // 미방문
                    dist[next] = dist[cur] + 1;
                    maxDist = Math.max(maxDist, dist[next]);
                    queue.add(next);
                }
            }
        }

        int minIdx = 0, count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == maxDist) {
                if (minIdx == 0) minIdx = i;
                count++;
            }
        }
        System.out.println(minIdx + " " + maxDist + " " + count);
    }
}