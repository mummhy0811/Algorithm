import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            bw.write(find(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))+"\n");
        }

        bw.flush();
        bw.close();
    }

    private static long find(int l, int r){

        if(l==r) return 1;
        else if(l==1) return r;

        long c = 1;
        int n = r-l;
        int tmp = 1;

        while(n-->0){
            c*=r--;
            c/=tmp++;
        }
        return c;
    }

}