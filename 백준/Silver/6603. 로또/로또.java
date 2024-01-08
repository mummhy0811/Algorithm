import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int k;
    static int[] lotto, arr;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k==0) break;
            arr = new int[k];
            used= new boolean[k];
            lotto = new int[6];
            for(int i=0;i<k;i++) arr[i]= Integer.parseInt(st.nextToken());
            
            calc(0, 0);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private static void calc(int depth, int pointer) throws IOException{
        if(depth==6){
            for(int i=0;i<6;i++) bw.write(lotto[i]+" ");
            bw.write("\n");
            return;
        }

        for(int i=pointer;i<k;i++){
            if(!used[i]){
                used[i]=true;
                lotto[depth]=arr[i];
                calc(depth+1, ++pointer);
                used[i]=false;
            }
        }
    }
}