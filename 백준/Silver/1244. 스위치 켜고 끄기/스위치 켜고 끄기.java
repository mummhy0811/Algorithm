import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int student_num = Integer.parseInt(br.readLine());
        for(int i=0;i<student_num;i++){
            st = new StringTokenizer(br.readLine());
            if(st.nextToken().equals("1")){
                boy(Integer.parseInt(st.nextToken()));
            }else{
                girl(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i=1;i<arr.length;i++){

            bw.write(arr[i]+" ");
            if(i%20==0) bw.write("\n");
        }
        bw.flush();
        bw.close();

    }
    private static void girl(int n){
        arr[n]=arr[n]==0? 1:0;
        for(int i=1;i<=n;i++){
            if(n-i<=0 || n+i>=arr.length) return;
            if(arr[n-i]==arr[n+i]){
                arr[n-i]=arr[n-i]==0? 1:0;
                arr[n+i]=arr[n+i]==0? 1:0;
            }else{
                return;
            }
        }
    }
    private static void boy(int n){
        for(int i=n;i<arr.length;i+=n){
            arr[i]=arr[i]==0? 1:0;
        }

    }
}