import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

        int l = 0, r = N-1;
        int min = Integer.MAX_VALUE;
        int ans1 = l, ans2 = r;
        while(l<r){
            int sum = arr[l]+arr[r];
            if(Math.abs(sum)<min){
                min = Math.abs(sum);
                ans1 = l;
                ans2 = r;
            }
            if(sum==0) break;
            else if(sum>0) r--;
            else l++;
        }
        System.out.println(arr[ans1]+" "+arr[ans2]);
    }
}