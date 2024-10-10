import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i]=Integer.parseInt(br.readLine());
        bw.write(run(N, arr)+"");
        bw.flush();
        bw.close();
    }
    public static int run(int N, int[] arr){
        int ans=arr[0];
        int[] max = new int[N];
        max[0] = arr[0];

        for(int i=1;i<N;i++){
            int tmp1 = arr[i]+arr[i-1];
            if(i-3>=0) tmp1+=max[i-3];

            int tmp2 = arr[i];
            if(i-2>=0) tmp2+=max[i-2];

            max[i] = Math.max(tmp1, tmp2);
            max[i] = Math.max(ans, max[i]);
            ans = Math.max(ans, max[i]);
        }

        return ans;
    }
}