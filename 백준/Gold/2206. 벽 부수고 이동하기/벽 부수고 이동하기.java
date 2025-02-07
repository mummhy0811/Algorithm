import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] arr;
    static int N, M;
    static int[] mx={0, 1, 0, -1};
    static int[] my = {1, 0, -1, 0};
    static int[][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visit = new int[N][M][2];

        for(int i=0;i<N;i++){
            arr[i] = br.readLine().toCharArray();
            for(int j=0;j<M;j++){
                visit[i][j][0]=Integer.MAX_VALUE;
                visit[i][j][1]=Integer.MAX_VALUE;
            }
        }
        if(N==1 && M==1){
            System.out.println("1");
            return;
        }
        System.out.println(find());
    }

    static int find(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1, 0});
        visit[0][0][0] = 1;
        visit[0][0][1] = 1;

        while(!queue.isEmpty()){
            int[] info = queue.poll();

            for(int i=0;i<4;i++){
                int nx = info[0]+mx[i];
                int ny = info[1]+my[i];
                int move = info[2]+1;
                int crash = info[3];

                if(nx == N-1 && ny == M-1) return move;

                if(nx<0 || ny<0 || nx>=N || ny>=M ) continue;

                if(crash==0){
                    if(visit[nx][ny][0]<=move) continue;

                    if(arr[nx][ny]=='1' && visit[nx][ny][1]>move){
                        visit[nx][ny][1] = move;
                        queue.add(new int[]{nx, ny,  move, crash+1});
                    }else if(arr[nx][ny]=='0' ){
                        visit[nx][ny][0] = move;
                        queue.add(new int[]{nx, ny,  move, crash});
                    }
                }else if(crash==1 && arr[nx][ny]=='0'){
                    if(visit[nx][ny][1]>move &&  visit[nx][ny][0]>move){
                        visit[nx][ny][1] = move;
                        queue.add(new int[]{nx, ny,  move, crash});
                    }
                }
            }
        }
        return -1;
    }
}