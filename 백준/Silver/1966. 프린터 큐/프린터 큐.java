import java.io.*;
import java.util.*;


public class Main {
    static class Print{
        int idx;
        int priority;
        public Print(int idx, int p){
            this.idx = idx;
            this.priority = p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0;i<t;i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            int[] priority = new int[10];
            Queue<Print> queue = new LinkedList<>();

            for(int j=0;j<N;j++){
                int n = Integer.parseInt(st.nextToken());
                queue.add(new Print(j, n));
                priority[n]++;
            }

            int ans = 0;

            while(!queue.isEmpty()){
                Print p = queue.poll();
                int p_priority = p.priority;
                priority[p_priority]--;

                boolean canPrint = true;
                for(int j=p_priority+1;j<=9;j++){
                    if(priority[j]>0){
                        canPrint = false;
                        break;
                    }
                }
                if(!canPrint){
                    queue.add(p);
                    priority[p_priority]++;
                    continue;
                }
                ans++;
                if(p.idx == M){
                    break;
                }
            }
            bw.write(ans+"\n");
        }

        bw.flush();
        bw.close();
    }
}