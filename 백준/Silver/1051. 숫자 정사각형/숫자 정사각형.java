import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][]arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<m;j++){
                arr[i][j]=s.charAt(j)-'0';
            }
        }
        int max=1;
        for(int i=0;i<n-max;i++){
            for(int j=0;j<m-max;j++){
                max=Math.max(max, hasFair(i, j));
            }
        }
        bw.write(max*max+"");
        bw.flush();
        bw.close();
    }
    static int hasFair(int r, int c){
        int target=arr[r][c];
        int max=0;
        for(int i=m-1;i>c;i--){
            if(arr[r][i]==target){ //가로로 일치하는 수가 있으면
                max=Math.max(max, find(r, c, i-c)); //세로로도 일치하는지 확인
            }
        }
        return max;
    }
    static int find(int r, int c, int len){
        int target=arr[r][c];
        if(r+len>=n) return 0;
        if(arr[r+len][c]==target && arr[r+len][c+len]==target) return len+1;
        return 0;
    }
}