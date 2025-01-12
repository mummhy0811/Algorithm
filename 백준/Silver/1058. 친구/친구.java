import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] depth = new int[N][N];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            Arrays.fill(depth[i], 9999);
            for(int j=0;j<N;j++){
                if(s.charAt(j)=='Y'){
                    depth[i][j] = 1;
                    depth[j][i] = 1;
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    depth[i][j] = Math.min(depth[i][j], depth[i][k]+depth[k][j]);
                }
            }
        }
        int max = 0;
        for(int i=0;i<N;i++){
            int cnt = 0;
            for(int j=0;j<N;j++){
                if(i!=j && (depth[i][j] == 1 || depth[i][j] == 2)) cnt++;
            }
            max = Math.max(max, cnt);
        }
        bw.write(max+"");
        bw.flush();
        bw.close();
    }
}