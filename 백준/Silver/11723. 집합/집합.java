import java.io.*;
import java.util.*;

public class Main {
    static boolean[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int m = Integer.parseInt(br.readLine());

        arr = new boolean[21];

        while(m-->0){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("all")){
                Arrays.fill(arr, true);
                continue;
            }else if(s.equals("empty")){
                arr = new boolean[m+1];
                continue;
            }

            int n = Integer.parseInt(st.nextToken());
            if(s.equals("add")){
                arr[n]=true;
            }else if(s.equals("check")){
                if(arr[n]){
                    bw.write("1\n");
                }else{
                    bw.write("0\n");
                }
            }else if(s.equals("remove")){
                arr[n]=false;
            }else if(s.equals("toggle")){
                arr[n]= !arr[n];
            }
        }
        bw.flush();
        bw.close();
    }
}