import java.io.*;

public class Main {
    public static int[] zero;
    public static int[] one;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        arr = new int[t];

        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        zero = new int[41];
        one = new int[41];

        zero[0] = 1; one[0] = 0;
        zero[1] = 0; one[1] = 1;

        for (int i = 2; i <= 40; i++) {
            zero[i] = zero[i - 1] + zero[i - 2];
            one[i] = one[i - 1] + one[i - 2];
        }
        for(int i:arr){
            bw.write(zero[i] + " " + one[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}