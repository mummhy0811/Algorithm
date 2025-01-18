import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visit;
    static Queue<Integer> nums;
    static Queue<String> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            visit = new boolean[10000];

            bw.write(find(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        bw.flush();
        bw.close();
    }

    private static String find(int a, int b){
        StringBuilder sb = new StringBuilder();
        nums = new LinkedList<>();
        queue = new LinkedList<>();

        visit[a] = true;
        nums.add(a);
        queue.add("");

        int next;
        while(!nums.isEmpty()){
            int n = nums.poll();
            String s = queue.poll();

            //D
            next = 2*n%10000;
            if(next==b) return sb.append(s).append("D\n").toString();
            put(next, s, "D");

            //S
            next = (n==0) ? 9999 : n-1;
            if(next==b) return sb.append(s).append("S\n").toString();
            put(next, s, "S");

            //L
            next = n%1000*10 + n/1000;
            if(next==b) return sb.append(s).append("L\n").toString();
            put(next, s, "L");

            //R
            next = ((n%10)*1000) + (n/10);
            if(next==b) return sb.append(s).append("R\n").toString();
            put(next, s, "R");
        }
        return "";
    }

    private static void put(int next, String s, String type){
        if(!visit[next]){
            visit[next] = true;
            nums.add(next);
            queue.add(s+type);
        }
    }
}