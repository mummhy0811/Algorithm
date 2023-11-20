import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        long min;
        
        if(s<=w){
            long left =  Math.abs(x - y);
            min= (long) Math.min(x, y) *s +  (left / 2) * s * 2 + (left%2) *w;
        } else if (s<=2*w){
            min= (long) Math.min(x, y) *s +  (long) (Math.abs(x - y)) *w;
        }else{
            min = (long) w *(x+y);
        }

        bw.write(min+"");
        bw.flush();
        bw.close();
    }
}