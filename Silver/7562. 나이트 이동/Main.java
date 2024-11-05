import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] moves = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
    };

    public static String bfs(int line, int[] start, int[] end) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[line][line];
        queue.add(start);
        visited[start[0]][start[1]] = true;
        int distance = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                if (x == end[0] && y == end[1]) {
                    return distance+"\n";
                }

                for (int[] move : moves) {
                    int newX = x + move[0];
                    int newY = y + move[1];

                    if ((newX >= 0 && newX < line) && (newY >= 0 && newY < line) && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
            distance ++;
        }
        return "-1";
    }

    public static void main(String[] args) throws IOException {
        String answer = "";
        int N = Integer.parseInt(bf.readLine());

        for(int i = 0; i < N; i++) {
            int line = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(bf.readLine());
            int[] end = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            answer += bfs(line, start, end);
        }
        System.out.println(answer);
    }
}