import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr ;
    static int[] mx = {0, 1, 0, -1}, my = {1, 0, -1, 0};
    static int N, M, maxSize = 0;

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

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j] == 0){
                    arr[i][j] = 1;
                    find( i,1);
                    arr[i][j] = 0;
                }
            }
        }
        System.out.println(maxSize);
    }
    private static void find(int l, int wallCnt){
        if(wallCnt == 3){
            maxSize = Math.max(maxSize,checkSafeArea());
            return;
        }
        for(int i=l;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j] == 0){
                    arr[i][j] = 1;
                    find(l,wallCnt+1);
                    arr[i][j] = 0;
                }
            }
        }

    }
    private static int checkSafeArea(){
        boolean[][] visit = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        int totalSize = N*M;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j] == 2){
                    queue.add(new int[]{i, j});
                    totalSize--;
                }else if(arr[i][j] == 1){
                    totalSize--;
                }
            }
        }


        while(!queue.isEmpty()){
            int[] pos = queue.poll();

            int x = pos[0];
            int y = pos[1];

            for(int i=0;i<4;i++){
                int nx = x+mx[i];
                int ny = y+my[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M || visit[nx][ny] || arr[nx][ny]!=0) continue;

                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny});
                totalSize--;
            }
        }
        return totalSize;
    }
}