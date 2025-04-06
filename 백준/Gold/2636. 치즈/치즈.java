import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, cnt;
    static int[][] cheese;
    static int[] mr = {1, 0, -1, 0};
    static int[] mc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cheese = new int[N][M];

        cnt = 0; // 치즈 면적

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int n = Integer.parseInt(st.nextToken());
                cheese[i][j] = n;
                if(n==1) cnt++;
            }
        }

        int hour = 0, before = cnt;
        while(cnt>0){
            before = cnt;
            melt();
            hour++;
        }
        System.out.println(hour);
        System.out.println(before);

    }
    static void melt(){

        Queue<int[]> queue = new LinkedList<>();
        //시작점 찾기
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(cheese[i][j]==1 && isSide(i, j)){
                    queue.add(new int[]{i, j});
                    cheese[i][j] = -1;
                    cnt--;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] info = queue.poll();
            cheese[info[0]][info[1]] = 0;
        }
    }

    static boolean isSide(int r, int c){

        for(int i=0;i<4;i++){
            int nr = r+mr[i];
            int nc = c+mc[i];

            if(nr<0 || nr>=N || nc<0 || nc>=M) continue;

            //옆칸이 0이면 에어포켓인지 확인
            if(cheese[nr][nc]==0 && !isAirPocket(nr, nc)) return true;

        }
        return false;
    }


    static boolean isAirPocket(int R, int C){
        boolean[][] visit = new boolean[N][M];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{R, C});

        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int r = info[0];
            int c = info[1];

            for(int i=0;i<4;i++){
                int nr = r+mr[i];
                int nc = c+mc[i];

                if(nr<0 || nr>=N || nc<0 || nc>=M || visit[nr][nc]) continue;

                //가장자리
                if(nr==0 || nr == N-1 || nc == 0 || nc == M-1) return false;

                if(cheese[nr][nc]==0){
                    queue.add(new int[]{nr, nc});
                    visit[nr][nc] = true;
                }
            }
        }
        return true;
    }
}