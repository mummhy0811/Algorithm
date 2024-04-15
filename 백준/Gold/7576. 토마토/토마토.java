import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m,green;
    static int[][][] arr;
    static int[] x={0, 1, 0, -1};
    static int[] y={1, 0, -1, 0};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m][2];

        green=0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j][0]=Integer.parseInt(st.nextToken());
                if(arr[i][j][0]==0) {
                    green++;
                }else if(arr[i][j][0]==1){
                    q.add(new int[]{i, j});
                }
            }
        }

        if(green==0) {
            bw.write("0");
            bw.flush();
            bw.close();
            return;
        }

        makeRed();

        if(green>0)
            bw.write("-1");
        else{
            int days=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    days=Math.max(days,arr[i][j][1] );
                }
            }
            bw.write(days+"");
        }
        bw.flush();
        bw.close();
    }
    static void makeRed(){
        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowR=now[0];
            int nowC=now[1];

            for(int i=0;i<4;i++){
                int nextR=nowR+x[i];
                int nextC=nowC+y[i];
                if(nextR<n && nextC<m && nextR>=0 && nextC>=0){
                    if(arr[nextR][nextC][0]==0 && arr[nextR][nextC][1]==0){
                        green--;
                        q.add(new int[]{nextR, nextC});
                        arr[nextR][nextC][1]=arr[nowR][nowC][1]+1;
                    }
                }
            }
        }
    }
}