import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[] visit;
    static long min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        arr = new int[N][N];
        visit = new boolean[N];
        min=Long.MAX_VALUE;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        find(0, 0);
        bw.write(min+"");
        bw.flush();
        bw.close();
    }
    static void find(int depth, int pivot){
        if(depth==N/2){
            long n1=0, n2=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(visit[i] && visit[j])n1+=arr[i][j];
                    else if(!visit[i] && !visit[j])n2+=arr[i][j];
                }
            }
            min=Math.min(min, Math.abs(n1-n2));
        }

        for(int i=pivot;i<N;i++){
            if(!visit[i]){
                visit[i]=true;
                find(depth+1, ++pivot);
                visit[i]=false;
            }
        }
    }
}