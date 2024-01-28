import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int paper[] ={0, 0};
    public static int arr[][];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) arr[i][j]=Integer.parseInt(st.nextToken());
        }
        checkBox(n, 0, 0);
        bw.write(paper[0]+"\n"+paper[1]);
        bw.flush();
    }
    private static void checkBox(int size, int x, int y){
        if(sameColor(size, x, y)) {
            paper[arr[x][y]]++;
            return;
        }
        int new_size=size/2;
        checkBox(new_size, x, y);
        checkBox(new_size, x+new_size, y+new_size);
        checkBox(new_size, x+new_size, y);
        checkBox(new_size, x, y+new_size);
    }
    private static boolean sameColor(int size,int x, int y){
        int first = arr[x][y];
        for(int i=x;i<x + size;i++){
            for(int j=y;j<y+size;j++){
                if(first!=arr[i][j]) return false;
            }
        }
        return true;
    }
}