import java.io.*;
import java.util.*;

public class Main {

    private static final int NORTH = 1, EAST = 2, SOUTH = 3, WEST = 4;
    private static int x;
    private static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            char[] commands = br.readLine().toCharArray();

            x = 0; y = 0;
            int dir = NORTH;
            int maxX = 0, maxY = 0, minX = 0, minY = 0;

            for (char c : commands) {
                switch (c) {
                    case 'F' -> moveForward(dir);
                    case 'B' -> moveBackward(dir);
                    case 'L' -> dir = (dir == NORTH ? WEST : dir - 1);
                    case 'R' -> dir = (dir == WEST ? NORTH : dir + 1);
                }

                maxX = Math.max(maxX, x);
                minX = Math.min(minX, x);
                maxY = Math.max(maxY, y);
                minY = Math.min(minY, y);
            }
            System.out.println((maxX - minX) * (maxY - minY));
        }
    }
    private static void moveForward(int dir) {
        if (dir == NORTH) y++;
        else if (dir == EAST) x++;
        else if (dir == SOUTH) y--;
        else x--;
    }

    private static void moveBackward(int dir) {
        if (dir == NORTH) y--;
        else if (dir == EAST) x--;
        else if (dir == SOUTH) y++;
        else x++;
    }
}