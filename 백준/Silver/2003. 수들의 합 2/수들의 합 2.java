import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        int[] arr = new int[n];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;st2.hasMoreTokens();i++){
            arr[i]=Integer.parseInt(st2.nextToken());
        }

        int count=0, start=0, end=0, sum=0;

        while (true){
            if(sum>m){
                sum-=arr[start++];
            }else if(end==n)break;
            else{
                sum+=arr[end++];
            }
            if(sum==m) count++;
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
    }
}