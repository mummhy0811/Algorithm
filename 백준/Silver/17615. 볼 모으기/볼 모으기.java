import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String S = br.readLine();
        bw.write(run(N, S)+"");
        bw.flush();
        bw.close();
    }
    public static int run(int N, String S){
        char[] arr= S.toCharArray();
        int R = 0, B = 0, min = 500000;
        for(int i=0;i<S.length();i++){
            if(arr[i]=='R') R++;
            else if(arr[i]=='B' ) B++;
        }
        int move = 0;
        //R을 앞으로
        for(int i=0;i<S.length();i++){
            if(arr[i]=='R') move++;
            else break;
        }
        min = Math.min(min, R-move);

        move = 0;
        //R을 뒤
        for(int i=N-1;i>=0;i--){
            if(arr[i]=='R') move++;
            else break;
        }
        min = Math.min(min, R-move);

        move = 0;
        //B를 앞으로
        for(int i=0;i<S.length();i++){
            if(arr[i]=='B') move++;
            else break;
        }
        min = Math.min(min,B- move);

        move = 0;
        //B를 뒤
        for(int i=N-1;i>=0;i--){
            if(arr[i]=='B') move++;
            else break;
        }
        min = Math.min(min, B-move);
        return min;
    }
}