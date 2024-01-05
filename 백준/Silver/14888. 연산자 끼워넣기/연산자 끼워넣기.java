import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static long max, min;
    public static String[] oper;
    public static int[] arr;
    public static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        oper = new String[n-1];
        used = new boolean[n-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int t=0;

        for(int i=0;i<4;i++) {
            int n = Integer.parseInt(st.nextToken());
            for(int j=0;j<n;j++) {
                if(i==0) oper[t++]="+";
                else if(i==1) oper[t++]="-";
                else if(i==2) oper[t++]="*";
                else oper[t++]="/";
            }
        }

        max=Long.MIN_VALUE;
        min=Long.MAX_VALUE;

        search(1, arr[0]);
        bw.write(max+"\n");
        bw.write(min+"");
        bw.flush();
        bw.close();
    }
    private static void search(int depth, long ans){
        if(depth==n){
            max=Math.max(max, ans);
            min=Math.min(min, ans);
            return;
        }

        for(int i=0;i<n-1;i++){
            if(!used[i]){
                used[i]=true;
                switch ( oper[i]) {
                    case "+":  search(depth+1, ans+arr[depth]); break;
                    case "-": search(depth+1, ans-arr[depth]); break;
                    case "*": search(depth+1, ans*arr[depth]);  break;
                    case "/": search(depth+1, ans/arr[depth]); break;
                }
                used[i]=false;
            }
        }
    }
}