import java.io.*;
import java.util.*;

public class Main {

    static int[] mx = {1, 0, -1, 0};
    static int[] my = {0, 1, 0, -1};
    static boolean[][] visit;
    static boolean[] isSelected;
    static char[][] arr;
    static int max = 1, R, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        visit = new boolean[R][C];
        isSelected = new boolean[26];

        for(int i=0;i<R;i++){
            arr[i] = br.readLine().toCharArray();
        }
        
        visit[0][0] = true;
        isSelected[arr[0][0]-65] = true;
        find(0, 0, 1);

        System.out.println(max);
    }
    private static void find(int r, int c, int depth){
        max = Math.max(max, depth);
        
        for(int i=0;i<4;i++){
            int nr = r+mx[i];
            int nc = c+my[i];

            if(nr<0 || nc<0 || nr>=R || nc>=C || visit[nr][nc] || isSelected[arr[nr][nc]-65]) continue;
            
            isSelected[arr[nr][nc]-65] = true;
            visit[nr][nc]= true;
            find(nr, nc, depth+1);
            isSelected[arr[nr][nc]-65] = false;
            visit[nr][nc]= false;
        }
    }
}