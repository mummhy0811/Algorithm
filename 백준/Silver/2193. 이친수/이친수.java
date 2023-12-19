import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n+1];

        arr[0]=0;
        if(n>=1) arr[1]=1;

        for(int i=2;i<=n;i++) arr[i]=arr[i-1]+arr[i-2];

        bw.write(arr[n]+"");
        bw.flush();
        bw.close();
    }
}