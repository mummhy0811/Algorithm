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

        int R = 0, B = 0, min = 500000;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='R') R++;
            else if(S.charAt(i)=='B' ) B++;
        }
        int move = R;
        //R을 앞으로
        for(int i=0;i<N;i++){
            if(S.charAt(i)=='R') move--;
            else break;
        }
        min = Math.min(min, move);

        move = R;
        //R을 뒤
        for(int i=N-1;i>0;i--){
            if(S.charAt(i)=='R') move--;
            else break;
        }
        min = Math.min(min, move);

        move = B;
        //B를 앞으로
        for(int i=0;i<N;i++){
            if(S.charAt(i)=='B') move--;
            else break;
        }
        min = Math.min(min, move);

        move = B;
        //B를 뒤
        for(int i=N-1;i>0;i--){
            if(S.charAt(i)==B) move--;
            else break;
        }
        min = Math.min(min, move);
        return min;
    }

}