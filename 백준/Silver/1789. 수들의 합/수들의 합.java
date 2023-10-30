import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long s = Long.parseLong(br.readLine());
        long n=1;

        for(long i=1;i<s;i++){
            if((i*(i+1))/2>s) break;
            n=i;
        }
        bw.write(n+"");
        bw.flush();
        bw.close();
    }
}