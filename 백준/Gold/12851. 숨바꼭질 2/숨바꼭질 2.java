import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int minTime=100001, cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n >= k) {
            System.out.println((n-k) + "\n1");
            return;
        }
        bfs();
        System.out.println(minTime + "\n" + cnt);
    }
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        int[] depth = new int[100001];
        q.add(n);
        depth[n]=1;

        while (!q.isEmpty()) {
            int num = q.poll();

            if(minTime<depth[num]) return;

            for(int i=0;i<3;i++){
                int next;
                if (i == 0)
                    next = num + 1;
                else if (i == 1)
                    next = num - 1;
                else
                    next = num * 2;

                if(next<0 || next>100000) continue;

                if(next==k){
                    minTime=depth[num];
                    cnt++;
                }

                if(depth[next]==0 || depth[next]==depth[num]+1){
                    q.add(next);
                    depth[next]=depth[num]+1;
                }
            }
        }
    }
}