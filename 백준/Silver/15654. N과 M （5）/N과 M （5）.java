import java.io.*;
import java.util.*;

public class Main {
    static int[] nums, arr;
    static boolean[] visit;
    static int M, N;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[M];
        arr = new int[N];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        find(0, 0);
        bw.flush();
        bw.close();
    }

    private static void find(int depth, int pivot) throws IOException{
        if(depth==M){
            for(int i=0;i<M;i++) bw.write(nums[i]+" ");
            bw.write("\n");
            return;
        }

        for(int i=0;i<N;i++){
            if(!visit[i]){
                visit[i] = true;
                nums[depth] = arr[i];
                find(depth+1, ++pivot);
                visit[i] = false;
            }
        }
    }
}