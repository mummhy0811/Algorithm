import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<Integer> ranklist = new ArrayList<>();

        if (N == 0) {
            System.out.println("1");
            return;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ranklist.add(Integer.parseInt(st.nextToken()));
        }

        int rank = 1;
        // 랭킹 리스트가 꽉 차있고, 입력값이 최하위와 같거나 그보다 작음
        if(ranklist.size() >= P && score <= ranklist.get(ranklist.size()-1)) {
            System.out.println(-1);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(score >= ranklist.get(i)) {
                rank = i + 1;
                break;
            }else {
                rank++;
            }
        }

        if(rank <= P) System.out.println(rank);
        else System.out.println(-1);

    }
}