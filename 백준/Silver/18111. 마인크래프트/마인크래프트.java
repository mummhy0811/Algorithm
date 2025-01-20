import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] ground = new int[N][M];
        int min = 256;
        int max = 0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int n = Integer.parseInt(st.nextToken());
                ground[i][j] = n;
                min = Math.min(min, n);
                max = Math.max(max, n);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int maxHeight = 0;

        for(int h=min;h<=max;h++){
            int blocks = B, times = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    int diff = ground[i][j] - h;

                    if(diff<0){
                        blocks+=diff;
                        times-=diff;
                    }else if(diff>0){
                        blocks+=diff;
                        times += 2*diff;
                    }
                }
            }

            if (blocks >= 0 && minTime>=times) {
                minTime = times;
                maxHeight = h;
            }
        }
        System.out.println(minTime+" "+maxHeight);
    }
}