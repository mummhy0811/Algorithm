import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] sour = new int[N];
        int[] bitter = new int[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int mask=1;mask < (1 << N);mask++){

            int s = 1, b = 0;

            for(int i = 0 ;i<N;i++){
                if ((mask & (1 << i)) != 0){
                    s*=sour[i];
                    b+=bitter[i];
                }
            }
            
            min = Math.min(min, Math.abs(s-b));
        }

        System.out.println(min);

    }
}