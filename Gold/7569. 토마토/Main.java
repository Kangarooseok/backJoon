import java.io.*;
import java.util.*;

public class Main {

    static int inputX, inputY, inputZ;
    static int[][][] arr;
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<Point> qu = new LinkedList<>();

    static class Point {
        int x, y, z;

        Point(int z, int x, int y) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        inputY = Integer.parseInt(str[0]);
        inputX = Integer.parseInt(str[1]);
        inputZ = Integer.parseInt(str[2]);

        arr = new int[inputZ][inputX][inputY];

        for (int k = 0; k < inputZ; k++) {
            for (int i = 0; i < inputX; i++) {
                String[] str1 = br.readLine().split(" ");
                for (int j = 0; j < inputY; j++) {
                    arr[k][i][j] = Integer.parseInt(str1[j]);
                }
            }
        }

        for (int k = 0; k < inputZ; k++) {
            for (int i = 0; i < inputX; i++) {
                for (int j = 0; j < inputY; j++) {
                    if (arr[k][i][j] == 1) {
                        qu.add(new Point(k, i, j));
                    }
                }
            }
        }

        bfs();
        checkTomato();
    }

    static void bfs() {
        while (!qu.isEmpty()) {
            Point tmp = qu.poll();
            int tz = tmp.z;
            int tx = tmp.x;
            int ty = tmp.y;

            for (int i = 0; i < 6; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                int nz = tz + dz[i];

                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < inputX && ny < inputY && nz < inputZ) {
                    if (arr[nz][nx][ny] == 0) {
                        qu.add(new Point(nz, nx, ny));
                        arr[nz][nx][ny] = arr[tz][tx][ty] + 1;
                    }
                }
            }
        }
    }

    static void checkTomato() {
        int days = 0;
        boolean allRipe = true;

        for (int k = 0; k < inputZ; k++) {
            for (int i = 0; i < inputX; i++) {
                for (int j = 0; j < inputY; j++) {
                    if (arr[k][i][j] == 0) {
                        allRipe = false;
                    }
                    days = Math.max(days, arr[k][i][j]);
                }
            }
        }

        if (!allRipe) {
            System.out.println(-1);
        } else {
            System.out.println(days - 1);
        }
    }
}
