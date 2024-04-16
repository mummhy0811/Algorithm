import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int m, n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); //조카
        n = Integer.parseInt(st.nextToken()); //과자
        arr = new int[n];//과자의 길이

        st = new StringTokenizer(br.readLine());
        
        int max=0;
        for(int i=0;i<n;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
            max=Math.max(max, arr[i]);
        }
        
        int l=1, r=max;

        while(l<=r){
            int mid=(l+r)/2;
            if(calcGiven(mid)<m){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        bw.write(r+"");
        bw.flush();
        bw.close();
    }
    static int calcGiven(int mid){
        int given=0;
        for(int i=0;i<n;i++){
            if(arr[i]>=mid) given=given+arr[i]/mid;
        }
        return given;
    }
}