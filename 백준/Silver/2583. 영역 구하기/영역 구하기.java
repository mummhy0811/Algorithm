import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] arr, visit;
    static int[] mX = {0, 1, 0, -1}, mY={1, 0, -1, 0};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new boolean[M][N];
        visit = new boolean[M][N];

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int w = x2-x1;
            int h = y2-y1;

            for(int j=0;j<w;j++){
                for(int k=0;k<h;k++){
                    arr[y1+k][x1+j]=true;
                }
            }

        }

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(!visit[i][j] && !arr[i][j]){
                    list.add(find(i, j));
                }
            }
        }

        Collections.sort(list);
        bw.write(list.size()+"\n");
        for(Integer n:list){
            bw.write(n+" ");
        }
        bw.flush();
        bw.close();

    }

    private static int find(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visit[x][y]=true;
        int area=1;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i=0;i<4;i++){
                int newX = now[0]+mX[i];
                int newY = now[1]+mY[i];
                if(newX<0 || newY<0 || newX>=M || newY>=N || arr[newX][newY] ||visit[newX][newY]) continue;

                queue.add(new int[]{newX, newY});
                area++;
                visit[newX][newY]=true;

            }
        }

        return area;
    }
}