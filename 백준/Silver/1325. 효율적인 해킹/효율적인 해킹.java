import java.io.*;
import java.util.*;

public class Main {
    static int N, max;
    static List<Integer>[] graph;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            graph[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        cnt = new int[N+1];
        max=0;
        for (int i = 1; i <= N; i++) {
            if(graph[i].isEmpty()) continue;

            boolean[] visited = new boolean[N + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i]=true;

            while(!queue.isEmpty()){
                int cur = queue.poll();
                for (int next : graph[cur]) {
                    if(!visited[next]){
                        visited[next]=true;
                        queue.add(next);
                        max=Math.max(max, ++cnt[next]);
                    }
                }
            }
        }

        for (int i=1;i<=N;i++) {
            if(cnt[i]==max) bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }
}