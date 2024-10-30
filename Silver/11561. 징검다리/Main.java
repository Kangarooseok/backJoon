import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            long stones = scanner.nextLong();
            long low = 0;
            long high = (long) Math.sqrt(2 * stones) + 1;
            long maxJump = 0;

            while (low <= high) {
                long mid = (low + high) / 2;
                long total = mid * (mid + 1) / 2;

                if (total <= stones) {
                    maxJump = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            System.out.println(maxJump);
        }

        scanner.close();
    }
}