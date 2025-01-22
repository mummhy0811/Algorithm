import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static List<int[]> emptySpaces = new ArrayList<>();
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static int N, M, maxSafeArea = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                arr[i][j] = n;
                if (n == 0) emptySpaces.add(new int[]{i, j});
            }
        }

        buildWalls(0, 0, new int[3]);
        System.out.println(maxSafeArea);
    }

    private static void buildWalls(int depth, int start, int[] selected) {
        if (depth == 3) {
            calculateSafeArea(selected);
            return;
        }

        for (int i = start; i < emptySpaces.size(); i++) {
            selected[depth] = i; // 벽 설치할 빈 공간 선택
            buildWalls(depth + 1, i + 1, selected);
        }
    }

    private static void calculateSafeArea(int[] walls) {
        int[][] tempArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            tempArr[i] = arr[i].clone();
        }

        for (int index : walls) {
            int[] pos = emptySpaces.get(index);
            tempArr[pos[0]][pos[1]] = 1;
        }

        int totalSize = N*M;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int n = tempArr[i][j];
                if(n==1) totalSize--;
                else if (n == 2) queue.add(new int[]{i, j});
            }
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            totalSize--;
            for (int i = 0; i < 4; i++) {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && tempArr[nx][ny] == 0) {
                    tempArr[nx][ny] = 2;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        maxSafeArea = Math.max(maxSafeArea, totalSize);
    }
}