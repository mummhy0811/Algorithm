import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); //조카
        int n = Integer.parseInt(st.nextToken()); //과자

        int[] arr = new int[n];//과자의 길이

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) arr[i]=Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int l=1, r=arr[n-1];

        while(l<=r){
            int mid=(l+r)/2;
            int given=0;
            for(int i=0;i<n;i++){
                if(arr[i]>=mid) given=given+arr[i]/mid;
            }
            if(given<m){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        bw.write(r+"");
        bw.flush();
        bw.close();
    }
}