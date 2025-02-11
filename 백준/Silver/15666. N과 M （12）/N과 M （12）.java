import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, ans;
    static int M, N;
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        set = new HashSet<>();
        find(0, 0);
    }

    static void find(int depth, int pos){
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<M;i++) sb.append(ans[i]).append(" ");
            
            String s = sb.toString();
            if(!set.contains(s)){
                System.out.println(s);
                set.add(s);
            }
            return;
        }

        for(int i=pos;i<N;i++){
            ans[depth] = arr[i];
            find(depth+1, pos++);
        }
    }
}