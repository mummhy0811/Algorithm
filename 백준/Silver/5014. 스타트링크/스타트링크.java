import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int f;
    static int u;
    static int d;
    static int s;
    static int g;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        if(move()) bw.write(cnt+"");
        else bw.write("use the stairs");

        bw.flush();
        bw.close();
    }
    static boolean move(){
        boolean[] visit=new boolean[f+1];
        cnt=0;

        while(s!=g && cnt<=f){
            cnt++;
            if(s>g) {
                if(s-d>=1) goDown();
                else if(s+u<=f) goUp();
            }
            else {
                if(s+u<=f) goUp();
                else if(s-d>=1) goDown();
            }
            if(visit[s] || cnt>f) return false;

            visit[s]=true;
        }
        return true;
    }
    static void goUp(){
        s+=u;
    }
    static void goDown(){
        s-=d;
    }
}