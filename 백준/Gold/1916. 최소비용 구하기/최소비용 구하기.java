import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Node>> graph;
    static int[] cost;

    static class Node implements Comparable<Node> {
        int city, weight;

        public Node(int city, int weight) {
            this.city = city;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());

        System.out.println(dijkstra(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        cost = new int[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        cost[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curCity = cur.city;
            int curCost = cur.weight;

            if (curCost > cost[curCity]) continue;

            for (Node next : graph.get(curCity)) {
                int newCost = cost[curCity] + next.weight;
                if (newCost < cost[next.city]) {
                    cost[next.city] = newCost;
                    pq.add(new Node(next.city, newCost));
                }
            }
        }
        return cost[end];
    }
}