import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] lines;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static HashSet<Integer> fans = new HashSet<>();
    static boolean[] visited;
    static boolean foundPathWithoutFans;

    public static void dfs(int node) {
        if (visited[node] || foundPathWithoutFans) return;
        visited[node] = true;

        if (fans.contains(node)) {
            return;
        }

        if (lines[node].isEmpty()) {
            foundPathWithoutFans = true;
            return;
        }

        for (int nextNode : lines[node]) {
            dfs(nextNode);
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        lines = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            lines[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            lines[from].add(to);
        }

        int fanN = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for (int j = 0; j < fanN; j++) {
            fans.add(Integer.parseInt(st.nextToken()));
        }

        foundPathWithoutFans = false;
        dfs(1);

        if (foundPathWithoutFans) {
            System.out.println("yes");
        } else {
            System.out.println("Yes");
        }
    }
}
