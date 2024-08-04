import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] front = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) front[i]=Integer.parseInt(st.nextToken());

        int[] line = new int[n];
        Arrays.fill(line, -1);

        for(int i=1;i<=n;i++){
            int cnt = front[i-1];
            int idx=0;
            while(true){
                if(line[idx]!=-1){
                    idx++;
                    continue;
                }
                if(line[idx]==-1 && cnt==0){
                    line[idx]=i;
                    break;
                }
                idx++;
                cnt--;
            }
        }

        for(int i=0;i<n;i++) bw.write(line[i]+" ");
        bw.flush();
        bw.close();
    }
}