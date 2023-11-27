
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int n, m;
    static int[][] arr ;
    static int min;
    static int[][] size;
    static boolean[][]visit;
   static Queue<int[]> queue = new LinkedList<>();

    static int[] move_x={0, -1, 0, 1};
    static int[] move_y={1, 0, -1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        min = n*m;
        size = new int[n][m];
        visit= new boolean[n][m];
        arr = new int[n][m];
        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<m;j++){
                arr[i][j]=s.charAt(j)-'0';
                size[i][j]=n*m+1;
            }
        }

        queue.add(new int[]{0, 0});
        bfs();

        bw.write(size[n-1][m-1]+"");
        bw.flush();
        bw.close();
    }
    private static void bfs(){

        size[0][0]=1;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int x = now[1];
            int y = now[0];

            for(int i=0;i<4;i++){
                int new_x = x+move_x[i];
                int new_y=y+move_y[i];

                if(new_x<0 || new_x>=m || new_y<0 || new_y>=n || visit[new_y][new_x]) continue;

                if(arr[new_y][new_x]==1){
                    visit[new_y][new_x]=true;
                    size[new_y][new_x]=Math.min(size[y][x]+1, size[new_y][new_x]);
                    queue.add(new int[]{new_y, new_x});
                }
            }
        }
    }
}
