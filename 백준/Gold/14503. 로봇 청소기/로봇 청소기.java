import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m, r, c, d, num;
    static byte[][] room;
    static boolean[][] isCleaned;
    static byte[] x={-1, 0, 1, 0}, y={0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        room = new byte[n][m];
        isCleaned = new boolean[n][m];
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                room[i][j] = Byte.parseByte(st.nextToken());
                isCleaned[i][j]=false;
            }
        }

        clean(r, c, d);
        bw.write(num+"");
        bw.flush();bw.close();
    }
    public static void clean(int xx, int yy, int d){
        boolean isMoved=false;
        if(!isCleaned[xx][yy]){
            isCleaned[xx][yy]=true;
            num++;
        }
        for(int i=0;i<4;i++){
            int new_x=xx+x[(d+3)%4];
            int new_y=yy+y[(d+3)%4];
            if(room[new_x][new_y]==0 && !isCleaned[new_x][new_y]){
                clean(new_x, new_y, (d+3)%4);
                isMoved=true;
                break;
            }
            d=(d+3)%4;
        }
        if(!isMoved){
            if(room[xx+x[(d+2)%4]][yy+y[(d+2)%4]]==0)
                clean(xx+x[(d+2)%4], yy+y[(d+2)%4], d);
        }
    }
}