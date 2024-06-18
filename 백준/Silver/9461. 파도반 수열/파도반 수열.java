import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] num=new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            int target=Integer.parseInt(br.readLine());
            num[i]=target;
            max=Math.max(max, target);
        }

        long[] arr = new long[101];
        arr[1]=1;
        arr[2]=1;
        arr[3]=1;

        for(int i=4;i<=max;i++){
            arr[i]=arr[i-2]+arr[i-3];
        }
        for(int i=0;i<n;i++){
            bw.write(arr[num[i]]+"\n");
        }

        bw.flush();
        bw.close();
    }
}