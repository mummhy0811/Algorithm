import java.io.*;
import java.util.*;

public class Main {
    static long a, b, max;
    static char[] arr, ans;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String tmpA=st.nextToken();
        String tmpB=st.nextToken();
        a = Long.parseLong(tmpA);
        b=Long.parseLong(tmpB);

        max=-1;
        if(tmpA.length()<=tmpB.length()){
            arr = tmpA.toCharArray();
            Arrays.sort(arr);
            ans=new char[arr.length];
            visit=new boolean[arr.length];

            find(0);
        }

        bw.write(max+"");
        bw.flush();
        bw.close();
    }
    static void find(int depth){
        if(depth==arr.length){
            StringBuilder sb = new StringBuilder();
            if(ans[0]=='0') return;
            for(char c:ans)
                sb.append(c);
            if(Integer.parseInt(sb.toString())<b)
                max=Math.max(Integer.parseInt(sb.toString()), max);
        }

        for(int i=0;i<arr.length;i++){
            if(!visit[i]){
                visit[i]=true;
                ans[depth]=arr[i];
                find(depth+1);
                visit[i]=false;
            }
        }
    }
}