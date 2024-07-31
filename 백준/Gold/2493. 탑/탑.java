import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] result = new int[N];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = N - 1; i >= 0; i--) {
            while (!deque.isEmpty() && arr[i] > arr[deque.peek()]) {
                result[deque.pop()] = i + 1;
            }
            deque.push(i);
        }

        for (int i : deque) {
            result[i] = 0;
        }

        bw.write("0 ");
        for (int i = 1; i < N; i++) {
            bw.write(result[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}