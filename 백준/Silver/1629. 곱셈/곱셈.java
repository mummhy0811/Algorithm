import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(calc(a, b, c));
    }

    private static long calc(int a, int b, int mod) {
        if (b == 0) return 1;

        long n = calc(a, b / 2, mod);

        return b%2 == 0? n * n % mod : (n * n % mod) * a % mod;
    }
}