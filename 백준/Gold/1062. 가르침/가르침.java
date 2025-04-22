import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int cnt = 0;

    static List<Character> remainChars;
    static int[] wordMasks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(K<5){
            System.out.println("0");
            return;
        }

        // 단어 비트마스크 배열
        wordMasks = new int[N];

        // 기본적으로 알아야 할 알파벳 (a, n, t, i, c)
        int baseMask = 0;
        for (char ch : "antic".toCharArray()) {
            baseMask |= (1 << (ch - 'a'));
        }

        // 입력 받은 단어를 비트마스크로 변환
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            int mask = 0;
            for (char ch : word.toCharArray()) {
                mask |= (1 << (ch - 'a'));
            }
            wordMasks[i] = mask;
        }

        // 사용 가능한 나머지 알파벳 목록 생성 (a~z에서 antic 제거)
        remainChars = new ArrayList<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if ("antic".indexOf(ch) == -1) {
                remainChars.add(ch);
            }
        }

        find(0, 0, baseMask);

        System.out.println(cnt);
    }

    private static void find(int index, int depth, int learnedMask){
        if(depth == K - 5){
            int readable = 0;
            for (int mask : wordMasks) {
                if ((mask & ~learnedMask) == 0) {
                    readable++;
                }
            }
            cnt = Math.max(cnt, readable);
            return;
        }

        for (int i = index; i < remainChars.size(); i++) {
            char ch = remainChars.get(i);
            find(i + 1, depth + 1, learnedMask | (1 << (ch - 'a')));
        }
    }
}