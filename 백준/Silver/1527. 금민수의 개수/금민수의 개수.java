import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long a, b, n;
    public static void find(long number) {
        if (number > b) return;
        if (number >= a) n += 1;

        find(number * 10 + 4);
        find(number * 10 + 7);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        find(4);
        find(7);
        System.out.println(n);
    }
}
