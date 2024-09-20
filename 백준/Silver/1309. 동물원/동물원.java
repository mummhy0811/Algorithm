import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] xx = new int[N];
        int[] xo = new int[N];
        int[] ox = new int[N];

        xx[0]=1;
        xo[0]=1;
        ox[0]=1;
        for(int i=1;i<N;i++){
            xx[i]=(xx[i-1]+xo[i-1]+ox[i-1])%9901;
            xo[i]=(ox[i-1]+xx[i-1])%9901;
            ox[i]=(xo[i-1]+xx[i-1])%9901;
        }

        bw.write((xx[N-1]+xo[N-1]+ox[N-1])%9901+"");
        bw.flush();
        bw.close();

    }
}