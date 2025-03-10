import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] increase = new int[n];
        int[] decrease = new int[n];

        StringTokenizer st  = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            increase[i] = 1;
            decrease[i] = 1;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    increase[i] = Math.max(increase[i], increase[j]+1);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    decrease[i] = Math.max(decrease[i], decrease[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, increase[i] + decrease[i] - 1); // i가 두 번 카운팅 되지 않게 -1
        }
        System.out.println(max);
    }
}