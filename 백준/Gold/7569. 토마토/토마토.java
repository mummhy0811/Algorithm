import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, h, green;
    static int[][][][] arr;
    static int[] mx={0, 1, 0, -1, 0, 0};
    static int[] my={1, 0, -1, 0, 0, 0};
    static int[] mh={0, 0, 0, 0, 1, -1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[n][m][h][2];

        green=0;
        for(int k=0;k<h;k++){
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<m;j++){
                    arr[i][j][k][0]=Integer.parseInt(st.nextToken());
                    if(arr[i][j][k][0]==0) {
                        green++;
                    }else if(arr[i][j][k][0]==1){
                        q.add(new int[]{k,i, j});
                    }
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
            for(int k=0;k<h;k++){
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        days=Math.max(days,arr[i][j][k][1] );
                    }
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
            int nowH=now[0];
            int nowR=now[1];
            int nowC=now[2];

            for(int i=0;i<6;i++){
                int nextH=nowH+mh[i];
                int nextR=nowR+mx[i];
                int nextC=nowC+my[i];
                if(nextR<n && nextC<m && nextR>=0 && nextC>=0 && nextH>=0 && nextH<h){
                    if(arr[nextR][nextC][nextH][0]==0 && arr[nextR][nextC][nextH][1]==0){
                        green--;
                        q.add(new int[]{nextH, nextR, nextC});
                        arr[nextR][nextC][nextH][1]=arr[nowR][nowC][nowH][1]+1;
                    }
                }
            }
        }
    }
}