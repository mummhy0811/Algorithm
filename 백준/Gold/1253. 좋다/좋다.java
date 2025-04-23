import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int cnt = 0;
        for(int i=0;i<N;i++) if(isGood(i)) cnt++;

        System.out.println(cnt);
    }

    static boolean isGood(int target){

        int l = 0, r = N-1;

        while(l<r){
            if(l == target) l++;
            else if(r == target) r--;

            if(l==r) break;

            int sum = arr[l]+arr[r];
            if(sum == arr[target]) return true;
            else if(sum < arr[target]) l++;
            else r--;
        }

        return false;
    }
}