import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class Main {
    static char[][] arr;
    static boolean[][] visit;
    static int n, can, cannot;

    static int[] x = {0, 1, 0, -1};
    static int[] y = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        visit = new boolean[n][n];
        arr = new char[n][n];
        for(int i=0;i<n;i++){
            arr[i]=br.readLine().toCharArray();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j]) {
                    find(i, j);
                    cannot++;
                }
            }
        }
        bw.write(can+" "+cannot);
        bw.flush();
        bw.close();
    }
    private static void find(int xx, int yy){
        can++;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{xx, yy});

        Set<int[]> close = new HashSet<>();
        while(!queue.isEmpty()){
            int[] nowArr = queue.poll();
            int nowX = nowArr[0];
            int nowY = nowArr[1];
            visit[nowX][nowY]=true;

            for(int j=0;j<4;j++){
                int newX = nowX+x[j];
                int newY = nowY+y[j];

                if(newX>=n || newY>=n || newX<0 || newY<0 || visit[newX][newY]) continue;

                if(arr[nowX][nowY]==arr[newX][newY]){
                    visit[newX][newY]=true;
                    queue.add(new int[]{newX, newY});
                }

                if((arr[nowX][nowY]=='R' && arr[newX][newY]=='G') || (arr[nowX][nowY]=='G' && arr[newX][newY]=='R')){
                    close.add(new int[]{newX, newY});
                }
            }
        }
        for(int[] arr:close){
            int n1=arr[0];
            int n2=arr[1];
            if(!visit[n1][n2])find(arr[0], arr[1]);
        }
    }
}
