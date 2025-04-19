import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[][] visit;
    static int[] mr = {0, 1, 0, -1};
    static int[] mc = {1, 0, -1, 0};
    static int N, L, R;
    static Map<Integer, Integer> map;
    static boolean canMove;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        while(days<=2000){

            map = new HashMap<>();
            visit = new int[N][N];
            canMove = false;

            //국경 열기
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(visit[i][j]==0) open(i, j, map.size());
                }
            }

            if(!canMove)break;

            //이동하기
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(visit[i][j]!=0) arr[i][j] = map.get(visit[i][j]);
                }
            }
            days++;
        }
        System.out.println(days);
    }

    static void open(int sr, int sc, int idx){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        int sum = arr[sr][sc];
        int cnt = 1;
        visit[sr][sc] = ++idx;

        while(!queue.isEmpty()){
            int[] pos = queue.poll();

            int r = pos[0];
            int c = pos[1];
            int origin = arr[r][c];

            for(int i=0;i<4;i++){
                int nr = r+mr[i];
                int nc = c+mc[i];
                if(nr<0 || nc<0 || nr>=N || nc>=N || visit[nr][nc]!=0) continue;

                int diff = Math.abs(origin - arr[nr][nc]);
                if(diff>=L && diff<=R){
                    visit[nr][nc] = idx;
                    queue.add(new int[]{nr, nc});
                    sum+=arr[nr][nc];
                    cnt++;
                    canMove = true;
                }
            }
        }

        map.put(idx, sum/cnt);
    }
}