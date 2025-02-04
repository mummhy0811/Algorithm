import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visit;
    static int[] mx = {0, 1, 0, -1};
    static int[] my = {1, 0, -1, 0};
    static int N, M;
    static boolean isAllMelted = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int years = 0;

        while(!isFin()){
            years++;
            melt();
            if(isFin()){
                break;
            }
        }
        if(isAllMelted) System.out.println("0");
        else System.out.println(years);
    }


    static void melt(){
        int[][] before = new int[N][M];
        for (int i = 0; i < arr.length; i++) {
            before[i] = arr[i].clone();
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(before[i][j]==0) continue;
                for(int k=0;k<4;k++){
                    int nx = i+mx[k];
                    int ny = j+my[k];

                    if(nx<0 || ny<0 || nx>=N || ny>=M) continue;

                    if(before[nx][ny]==0) arr[i][j]--;

                }
                if(arr[i][j]<0) arr[i][j]=0;
            }
        }
    }
    static boolean isFin(){
        visit = new boolean[N][M];

        int cnt = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]!=0 && !visit[i][j]){
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        if(cnt==0){
            isAllMelted = true;
            return true;
        }else return cnt >= 2;
    }
    static void bfs(int sx, int sy){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy});
        visit[sx][sy] = true;

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int i = pos[0];
            int j = pos[1];

            for(int k=0;k<4;k++){
                int nx = i+mx[k];
                int ny = j+my[k];

                if(nx<0 || ny<0 || nx>=N || ny>=M || visit[nx][ny] || arr[nx][ny]==0) continue;

                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny});

            }
        }
    }
}