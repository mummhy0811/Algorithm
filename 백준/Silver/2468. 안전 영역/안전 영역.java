import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] visit;

    static int[] x={0, 0, 1, -1};
    static int[] y={1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];


        int max=0, min=100;
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int now=Integer.parseInt(st.nextToken());
                arr[i][j]=now;
                max=Math.max(max, now);
                min=Math.min(min, now);
            }
        }

        int max_area=1;
        for(int i=min;i<=max;i++){
            visit = new boolean[n][n];
            max_area=Math.max(max_area, find(i));
        }
        bw.write(max_area+"");
        bw.flush();
        bw.close();
    }
    private static int find(int height){
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]>height && !visit[i][j]){
                    new_area(i, j, height);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private static void new_area(int i, int j, int height){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});

        while(!q.isEmpty()){
            int[] now = q.poll();
            visit[now[0]][now[1]]=true;
            for(int m=0;m<4;m++){ 
                int new_x=now[0]+x[m];
                int new_y=now[1]+y[m];

                if(new_x<0 || new_x>=n || new_y<0 || new_y>=n) continue;

                if(arr[new_x][new_y]>height && !visit[new_x][new_y]){
                    q.add(new int[]{new_x, new_y});
                    visit[new_x][new_y]=true;
                }
            }
        }
    }
}
