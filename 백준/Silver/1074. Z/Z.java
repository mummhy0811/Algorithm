import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size= (int) Math.pow(2, n);
        find(0, 0, size, 0);
    }
    static void find(int x, int y, int len, int sNum){
        if(x>r || r>x+len || y>c || c>y+len){//내 범위 밖이면 탐색X
            return;
        }
        if(x==r && y==c) {
            System.out.println(sNum);
            return;
        }
        int newLen=len/2;
        find(x, y, newLen, sNum);
        find(x, y+newLen, newLen,sNum+newLen*newLen);
        find(x+newLen, y, newLen,sNum+newLen*newLen*2);
        find(x+newLen, y+newLen, newLen,sNum+newLen*newLen*3);
    }
}