import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[] visit = new boolean[n+1];
        List<List<Integer>> list = new ArrayList<>(n+1);
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        StringTokenizer st;
        for(int i=0;i<m;i++){
             st = new StringTokenizer(br.readLine());
             int a = Integer.parseInt(st.nextToken());
             int b = Integer.parseInt(st.nextToken());
             list.get(a).add(b);
             list.get(b).add(a);
        }

        int ans=0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,0});
        visit[1]=true;
        while(!q.isEmpty()){
            int[] nowArr = q.poll();
            int now = nowArr[0];
            int depth = nowArr[1];

            if(depth>=2) break;

            for(int i=0;i<list.get(now).size();i++){
                int target=list.get(now).get(i);
                if(!visit[target]){
                    visit[target]=true;
                    q.add(new int[]{target,depth+1});
                    ans++;
                }
            }
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
}