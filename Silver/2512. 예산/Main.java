import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Main2 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer> money = new ArrayList<>();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bf.readLine()); // 예산 항목 수 입력
        st = new StringTokenizer(bf.readLine()); // 예산 항목 입력
        int left = 0, right = 0;

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            money.add(value); // ArrayList에 값 추가
            right = Math.max(right, value); // 최대값 설정
        }

        int last = Integer.parseInt(bf.readLine()); // 총 예산 입력
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long budget = 0;

            for (int i = 0; i < n; i++) {
                if (money.get(i) > mid) {
                    budget += mid;
                } else {
                    budget += money.get(i);
                }
            }

            if (budget > last) {
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}