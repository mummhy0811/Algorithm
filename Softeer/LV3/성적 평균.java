import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] score = new int[n+1];
        score[0]=0;
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            score[i]=score[i-1]+Integer.parseInt(st.nextToken());
        }

        int a, b, num;
        double avg;
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            num=b-a+1;
            avg=((double)score[b]-(double)score[a-1])/(double)num ;
            System.out.println(String.format("%.2f", avg));
        }
    }
}