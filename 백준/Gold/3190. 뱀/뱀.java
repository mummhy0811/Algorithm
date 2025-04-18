import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            board[r][c] = 1; // 사과
        }

        board[0][0] = 2; // 뱀

        int L = Integer.parseInt(br.readLine());
        String[][] directions = new String[L][2];
        for(int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine());
            directions[i][0] = st.nextToken();
            directions[i][1] = st.nextToken();
        }

        int r = 0, c = 0;
        int time = 0, idx = 0;
        int nextTime = Integer.parseInt(directions[0][0]);
        int forward = 1;//0, 1, 2, 3 북 동 남 서

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        
        while(true){
            time++;

            // 머리 이동
            if(forward == 0) r--;
            else if(forward == 1) c++;
            else if(forward == 2) r++;
            else c--;

            //게임 끝 체크
            if(r == N || c == N || r<0 || c<0||board[r][c] == 2 ) break;

            //사과 체크
            if(board[r][c]!=1){
                int[] pos = queue.poll();
                board[pos[0]][pos[1]] = 0;
            }

            board[r][c] = 2;
            queue.add(new int[]{r,c});

            if(time == nextTime){
                if(idx+1<L) nextTime = Integer.parseInt(directions[idx+1][0]);
                if(directions[idx][1].equals("L")){ // 왼
                    forward--;
                    if(forward<0) forward = 3;
                }else{ // 오
                    forward++;
                    if(forward>3) forward = 0;
                }
                idx++;
            }
        }
        System.out.println(time);
    }
}