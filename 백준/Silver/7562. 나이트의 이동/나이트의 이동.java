import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] visit;
    static int targetX, targetY;
    static int[] moveX = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] moveY = {2, 1, -1, -2, -2, -1, 1, 2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            int l = Integer.parseInt(br.readLine());

            arr = new int[l][l];
            visit = new boolean[l][l];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nowX = Integer.parseInt(st.nextToken());
            int nowY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            if(nowX==targetX && nowY==targetY) bw.write("0\n");
            else bw.write(find(nowX, nowY)+"\n");
        }

        bw.flush();
        bw.close();

    }
    private static int find(int nowX, int nowY){
        int move=0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{nowX, nowY, 0});

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            move = now[2];
            for(int i=0;i<8;i++){
                int nx = x+moveX[i];
                int ny = y+moveY[i];

                if(nx<0 || nx>=arr.length || ny<0 || ny>=arr.length) continue;

                if(!visit[nx][ny]){
                    queue.add(new int[]{nx, ny, move+1});
                    visit[nx][ny]=true;

                    if(nx==targetX && ny==targetY) return move+1;
                }
            }
        }

        return move;
    }
}