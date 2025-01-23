import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] arr = new int[r][c];

        int top = 0, bottom = 0;
        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<c;j++){
                int n = Integer.parseInt(st.nextToken());
                if(top == 0 && n==-1){
                    top = i;
                    bottom = i+1;
                }
                arr[i][j] = n;
            }
        }

        int[] mx = {0, 1, 0, -1}, my={1, 0, -1, 0};

        while(t-->0){
            int[][] blow = new int[r][c];
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    if(arr[i][j]>0){
                        int temp = arr[i][j]/5;

                        for(int k=0;k<4;k++){
                            int nx = i+mx[k];
                            int ny = j+my[k];

                            if(nx<0 || ny<0 || nx>=r || ny>=c || arr[nx][ny]==-1) continue;
                            blow[nx][ny]+=temp;
                            blow[i][j]-=temp;
                        }
                    }

                }
            }
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    arr[i][j]+=blow[i][j];
                }
            }

            //반시계
            for(int i = top-1 ;i>0;i--) arr[i][0] = arr[i-1][0]; //밑
            for(int i = 0;i<c-1;i++) arr[0][i] = arr[0][i+1]; //왼
            for(int i = 0;i<top;i++) arr[i][c-1] = arr[i+1][c-1]; //위
            for(int i = c-1; i>1;i--) arr[top][i] = arr[top][i-1]; //오
            arr[top][1] = 0;

            //시계
            for(int i = bottom+1;i<r-1;i++) arr[i][0] = arr[i+1][0]; //위
            for(int i = 0;i<c-1;i++) arr[r-1][i] = arr[r-1][i+1];//왼
            for(int i=r-1;i>bottom;i--) arr[i][c-1] = arr[i-1][c-1];//밑
            for(int i = c-1; i>1;i--) arr[bottom][i] = arr[bottom][i-1]; //오
            arr[bottom][1] = 0;
        }

        int answer = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++) {
                answer += arr[i][j];
            }
        }
        System.out.println(answer+2);
    }
}