import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[] broken;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int N = Integer.parseInt(s);
        int M = Integer.parseInt(br.readLine());

        broken = new boolean[11];
        if(M!=0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) broken[Integer.parseInt(st.nextToken())]=true;
        }
        if (100 == N) {
            writeAndClose(0);
            return;
        }
        if(M==10 || (N>=98 && N<=102)){
            writeAndClose(Math.abs(100-N));
            return;
        }

        if(checkCanMake(s)){
            writeAndClose(s.length());
            return;
        }

        int i=1;
        int init;
        while(true){
//            System.out.println((N+i) +" "+(N-i));
            //작은 수
            if(N-i>=0 &&checkCanMake(String.valueOf(N-i))){
                init=N-i;
                break;
            }
            //큰 수
            if(checkCanMake(String.valueOf(N+i))){
                init=N+i;
                break;
            }
            i++;
        }
//        System.out.println("init "+init);
        int min = Math.min(String.valueOf(init).length()+Math.abs(N-init), Math.abs(N-100));
        writeAndClose(min);
    }
    private static boolean checkCanMake(String num){
        for(int i=0;i<num.length();i++){
            if(broken[Integer.parseInt(String.valueOf(num.charAt(i)))]) return false;
        }
        return true;
    }
    private static void writeAndClose(long min)  throws IOException {
        bw.write(min + "");
        bw.flush();
        bw.close();
    }
}