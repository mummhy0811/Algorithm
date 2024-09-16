import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;
        int N = Integer.parseInt(br.readLine());

        int l=1000, r=0, topPos=0;
        arr = new int[1001];

        //저장
        for(int i=0;i<N;i++){
//            System.out.println(topPos);
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            l=Math.min(l, p);
            r=Math.max(r, p);

//            System.out.println(topPos+" "+arr[topPos]+" "+p);
            if(arr[topPos]<h ){
                topPos=p;
            }else if(arr[topPos]==h && topPos<p){
                topPos=p;
            }
            arr[p]=h;
        }

//        System.out.println("top pos "+topPos);
        int sum=0;
        int idx=l;
        for(int i=l+1;i<=topPos;i++){
            if(arr[i]==0) continue;
            if(arr[i]>=arr[idx]){
                sum+=calc(idx, i, true);
                idx=i;
            }

        }
        idx=r;
//        System.out.println("!!!!!!!!!!!!!111");
        for(int i=r;i>=topPos;i--){
            if(arr[i]==0) continue;
            if(arr[idx]<arr[i]){
                sum+=calc(i+1, idx+1, false);
                idx=i;
            }
        }

        sum+=calc(topPos, topPos+1, true);

        bw.write(sum+"");
        bw.flush();
        bw.close();
    }
    private static int calc(int l, int r, boolean isLeft){

        if(isLeft) {
//            System.out.println(l+" "+r+" "+(r-l)*arr[l]);
            return (r-l)*arr[l];
        }
//        System.out.println(l+" "+r+" "+(r-l)*arr[r-1]);
        return (r-l)*arr[r-1];
    }
}