import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
        run(N, M, arr);
        bw.flush();
        bw.close();
    }

    //-------------------------------------------
    static int max;
    static int[] cnt, ans;
    static List<String> list;
    public static void run(int N, int M, int[] arr)throws IOException{
        cnt = new int[10001];
        ans = new int[M];
        list = new ArrayList<>(); //결과 저장
        
        max=0;

        for(int n:arr){
            cnt[n]++;
            max = Math.max(max, n);
        }

        find(0, 0, M);

        for(String s:list){
            bw.write(s+"\n");
        }

    }

    public static void find(int depth, int from, int M){
        if(depth==M){
            StringBuilder sb = new StringBuilder();
            for(int n:ans){
                sb.append(n).append(" ");
            }
            list.add(sb.toString());
            return;
        }

        for(int i=0;i<=max;i++){
            if(cnt[i]!=0){
                cnt[i]--;
                ans[depth]=i;
                find(depth+1, from++, M);
                cnt[i]++;
            }
        }
    }
}