import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int max = 0;

        // 행, 열에서 가장 긴 연속 부분 체크 함수
        max = Math.max(max, findMax(board, N));

        // 인접한 사탕을 교환한 후 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                // 가로로 교환
                swap(board, i, j, i, j + 1);
                max = Math.max(max, findMax(board, N));
                swap(board, i, j, i, j + 1); // 다시 원상복구

                // 세로로 교환
                swap(board, j, i, j + 1, i);
                max = Math.max(max, findMax(board, N));
                swap(board, j, i, j + 1, i); // 다시 원상복구
            }
        }

        System.out.println(max);
    }

    // 보드에서 가장 긴 연속 부분을 찾는 함수
    public static int findMax(char[][] board, int N) {
        int maxLen = 1;

        // 행에서 가장 긴 연속 부분 찾기
        for (int i = 0; i < N; i++) {
            int rowLen = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    rowLen++;
                    maxLen = Math.max(maxLen, rowLen);
                } else {
                    rowLen = 1;
                }
            }
        }

        // 열에서 가장 긴 연속 부분 찾기
        for (int i = 0; i < N; i++) {
            int colLen = 1;
            for (int j = 1; j < N; j++) {
                if (board[j][i] == board[j - 1][i]) {
                    colLen++;
                    maxLen = Math.max(maxLen, colLen);
                } else {
                    colLen = 1;
                }
            }
        }

        return maxLen;
    }

    // 두 사탕을 교환하는 함수
    public static void swap(char[][] board, int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }
}
