import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for(int i=0;i<n;i++){
            arr[i]=br.readLine().toCharArray();
        }
        //상하좌우
        int[]move_x={0, 0, -1, 1};
        int[]move_y={-1, 1, 0, 0};

        boolean[][] visit = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();

        int size=0;
        List<Integer> vil = new ArrayList<>();

        while(true){
            int[]now;
            if(q.isEmpty()){
                if(size!=0){
                    vil.add(size);
                    size=0;
                }
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if(!visit[i][j] && Integer.parseInt(String.valueOf(arr[i][j]))==1){
                            now=new int[]{i, j};
                            visit[i][j] =true;
                            q.add(now);
                            size++;
                            break;
                        }
                    }
                    if(!q.isEmpty())break;
                }
                if(q.isEmpty()) break;
            }
            now = q.poll();

            int x=now[0];
            int y=now[1];
            //상하좌우
            for(int i=0;i<4;i++){
                int new_x=x+move_x[i];
                int new_y=y+move_y[i];
                if(new_x<0 || new_x>n-1 || new_y<0 || new_y>n-1 || visit[new_x][new_y])
                    continue;
                if(Integer.parseInt(String.valueOf(arr[new_x][new_y]))==1) {
                    q.add(new int[]{new_x,new_y });
                    size++;
                }
                visit[new_x][new_y]=true;
            }
        }

        vil = vil.stream().sorted().collect(Collectors.toList());
        bw.write(vil.size()+"\n");
        for(int s:vil)
            bw.write(s+"\n");
        bw.flush();
        bw.close();
    }
}