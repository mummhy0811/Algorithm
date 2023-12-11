import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            b[i]=Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(a);
        Arrays.sort(b);

        int s =0;
        for(int i=0;i<n;i++){
            s+=a[n-i-1]*b[i];
        }
        bw.write(s+"");
        bw.flush();
        bw.close();
    }
}