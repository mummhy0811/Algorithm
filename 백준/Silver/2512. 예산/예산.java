import java.io.*;
import java.util.*;

public class Main {
    public static List<Integer> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new ArrayList<>(n);
        int sum=0;
        for(int i=0;i<n;i++) {
            arr.add(Integer.parseInt(st.nextToken()));
            sum+=arr.get(i);
        }
        Collections.sort(arr);

        int m = Integer.parseInt(br.readLine());
        if(sum>m){
            int start=0, end=arr.get(n-1);
            while(start<=end){
                int mid = (start+end)/2;
                if(calc(mid)<=m){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
            bw.write(end+"");
        }else {
            bw.write(arr.get(n-1)+"");
        }
        bw.flush();
        bw.close();
    }

    private static int calc(int max) {
        int sum=0;
        for(int i:arr){
            sum += Math.min(i, max);
        }
        return sum;
    }
}