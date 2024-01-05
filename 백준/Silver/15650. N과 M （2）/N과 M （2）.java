import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;
    public static boolean[] visit;
    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        byte n = Byte.parseByte(st.nextToken());
        byte m = Byte.parseByte(st.nextToken());

        arr = new int[n];
        visit=new boolean[n];

        search(n, m, 0, 0);

        bw.flush();
        bw.close();
    }

    private static void search(byte n, byte m, int depth, int pointer) throws IOException{
        if(depth==m){
            for(int i=0;i<m;i++) bw.write(arr[i]+" ");
            bw.write("\n");
            return;
        }

        for(int i=pointer;i<n;i++){
            if(!visit[i]){
                visit[i]=true;
                arr[depth]= i+1;
                search(n, m, depth+1, ++pointer);
                visit[i]=false;
            }
        }
    }
}