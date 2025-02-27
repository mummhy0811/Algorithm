import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int maxArea = 100*100;

        boolean[][] paper = new boolean[101][101];

        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        while(n-->0 && sum<maxArea){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int i=0;i<10;i++){
                for(int j=0;j<10;j++){
                    if(!paper[x+i][y+j]){
                        paper[x+i][y+j] = true;
                        sum++;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}