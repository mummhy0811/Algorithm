import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] v = new int[n];

        int num=1;
        long max=0;

        st = new StringTokenizer(br.readLine());

        for (int i=0;i<n;i++) v[i]= Integer.parseInt(st.nextToken());

        for(int i=0;i<x;i++) {
            max+=v[i];
        }
        long sum=max;
        for(int i=0;i<n-x;i++){
            sum=sum-v[i]+v[i+x];
            if(sum>max){
                max=sum;
                num=1;
            } else if (sum == max) {
                num++;
            }
        }

        if(max==0) bw.write("SAD");
        else bw.write(max+"\n"+num);

        bw.flush();
        bw.close();
    }
}