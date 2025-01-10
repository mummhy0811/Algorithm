import java.io.*;
import java.util.*;

public class Main {
    static int[] mx = {0, 1, 0, -1 };
    static int[] my = {1, 0, -1, 0};
    static int[][] arr;
    static boolean[][] visit;

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visit = new boolean[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                visit[i][j] = true;
                find(i, j, 1, arr[i][j], N, M);
                visit[i][j] = false;
                checkTShape(i, j, N, M);
            }
        }

        bw.write(max+"");
        bw.flush();
        bw.close();
    }

    private static void find(int x, int y, int size, int sum, int N, int M){
        if(size == 4){
            max = Math.max(max, sum);
            return;
        }

        for(int i=0;i<4;i++){
            int nx = x+mx[i];
            int ny = y+my[i];

            if(nx<0 || ny<0 || nx>=N || ny>=M || visit[nx][ny]) continue;
            visit[nx][ny] = true;
            find(nx, ny, size+1, sum+arr[nx][ny], N, M);
            visit[nx][ny] = false;
        }
    }
    private static void checkTShape(int x, int y, int N, int M) {
        int sum;

        if (x > 0 && x < N - 1 && y > 0) { // 'ㅓ'
            sum = arr[x][y] + arr[x - 1][y] + arr[x + 1][y] + arr[x][y - 1];
            max = Math.max(max, sum);
        }
        if (x > 0 && x < N - 1 && y < M - 1) { // 'ㅏ'
            sum = arr[x][y] + arr[x - 1][y] + arr[x + 1][y] + arr[x][y + 1];
            max = Math.max(max, sum);
        }
        if (y > 0 && y < M - 1 && x > 0) { // 'ㅗ'
            sum = arr[x][y] + arr[x - 1][y] + arr[x][y - 1] + arr[x][y + 1];
            max = Math.max(max, sum);
        }
        if (y > 0 && y < M - 1 && x < N - 1) { // 'ㅜ'
            sum = arr[x][y] + arr[x + 1][y] + arr[x][y - 1] + arr[x][y + 1];
            max = Math.max(max, sum);
        }
    }
}