import java.io.*;
import java.util.*;

public class Main {

    static int[] mx = {0, 1, 0, -1};
    static int[] my = {1, 0, -1, 0};
    static char[][] cam ;
    static boolean[][] visit;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        cam = new char[N][M];
        visit = new boolean[N][M];

        int startX = 0;
        int startY = 0;
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                char c = s.charAt(j);
                cam[i][j] = c;
                if(c == 'I') {
                    startX = j;
                    startY = i;
                }
            }
        }

        find(startX, startY, N, M);
        if(cnt == 0) bw.write("TT");
        else bw.write(cnt+"");
        bw.flush();
        bw.close();
    }

    private static void find(int startX, int startY, int N, int M){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visit[startY][startX] = true;

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];

            for(int i=0;i<4;i++){
                int nx = x+mx[i];
                int ny = y+my[i];
                if(nx<0 || ny<0 || nx>=M || ny>=N || visit[ny][nx]||cam[ny][nx] == 'X') continue;
                if(cam[ny][nx]=='P') cnt++;
                visit[ny][nx] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }
}