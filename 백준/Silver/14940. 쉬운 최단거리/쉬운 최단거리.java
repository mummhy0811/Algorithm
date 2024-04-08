import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr, dis;
    static int[]x={0, 1, 0, -1};
    static int[]y={1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        dis = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]==2) {
                    q.add(new int[]{i, j});
                    visit[i][j]=true;
                }
            }
        }
        while(!q.isEmpty()){
            int[] now=q.poll();
            int nowR=now[0], nowC=now[1];

            for(int i=0;i<4;i++){
                int newR=nowR+x[i], newC=nowC+y[i];

                if(newR<0 || newR>=n || newC <0 || newC>=m) continue;

                if(!visit[newR][newC] && arr[newR][newC]==1) {
                    q.add(new int[]{newR, newC});
                    dis[newR][newC]=dis[nowR][nowC]+1;
                    visit[newR][newC]=true;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1 && !visit[i][j])bw.write("-1 ");
                else bw.write(dis[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}