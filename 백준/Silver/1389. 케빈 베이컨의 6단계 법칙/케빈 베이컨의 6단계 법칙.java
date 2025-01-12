import java.io.*;
import java.util.*;

public class Main {
    static int[][] depth;
    static boolean[] visit;
    static int min, N;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int minUser = -1;
        min = Integer.MAX_VALUE;
        depth = new int[N+1][N+1];
        visit = new boolean[N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            depth[A][B] = 1;
            depth[B][A] = 1;
        }

        for(int i=1;i<=N;i++){
            int calc = 0;
            for(int j=1;j<=N;j++){
                if(i==j) continue;
                visit = new boolean[N+1];
                if(depth[i][j]==0) find(i, j);
                calc+=depth[i][j];
            }
            if(min>calc){
                min = calc;
                minUser = i;
            }
        }
        bw.write(minUser+"");
        bw.flush();
        bw.close();
    }

    private static void find(int from, int to){

        Queue<int[]> queue = new LinkedList<>();
        visit[from] = true;

        for(int i=1;i<=N;i++){
            if(depth[from][i]==1){
                queue.add(new int[]{i, 1});
                visit[i] = true;
            }
        }

        while(!queue.isEmpty()){
            int[] info = queue.poll();

            for(int i=1;i<=N;i++){
                if(depth[info[0]][i]==1 && !visit[i]){
                    if(i==to){
                        depth[from][to] = info[1]+1;
                        depth[to][from] = info[1]+1;
                        return;
                    }
                    visit[i] = true;
                    queue.add(new int[]{i, info[1]+1});
                }
            }
        }
    }
}