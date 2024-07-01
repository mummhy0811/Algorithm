import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if(K<N) {
            bw.write(N-K+"");
            bw.flush();
            bw.close();
            return;
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visit = new boolean[200000];
        queue.add(new int[]{N, 0});
        while(!queue.isEmpty()){
            int[] nowInfo = queue.poll();
            int now = nowInfo[0];
            int sec = nowInfo[1];

            if(now==K){
                bw.write(sec+"");
                break;
            }

            if(now*2 < 200000 && !visit[now*2]){
                visit[now*2]=true;
                queue.add(new int[]{now*2, sec});
            }
            if(now-1 >=0 && !visit[now-1]){
                visit[now-1]=true;
                queue.add(new int[]{now-1, sec+1});
            }
            if(now+1 < 200000 &&!visit[now+1]){
                visit[now+1]=true;
                queue.add(new int[]{now+1, sec+1});
            }
        }
        bw.flush();
        bw.close();
    }
}