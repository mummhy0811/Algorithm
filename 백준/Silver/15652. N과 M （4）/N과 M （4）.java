import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        find(0, 1);
        bw.flush();
        bw.close();
    }
    private static void find(int depth, int pivot)throws IOException{
        if(depth>=m){
            for(int i=0;i<m;i++){
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        }
        for(int j=pivot;j<=n;j++){
            arr[depth]=j;
            find(depth+1, j);
        }
    }
}