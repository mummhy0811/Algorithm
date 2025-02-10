import java.io.*;

public class Main {
    static int N, ans = 0;

    static boolean[] visitColumn;
    static int[] chosenColumn;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        chosenColumn = new int[N];
        visitColumn = new boolean[N];
        findRow(0);
        System.out.println(ans);
    }

    static void findRow(int depth){
        if(depth == N){
            ans++;
            return;
        }

        for(int i=0;i<N;i++){
            if(!visitColumn[i] && isSafe(depth, i)){
                visitColumn[i] = true;
                chosenColumn[depth] = i;
                findRow(depth+1);
                visitColumn[i] = false;
            }
        }
    }

    static boolean isSafe(int row, int col){
        for(int i=0;i<row;i++){
            if(Math.abs(row-i) == Math.abs(col-chosenColumn[i])) return false;
        }
        return true;
    }
}