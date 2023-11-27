import java.io.*;
import java.util.StringTokenizer;

class Main {
    static int n,m;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();
    static int[]arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        used = new boolean[n];
        arr = new int[m];

        search(0);
        System.out.println(sb);
    }
    private static void search(int depth){
        if(depth == m){
            for(int i:arr){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<n;i++){
            if(!used[i]){
                used[i]=true;
                arr[depth]=i+1;
                search(depth+1);
                used[i]=false;
            }
        }
    }
}
