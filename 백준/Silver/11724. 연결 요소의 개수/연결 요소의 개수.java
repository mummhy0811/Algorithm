import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Integer>> arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit=new boolean[n+1];
        arr = new ArrayList<>(n+1);
        for(int i=0;i<=n;i++){
            arr.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            arr.get(n1).add(n2);
            arr.get(n2).add(n1);
        }

        int ans=0;
        for(int i=1;i<=n;i++){
            if(!visit[i]){
                check(i);
                ans++;
            }
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
    static void check(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int now=q.poll();
            visit[now]=true;
            List<Integer> neighbor = arr.get(now);
            for (int target : neighbor) {
                if (!visit[target]) {
                    visit[target] = true;
                    q.add(target);
                }
            }
        }
    }
}