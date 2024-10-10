import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int cnt = 0, N, S;
    static int[] choose, arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
        bw.write(run(N, S, arr)+"");
        bw.flush();
        bw.close();
    }
    public static int run(int _N, int _S, int[] _arr){
        N=_N;
        S=_S;
        arr=_arr;
        visit = new boolean[N];

        for(int i=1;i<=N;i++){
            choose = new int[i];
            find(0, 0, i);
        }

        return cnt;
    }
    public static void find(int depth, int pos, int n){
        if(depth==n){
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=choose[i];
            }
            if(sum==S)cnt++;
            return;
        }

        for(int i=pos;i<N;i++){
            if(!visit[i]){
                visit[i]=true;
                choose[depth]=arr[i];
                find(depth+1, ++pos, n);
                visit[i]=false;
            }
        }
    }
}