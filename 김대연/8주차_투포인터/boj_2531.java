import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int d = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());

        int[] belt = new int[n];
        for (int i = 0; i < n; i++) {
            belt[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int[] eachTypeCount = new int[d + 1];
        int currentKindCount = 0;

        int start = 0;
        int end = k - 1;

        for (int i = 0; i < k; i++) {
            int sushiType = belt[i];
            if (eachTypeCount[sushiType] == 0) {
                currentKindCount++;
            }
            eachTypeCount[sushiType]++;
        }

        int maxSushiKindCount = currentKindCount;
        if (eachTypeCount[c] == 0) {
            maxSushiKindCount++;
        }

        for (int i = 1; i < n; i++) {
            int removeSushi = belt[start];
            eachTypeCount[removeSushi]--;
            if (eachTypeCount[removeSushi] == 0) {
                currentKindCount--;
            }

            start++;
            end = (end + 1) % n;

            int addSushi = belt[end];
            if (eachTypeCount[addSushi] == 0) {
                currentKindCount++;
            }
            eachTypeCount[addSushi]++;

            int kind = currentKindCount;
            if (eachTypeCount[c] == 0) {
                kind++;
            }
            maxSushiKindCount = Math.max(maxSushiKindCount, kind);
        }

        System.out.println(maxSushiKindCount);
    }
}