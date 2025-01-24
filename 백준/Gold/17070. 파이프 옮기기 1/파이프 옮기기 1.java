import java.io.*;
import java.util.*;

public class Main {
    static int N, cnt;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];

        StringTokenizer st;
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        find(1, 2, 0);

        System.out.println(cnt);
    }
    private static void find(int r2, int c2, int direction){
        if(r2 == N && c2 == N){
            cnt++;
            return;
        }
        int nc =c2+1;
        int nr =r2+1;
        if(direction!=1 && nc<=N && arr[r2][nc]!=1){
            find(r2, nc, 0); // 가로
        }
        if(direction!=0 && nr<=N && arr[nr][c2]!=1){
            find( nr, c2, 1); // 세로
        }
        if(nr<=N && nc<=N && arr[r2][nc]!=1 && arr[nr][c2]!=1 && arr[nr][nc]!=1) {
            find(nr, nc, 2);//대각선
        }
    }
}