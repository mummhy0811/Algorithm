import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        map = new int[101];

        Arrays.fill(map, 1);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int total = N+M;

        for(int i=0;i<total;i++){
            st  = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x] = y-x;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});

        while(!queue.isEmpty()){
            int[] q = queue.poll();
            int idx = q[0];
            int move = q[1];

            for(int i=1;i<=6;i++){
                int next = idx+i;
                if(next==100){
                    System.out.println((move+1));
                    return;
                }else if(next<100){
                    next = slide(next);
                    if(map[next]!=-1){
                        queue.add(new int[]{next, move+1});
                        map[next] = -1;
                    }
                }
            }
        }
    }

    private static int slide(int idx){
        int n = map[idx];
        if((n!=1 && n!=-1) && (n+idx<=100)){
            idx = slide(map[idx]+idx);
        }
        return idx;
    }
}