import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[100001];
        visit[n]=true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, 0});

        while(true){
            int[] now=q.poll();
            if(now[0]==k){
                bw.write(now[1]+"");
                break;
            }
            int num=now[0], depth=now[1];
            if(num+1<100001 &&!visit[num+1]){
                visit[num+1]=true;
                q.add(new int[]{num+1, depth+1});
            }
            if(num!=0 && !visit[num-1]){
                visit[num-1]=true;
                q.add(new int[]{num-1,  depth+1});
            }
            if(num*2<100001 && !visit[num*2]){
                visit[num*2]=true;
                q.add(new int[]{num*2,  depth+1});
            }
        }
        bw.flush();
        bw.close();
    }
}