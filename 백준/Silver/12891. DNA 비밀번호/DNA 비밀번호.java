import java.io.*;
import java.util.*;

public class Main {
    static int[] p= new int[4];
    static int A, C, G, T, cnt=0;
    static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sLen = Integer.parseInt(st.nextToken());
        int pLen = Integer.parseInt(st.nextToken());

        S = br.readLine();

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        for(int i=0;i<pLen;i++){
            plusCnt(i);
        }
        checkValid();
        for(int i=0;i<sLen-pLen;i++){
            if(S.charAt(i)=='A') p[0]--;
            else if(S.charAt(i)=='C') p[1]--;
            else if(S.charAt(i)=='G') p[2]--;
            else p[3]--;

            plusCnt(i+pLen);
            checkValid();
        }

        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
    private static void plusCnt(int i){
        if(S.charAt(i)=='A') p[0]++;
        else if(S.charAt(i)=='C') p[1]++;
        else if(S.charAt(i)=='G') p[2]++;
        else p[3]++;
    }

    private static void checkValid(){
        if(p[0]>=A && p[1]>=C && p[2]>=G && p[3]>=T) cnt++;
    }
}