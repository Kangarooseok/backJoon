import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static ArrayList<ArrayList<Integer>> graph;
    static int[] check;
    static int count;

    public static void dfs(int v) {
        check[v] = count;

        for (int newV : graph.get(v)) {
            if (check[newV] == 0) {
                count++;
                dfs(newV);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(bf.readLine());
        int v = Integer.parseInt(st.nextToken()); // 정점 수
        int e = Integer.parseInt(st.nextToken()); // 간선 수
        int r = Integer.parseInt(st.nextToken()); // 시작 정점

        check = new int[v + 1];
        graph = new ArrayList<>(v + 1);

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for (int i = 1; i <= v; i++) {
            Collections.sort(graph.get(i));
        }

        count = 1;

        dfs(r);

        for (int i = 1; i < check.length; i++) {
            sb.append(check[i]).append("\n");
        }

        System.out.println(sb);
    }
}
