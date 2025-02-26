import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int idx;
        int distance;
        Map<Integer, Integer> linked;
        public Node(int i, int d, Map map){
            this.idx = i; this.distance=d;
            linked = map;
        }

        @Override
        public int compareTo(Node n){
            return this.distance -n.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Node> queue = new PriorityQueue<>();
        List<Node> nodes = new ArrayList<>();

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        for(int i=0;i<=V;i++){
            nodes.add(new Node(i, Integer.MAX_VALUE, new HashMap<>()));
        }

        int sNode = Integer.parseInt(br.readLine());

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            Integer prevWeight = nodes.get(from).linked.get(to);
            if(prevWeight==null) nodes.get(from).linked.put(to, w);
            else nodes.get(from).linked.put(to, Math.min(prevWeight, w));
        }

        nodes.get(sNode).distance = 0;
        queue.add(nodes.get(sNode));

        while(!queue.isEmpty()){
            Node n = queue.poll();
            Set<Integer> set = n.linked.keySet();
            for(Integer i:set){
                Node node = nodes.get(i);
                int sum = n.distance+n.linked.get(i);
                if(node.distance>sum){
                    node.distance = sum;
                    queue.add(new Node(node.idx, sum, node.linked));
                }
            }
        }
        for(int i=1;i<=V;i++){
            if(nodes.get(i).distance==Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(nodes.get(i).distance);
        }
    }
}
