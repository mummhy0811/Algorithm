import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] trash;
    static boolean[][] visit;
    static byte m;
    static byte n;
    static byte[] x={0, 0, 1, -1};
    static byte[] y={1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Byte.parseByte(st.nextToken());

        m = Byte.parseByte(st.nextToken());
        short k = Short.parseShort(st.nextToken());

        trash = new boolean[n][m];
        visit = new boolean[n][m];

        for(short i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            trash[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]=true;
        }

        int max=1;
        for(byte i=0;i<n;i++){
            for(byte j=0;j<m;j++){
                if(!visit[i][j] && trash[i][j]) {
                    max=Math.max(max, checkSize(i, j));
                }
            }
        }
        bw.write(max+"");
        bw.flush();
        bw.close();
    }

    static int checkSize(int i, int j){
        short size=1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visit[i][j]=true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int s_i=now[0], s_j=now[1];

            for(int a=0;a<4;a++){
                int new_x=s_i+x[a];
                int new_y=s_j+y[a];
                if(new_x<0 || new_x>=n || new_y<0 || new_y>=m) continue;
                if(!visit[new_x][new_y] && trash[new_x][new_y]){
                    queue.add(new int[]{new_x, new_y});
                    visit[new_x][new_y]=true;
                    size++;
                }
            }
        }
        return size;
    }
}