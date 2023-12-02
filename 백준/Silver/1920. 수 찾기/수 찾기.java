import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        double max = Math.pow(2, 31);
        double least =max*(-1);

        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] find = new int[m];
        for(int i=0;i<m;i++){
            find[i]=Integer.parseInt(st.nextToken());
            least = Math.min(least, find[i]);
            max = Math.max(max, find[i]);
        }

        for(int i=0;i<m;i++){
            int f = find[i];
            if(f<least || f>max) {
                bw.write("0\n");
                break;
            }
            int l=0, r=n-1, mid;
            while(l<=r && r<n){
                mid=(l+r)/2;
                if(a[mid]==f){
                    bw.write("1\n");
                    break;
                }else if(a[mid]>f){
                    r=mid-1;
                }else if(a[mid]<f){
                    l=mid+1;
                }
            }
            if(l>r) bw.write("0\n");
        }

        bw.flush();
        bw.close();
    }
}