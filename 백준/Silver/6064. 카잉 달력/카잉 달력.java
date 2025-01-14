import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            bw.write(find(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))+"\n");
        }
        bw.flush();
        bw.close();
    }
    private static int find(int M, int N, int x, int y){
        int max = M*N;

        while(x<=max && y<=max){
            if(y==x) return y;
            if(y<x) y+=N;
            else x+=M;
        }
        return -1;
    }
}