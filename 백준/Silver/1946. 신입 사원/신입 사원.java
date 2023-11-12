import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            int n=Integer.parseInt(br.readLine());
            int[] score = new int[n];

            for(int j=0;j<n;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                score[Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken());
            }

            int num=n;
            int min = score[0];
            for(int k=1;k<n;k++){
                if(min<score[k]){
                    num--;
                    continue;
                }
                min=score[k];
            }
            bw.write(num+"\n");
        }

        bw.flush();
        bw.close();
    }
}