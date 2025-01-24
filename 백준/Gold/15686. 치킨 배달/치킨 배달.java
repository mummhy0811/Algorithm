import java.io.*;
import java.util.*;

public class Main {
    static int M, N, min = Integer.MAX_VALUE, chickenCnt;
    static int[][] vil;
    static List<int[]> chickens;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        vil = new int[N][N];
        chickens = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int n = Integer.parseInt(st.nextToken());
                vil[i][j] = n;
                if(n==2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }
        chickenCnt = chickens.size();
        choose(0, 0, new int[M]);

        System.out.println(min);
    }
    private static void choose(int depth, int pos, int[] chosen){
        if(depth == M){
            min = Math.min(min, calcDistance(chosen));
            return;
        }

        for(int i=pos;i<chickenCnt;i++){
            chosen[depth] = i;
            choose(depth+1, ++pos, chosen);
        }
    }

    private static int calcDistance(int[] chosen){
        int dis = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(vil[i][j]==1){
                    int minDis = Integer.MAX_VALUE;
                    for(Integer idx: chosen){
                        int[] chicken = chickens.get(idx);
                        minDis = Math.min(minDis, Math.abs(i-chicken[0])+Math.abs(j-chicken[1]));
                    }
                    dis+=minDis;
                }
            }
        }
        return dis;
    }
}