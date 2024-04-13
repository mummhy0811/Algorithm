import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static char[][]arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i]=st.nextToken().toCharArray();
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=n-8;i++){
            for(int j=0;j<=m-8;j++){
                min=Math.min(min, chess(i, j));
            }
        }
        bw.write(min+"");
        bw.flush();
        bw.close();
    }
    static int chess(int r, int c){

        int n1=0,n2=0;

        for(int i=0;i<8;i++){
            if(i%2==0){
                n1+=WB(i, r, c);
            }else{
                n1+=BW(i, r, c);
            }
        }

        for(int i=0;i<8;i++){
            if(i%2==0){
                n2+=BW(i, r, c);
            }else{
                n2+=WB(i, r, c);
            }
        }

        return Math.min(n1, n2);
    }
    static int WB(int i, int r, int c){
        int n=0;
        for(int j=0;j<8;j+=2){
            if(arr[r+i][c+j]!='W') n++;
            if(arr[r+i][c+j+1]!='B') n++;
        }
        return n;
    }
    static int BW(int i, int r, int c){
        int n=0;
        for(int j=0;j<8;j+=2){
            if(arr[r+i][c+j]!='B') n++;
            if(arr[r+i][c+j+1]!='W')n++;
        }
        return n;
    }
}