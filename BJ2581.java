import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();
        int N = scanner.nextInt();

        int sum = 0;
        int min = 0;

        int[] prime = new int[10001];

        for (int i = 3; i < 10001; i++) {
            prime[i] = i;

            if (i % 2 == 0)
                prime[i] = 0;
        }

        prime[2] = 2;
        prime[1] = 0;

        int i = 2;
        while (true) {
            i += 1;

            if (i % 2 == 0)
                continue;

            if (i > Math.sqrt(N) + 1)
                break;

            int k = 2;

            while (i * k <= N) {
                prime[k * i] = 0;
                k = k + 1;
            }
        }

        for (int j = M; j <= N; j++) {
            if (prime[j] != 0) {
                if (sum == 0) {
                    min = j;
                }

                sum = sum + j;
            }
        }

        if (sum == 0)
            System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }

        scanner.close();
    }
}
