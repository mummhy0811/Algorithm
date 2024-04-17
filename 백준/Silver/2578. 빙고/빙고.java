import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] bingo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        bingo=new int[5][5];
        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                bingo[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int ans=0;
        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                ans++;
                bingo(Integer.parseInt(st.nextToken()));

                if(checkEnd()){
                    bw.write(ans+"");
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }

    static void bingo(int n){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(bingo[i][j]==n) bingo[i][j]=-1;
            }
        }
    }
    static boolean checkEnd(){
        int r=0, c=0, lc=0, rc=0 ,n=0, idx=0;

        for(int i=0;i<5;i++){
            r=0;c=0;
            for(int j=0;j<5;j++){
                //가로
                r+=bingo[i][j];
                //세로
                c+=bingo[j][i];
                if(i == j) {
                    lc += bingo[i][j];
                }
                if(i == idx && j == 4 - idx) {
                    rc += bingo[i][j];
                    idx++;
                }
            }
            if(r==-5) n++;
            if(c==-5) n++;
            if(lc==-5) n++;
            if(rc==-5) n++;
        }
        return n >= 3;
    }
}