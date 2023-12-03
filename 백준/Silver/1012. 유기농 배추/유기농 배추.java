import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[][] arr;
    static boolean[][] visit;
    static int m;
    static int n;
    static int[] move_x={0, -1, 0, 1};
    static int[] move_y={-1, 0, 1, 0};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for(int trys=0;trys<t;trys++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());//가로
            n = Integer.parseInt(st.nextToken());//세로
            int k = Integer.parseInt(st.nextToken());//배추

            arr= new int[n][m];
            visit = new boolean[n][m];

            for(int i=0;i<k;i++){
                st = new StringTokenizer(br.readLine());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
                arr[y][x]=1;
            }

            int size=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(!visit[i][j] && arr[i][j]==1){
                        size=size+find(i, j);
                    }
                }
            }
            bw.write(size+"\n");
        }

        bw.flush();
        bw.close();
    }
    static int find(int sy, int sx){

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sy, sx});

        while (!q.isEmpty()){

            int[] now = q.poll();
            int y=now[0];
            int x=now[1];

            for(int i=0;i<4;i++){
                int new_x=x+move_x[i];
                int new_y=y+move_y[i];
                if(new_x<0 || new_x>=m || new_y<0 || new_y>=n || visit[new_y][new_x] )continue;

                visit[new_y][new_x]=true;
                if(arr[new_y][new_x]==1){
                    q.add(new int[]{new_y, new_x});
                }
            }
        }
        return 1;
    }
}