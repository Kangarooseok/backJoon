import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main2 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<ArrayList<Integer>> arry = new ArrayList<>();
    static int result;

    public static void dfs(int count, int from, int to) {
        if (from == to) {
            result = count;
            return;
        }

        check[from] = 1;

        for (int next : arry.get(from)) {
            if (check[next] == 0) {
                dfs(count + 1, next, to);
                if (result != -1) {
                    return;
                }
            }
        }

        check[from] = 0;
    }

    static int[] check;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(bf.readLine());

        for (int i = 0; i <= N; i++) {
            arry.add(new ArrayList<>());
        }

        for (int i = 0; i < length; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arry.get(u).add(v);
            arry.get(v).add(u);
        }

        check = new int[N + 1];
        result = -1;
        dfs(0, from, to);

        System.out.println(result);
    }
}
