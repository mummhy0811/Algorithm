import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=1;i<=N;i++){
            map.put(i, new ArrayList<>());
        }
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            List<Integer> list1 = map.get(n1);
            list1.add(n2);
            map.put(n1, list1);

            list1 = map.get(n2);
            list1.add(n1);
            map.put(n2, list1);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] par = new int[N+1];

        List<Integer> child = map.get(1);
        for(int c:child){
            queue.add(c);
            par[c]=1;
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            child = map.get(now);

            for(int c:child){
                if(par[c]==0){
                    queue.add(c);
                    par[c]=now;
                }
            }
        }

        for(int i=2;i<=N;i++){
            bw.write(par[i]+"\n");
        }

        bw.flush();
        bw.close();
    }
}