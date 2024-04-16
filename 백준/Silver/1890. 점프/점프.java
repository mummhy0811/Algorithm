import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        long[][] dis = new long[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        dis[0][0]=1;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j]==0) continue;
                //오른쪽 이동
                int newC=j+arr[i][j];
                if(newC<N) dis[i][newC]+=dis[i][j];

                //아래 이동
                int newR=i+arr[i][j];
                if( newR<N) dis[newR][j]+=dis[i][j];

            }
        }
        bw.write(dis[N-1][N-1]+"");
        bw.flush();
        bw.close();
    }
}