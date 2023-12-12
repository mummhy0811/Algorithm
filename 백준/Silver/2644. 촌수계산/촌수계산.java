import java.io.*;
import java.util.*;

class Main {
    private static List<List<Integer>> map;
    private static int n;
    private static int f1;
    private static int f2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n=Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        f1= Integer.parseInt(st.nextToken());
        f2 = Integer.parseInt(st.nextToken());

        int m=Integer.parseInt(br.readLine());
        map = new ArrayList<>(n+1);

        for(int i=0;i<=n;i++) map.add(new ArrayList<>());

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int p1= Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            map.get(p1).add(p2);
            map.get(p2).add(p1);
        }

        bw.write(find()+"");
        bw.flush();
        bw.close();
    }

    private static int find(){
        boolean[] visit = new boolean[n+1];
        int[] dist = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(f1);
        visit[f1]=true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            if(now == f2) return dist[now];

            for(int i:map.get(now)){
                if(!visit[i]){
                    dist[i]=dist[now]+1;
                    visit[i]=true;
                    queue.add(i);
                }
            }

        }
        return -1;
    }
}