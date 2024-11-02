import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] treeHeights;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int numberOfTrees = Integer.parseInt(tokenizer.nextToken());
        int requiredLength = Integer.parseInt(tokenizer.nextToken());

        treeHeights = new int[numberOfTrees];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < numberOfTrees; i++) {
            treeHeights[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int lowerBound = 0;
        int upperBound = getMaxHeight(treeHeights);
        int optimalHeight = 0;

        while (lowerBound <= upperBound) {
            int currentHeight = (lowerBound + upperBound) / 2;
            long collectedLength = calculateCollectedLength(currentHeight);

            if (collectedLength < requiredLength) {
                upperBound = currentHeight - 1;
            } else {
                optimalHeight = currentHeight;
                lowerBound = currentHeight + 1;
            }
        }
        System.out.println(optimalHeight);
    }

    public static long calculateCollectedLength(int height) {
        long totalLength = 0;
        for (int treeHeight : treeHeights) {
            totalLength += Math.max(treeHeight - height, 0);
        }
        return totalLength;
    }

    public static int getMaxHeight(int[] heights) {
        int maxHeight = 0;
        for (int height : heights) {
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        return maxHeight;
    }
}
