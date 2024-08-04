import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;
        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int homeX = Integer.parseInt(st.nextToken());
            int homeY = Integer.parseInt(st.nextToken());

            List<int[]> store = new ArrayList<>(n);
            for(int j=0;j<n+1;j++){
                st = new StringTokenizer(br.readLine());
                store.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }

            if(canGo(homeX, homeY, store.get(n)[0], store.get(n)[1])) bw.write("happy\n");
            else find(homeX, homeY, store, store.get(n)[0], store.get(n)[1]);
        }

        bw.flush();
        bw.close();
    }

    private static void find(int homeX, int homeY, List<int[]> store, int fesX, int fesY) throws IOException{
        boolean[] visit = new boolean[store.size()];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{homeX, homeY});

        int[] now = queue.poll();
        int nowX = now[0];
        int nowY = now[1];

        for(int i=0;i<store.size();i++){
            if(canGo(nowX, nowY, store.get(i)[0], store.get(i)[1])){
                queue.add(new int[]{store.get(i)[0], store.get(i)[1]});
                visit[i]=true;
            }
        }

        while(!queue.isEmpty()){
            now = queue.poll();
            nowX = now[0];
            nowY = now[1];

            if(canGo(nowX, nowY, fesX, fesY)){
                bw.write("happy\n");
                return;
            }else{
                for(int i=0;i<store.size();i++){
                    if(!visit[i] && canGo(nowX, nowY, store.get(i)[0], store.get(i)[1])){
                        queue.add(new int[]{store.get(i)[0], store.get(i)[1]});
                        visit[i]=true;
                    }
                }
            }
        }
        bw.write("sad\n");
    }

    private static boolean canGo(int x1, int y1, int x2, int y2){
        return (Math.abs(x1-x2)+ Math.abs(y1-y2))<=1000;
    }
}