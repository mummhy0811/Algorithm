import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] price = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            price[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=n;i++){
            for(int j=2;i*j<=n;j++){
                price[i*j] = Math.max(price[i*j], price[i]*j);
            }
        }
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i/2;j++){
                price[i] = Math.max(price[i], price[j]+price[i-j]);
            }
        }
        System.out.println(price[n]);
    }
}