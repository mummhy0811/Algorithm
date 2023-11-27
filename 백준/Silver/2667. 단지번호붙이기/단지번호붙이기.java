import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

class Main {

    static int n;
    static int[][]arr;
    static boolean[][] visit;
    static final int[]move_x={0, 0, -1, 1};
    static final int[]move_y={-1, 1, 0, 0};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n][n];

        for(int i=0;i<n;i++){
            String s =br.readLine();
            for(int j=0;j<n;j++){
                arr[i][j]=s.charAt(j)-'0';
            }
        }

        List<Integer> vil = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j] && arr[i][j]==1){
                    vil.add(bfs(i, j));
                }
            }
        }

        vil = vil.stream().sorted().collect(Collectors.toList());
        bw.write(vil.size()+"\n");
        for(int s:vil)
            bw.write(s+"\n");
        bw.flush();
        bw.close();
    }
    private static int bfs(int xx, int yy){

        int size=0;
        int[]now = new int[]{xx, yy};

        visit[xx][yy] =true;
        q.add(now);
        size++;

        while(!q.isEmpty()){
            now = q.poll();

            int x=now[0];
            int y=now[1];

            for(int i=0;i<4;i++){
                int new_x=x+move_x[i];
                int new_y=y+move_y[i];

                if(new_x<0 || new_x>n-1 || new_y<0 || new_y>n-1 || visit[new_x][new_y]) continue;
                if(arr[new_x][new_y]==1) {
                    q.add(new int[]{new_x,new_y });
                    size++;
                }
                visit[new_x][new_y]=true;
            }
        }
        return size;
    }
}