import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int max, min;
    public static int[] arr, oper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        oper = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<4;i++) oper[i] = Integer.parseInt(st.nextToken());

        max=Integer.MIN_VALUE;
        min=Integer.MAX_VALUE;

        search(1, arr[0]);
        bw.write(max+"\n");
        bw.write(min+"");
        bw.flush();
        bw.close();
    }
    private static void search(int depth, int ans){
        if(depth==n){
            max=Math.max(max, ans);
            min=Math.min(min, ans);
            return;
        }
        for(int i=0;i<4;i++){
            if(oper[i]>0){
                oper[i]--;
                switch ( i) {
                    case 0:  search(depth+1, ans+arr[depth]); break;
                    case 1: search(depth+1, ans-arr[depth]); break;
                    case 2: search(depth+1, ans*arr[depth]);  break;
                    case 3: search(depth+1, ans/arr[depth]); break;
                }
                oper[i]++;
            }
        }
    }
}